package org.iwb.services;

import org.iwb.business.SecondLife;
import org.iwb.repository.SecondLifeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class SecondLifeServiceImpl implements SecondLifeService {

    @Autowired
    private SecondLifeDao dao;

    /**
     * {@inheritDoc}
     */
    @Override
    public SecondLife save(final SecondLife toSave) {
        return this.dao.save(toSave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecondLife update(final SecondLife toUpdate) {
        return this.dao.update(toUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(final String entityId) {
        return this.dao.delete(entityId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findAll() {
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecondLife findById(final String id) {
        return this.dao.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findByMaterialId(final String materialId) {
        return this.dao.findByMaterialId(materialId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findByLocationId(final String locationId) {
        return this.dao.findByLocationId(locationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findByMaterialAndLocationId(final String materialId, final String locationId) {
        return this.dao.findByMaterialAndLocationId(materialId, locationId);
    }
}
