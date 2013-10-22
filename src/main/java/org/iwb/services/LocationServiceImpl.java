package org.iwb.services;

import org.iwb.business.Location;
import org.iwb.repository.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * In memory implementation of the LocationService.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao dao;

    /**
     * {@inheritDoc}
     */
    @Override
    public Location save(Location toSave) {
        return this.dao.save(toSave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location update(Location toUpdate) {
        return this.dao.update(toUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String entityId) {
        return this.dao.delete(entityId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> findAll() {
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> localize(final Double longitude, final Double latitude) {
        // FIXME implement me
        return this.dao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> localize(final Integer zip) {
        return this.dao.findByZipCode(zip);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location findById(final String id) {
        return this.dao.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> search(final String query) {
        return this.dao.search(query);
    }
}
