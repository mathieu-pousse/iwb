package org.iwb.services;

import org.iwb.business.Product;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface ProductService extends GenericService<Product> {

    List<Product> latest();

    /**
     * Execute the search query and returns the list of corresponding products.
     *
     * @param query the search query
     * @return See description.
     */
    List<Product> search(String query);

}
