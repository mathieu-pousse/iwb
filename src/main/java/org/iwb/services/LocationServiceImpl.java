package org.iwb.services;

import org.iwb.business.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Override
    public List<Location> findAll() {
        return null;
    }

    @Override
    public List<Location> localize(Double longitude, Double latitude) {
        return null;
    }

    @Override
    public List<Location> localize(Integer zip) {
        return null;
    }

    @Override
    public Location findById(String id) {
        return null;
    }
}
