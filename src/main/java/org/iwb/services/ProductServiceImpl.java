package org.iwb.services;

import org.iwb.business.Product;
import org.iwb.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    @Override
    public List<Product> latest() {
        return this.dao.latest(0, 10);
    }

    @Override public List<Product> search(String query) {
        return this.dao.latest(0, 10);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product save(Product toSave) {
        return this.dao.save(toSave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product update(Product toUpdate) {
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
    public List<Product> findAll() {
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findById(String id) {
        return this.dao.findById(id);
    }
   
}
