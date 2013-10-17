package org.iwb.repository;

import org.iwb.business.Material;
import org.iwb.business.builder.MaterialBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
public class MaterialDaoInMemory implements MaterialDao {

    private Map<String, Material> sink = new ConcurrentHashMap<>();

    private Material push(Material m) {
        this.sink.put(m.getId(), m);
        return m;
    }

    /**
     * Initialize with fake data.
     */
    @PostConstruct
    public void initialize() {
        push(MaterialBuilder.aMaterial().withId("1").withName("Emballage carton").build());
        push(MaterialBuilder.aMaterial().withId("2").withName("Barquette plastique").build());
        push(MaterialBuilder.aMaterial().withId("3").withName("Film plastique").build());
        push(MaterialBuilder.aMaterial().withId("4").withName("Nouriture").build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Material> findAll() {
        return new ArrayList<>(this.sink.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Material findById(String id) {
        return this.sink.get(id);
    }
}

