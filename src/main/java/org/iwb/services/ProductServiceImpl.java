package org.iwb.services;

import org.iwb.business.Component;
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

    @Autowired
    private SecondLifeService secondLifeService;

    @Override
    public List<Product> latest() {
        return this.dao.latest(0, 10);
    }

    @Override
    public List<Product> search(final String query) {
        return this.dao.latest(0, 10);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product save(final Product toSave) {
        return this.dao.save(toSave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product update(final Product toUpdate) {
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
    public List<Product> findAll() {
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findById(final String id) {
        return this.dao.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findByIdForLocation(final String id, final String locationId) {
        Product product = this.findById(id);
        if (product == null) {
            return null;
        }

        if (product.getComponents() != null) {
            for (final Component component : product.getComponents()) {
                component.setSecondLife(this.secondLifeService.findByMaterialAndLocationId(component.getMaterialId(), locationId));
            }
        }
        return product;
    }
}
