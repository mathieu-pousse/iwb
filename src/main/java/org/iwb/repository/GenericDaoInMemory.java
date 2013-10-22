package org.iwb.repository;

import com.google.common.hash.Hashing;
import org.iwb.business.AbstractIDGeneratedEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A generic implementation of a restful dao working in memory.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class GenericDaoInMemory<E extends AbstractIDGeneratedEntity> implements GenericDao<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericDaoInMemory.class);
    protected final Map<String, E> sink = new ConcurrentHashMap<>();
    private final String type;

    /**
     * Default constructor.
     */
    public GenericDaoInMemory() {
        Class<?> implementation = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.type = implementation.getSimpleName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> findAll() {
        LOGGER.debug("returning the list of all {} ({} items)", this.type, sink.size());
        return new ArrayList<>(this.sink.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E findById(String id) {
        E entity = this.sink.get(id);
        LOGGER.debug("looking for {} with id and return {}", this.type, id, entity == null);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E save(E entity) {
        if (entity.getId() != null) {
            // means update...
            return this.update(entity);
        }
        entity.setId(Hashing.sha1().hashObject(entity, null).toString());
        LOGGER.info("creating new {} with id {}", this.type, entity.getId());
        sink.put(entity.getId(), entity);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E update(E entity) {
        if (entity.getId() == null) {
            return this.save(entity);
        }
        LOGGER.info("updating {} with id {}", this.type, entity.getId());
        sink.put(entity.getId(), entity);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String entityId) {
        boolean deleted = sink.remove(entityId) != null;
        LOGGER.info("deleting {} with id {} and return {}", this.type, entityId, deleted);
        return deleted;
    }
}
