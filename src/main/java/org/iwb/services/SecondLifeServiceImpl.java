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
    public SecondLife save(SecondLife toSave) {
        return this.dao.save(toSave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecondLife update(SecondLife toUpdate) {
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
    public List<SecondLife> findAll() {
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecondLife findById(String id) {
        return this.dao.findById(id);
    }
}
