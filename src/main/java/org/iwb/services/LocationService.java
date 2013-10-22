package org.iwb.services;

import org.iwb.business.Location;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface LocationService extends GenericService<Location> {


    /**
     * Returns the list of location matching the specified gps coordinate.
     *
     * @param longitude the longitude
     * @param latitude  the latitude
     * @return See description.
     */
    List<Location> localize(Double longitude, Double latitude);

    /**
     * Returns the locations matching the specified zip code.
     *
     * @param zip the zip code
     * @return See description.
     */
    List<Location> localize(Integer zip);

    /**
     * Search the location with the specified query.
     *
     * @param query the query
     * @return See description.
     */
    List<Location> search(String query);
}
