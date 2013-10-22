package org.iwb.repository;

import org.iwb.business.Location;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface LocationDao extends GenericDao<Location> {

    /**
     * Returns the list of location matching the zip code.
     *
     * @param zip the zip code
     * @return See description.
     */
    List<Location> findByZipCode(Integer zip);

    /**
     * Searches the specified string in the locations.
     *
     * @param query the query
     * @return See description.
     */
    List<Location> search(String query);
}
