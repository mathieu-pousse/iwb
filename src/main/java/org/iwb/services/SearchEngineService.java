package org.iwb.services;

import org.iwb.business.Product;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface SearchEngineService {

    /**
     * Suggests an autocompletion for the curently partial search query.
     *
     * @param partial the partial search query
     * @return See description.
     */
    List<String> autocomplete(String partial);

    /**
     * Search for products.
     *
     * @param query the search query
     * @return See description.
     */
    List<Product> searchForProduct(String query);
}
