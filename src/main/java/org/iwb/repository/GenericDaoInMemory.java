package org.iwb.repository;

import com.google.common.hash.Hashing;
import org.iwb.business.AbstractEntityWithId;
import org.iwb.services.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.iwb.business.DynamicConfigurationProperty.property;

/**
 * A generic implementation of a restful dao working in memory.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class GenericDaoInMemory<E extends AbstractEntityWithId> implements GenericDao<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericDaoInMemory.class);
    protected final Map<String, E> sink = new ConcurrentHashMap<>();
    private final String type;
    private AtomicLong sequence = new AtomicLong();

    @Autowired
    private ConfigurationManager configuration;

    /**
     * Default constructor.
     */
    public GenericDaoInMemory() {
        Class<?> implementation = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.type = implementation.getSimpleName();
        LOGGER.debug("initializing generic dao for {}", this.type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> findAll() {
        LOGGER.debug("returning the list of all {} ({} items)", this.type, this.sink.size());
        return new ArrayList<>(this.sink.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E findById(final String id) {
        E entity = this.sink.get(id);
        LOGGER.debug("looking for {} with id and return {}", this.type, id, entity == null);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E save(final E entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() != null) {
            // means update...
            return this.update(entity);
        }
        entity.setId(this.type + "-" + this.sequence.incrementAndGet());

        if (!this.configuration.getAsBoolean(property("hash." + this.type.toLowerCase() + ".preserve", false))) {
            entity.setId(Hashing.sha1().hashString(entity.getId(), Charset.forName("UTF-8")).toString());
        }
        LOGGER.info("creating new {} with id {}", this.type, entity.getId());
        this.sink.put(entity.getId(), entity);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E update(final E entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() == null) {
            return this.save(entity);
        }
        LOGGER.info("updating {} with id {}", this.type, entity.getId());
        this.sink.put(entity.getId(), entity);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(final String entityId) {
        if (entityId == null) {
            return false;
        }
        boolean deleted = this.sink.remove(entityId) != null;
        LOGGER.info("deleting {} with id {} and return {}", this.type, entityId, deleted);
        return deleted;
    }
}
