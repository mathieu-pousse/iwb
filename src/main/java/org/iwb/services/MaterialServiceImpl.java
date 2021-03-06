package org.iwb.services;

import org.iwb.business.Material;
import org.iwb.repository.MaterialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDao dao;

    /**
     * {@inheritDoc}
     */
    @Override
    public Material save(Material toSave) {
        return this.dao.save(toSave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Material update(Material toUpdate) {
        return this.dao.update(toUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String entityId) {
        return this.dao.delete(entityId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Material> findAll() {
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Material findById(String id) {
        return this.dao.findById(id);
    }
}
