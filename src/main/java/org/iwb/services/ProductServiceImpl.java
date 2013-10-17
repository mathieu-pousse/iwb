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

    @Override public Product findById(Long id) {
        return this.dao.findById(id);
    }
}
