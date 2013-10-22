package org.iwb.repository;

import org.iwb.business.Product;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface ProductDao extends GenericDao<Product> {

    /**
     * Returns the latest products.
     *
     * @return See description.
     */
    List<Product> latest(Integer startAt, Integer limit);

    /**
     * Search for a product.
     *
     * @param query the query
     * @return See description.
     */
    List<Product> search(String query);

}
