package org.iwb.services;

import org.iwb.business.Location;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface LocationService {

    List<Location> findAll();

    List<Location> localize(Double longitude, Double latitude);

    List<Location> localize(Integer zip);

    Location findById(String id);
}
