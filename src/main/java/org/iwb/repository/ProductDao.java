package org.iwb.repository;

import org.iwb.business.Product;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface ProductDao {

    /**
     * Returns the latest products.
     *
     * @return See description.
     */
    List<Product> latest(Integer startAt, Integer limit);

    List<Product> search(String query);

    Product store(Product product);

    Product findById(Long id);
}
