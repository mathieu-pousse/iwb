package org.iwb.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * In memory implementation of the LocationDao.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class LocationDaoInMemory extends GenericDaoInMemory<Location> implements LocationDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> findByZipCode(final Integer zip) {
        return Lists.newArrayList(Collections2.filter(findAll(), new Predicate<Location>() {
            @Override
            public boolean apply(final Location location) {
                return location != null && location.getZips().contains(zip);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> search(final String query) {
        final String[] tokens = query.toLowerCase().split(" ");
        return Lists.newArrayList(Collections2.filter(findAll(), new Predicate<Location>() {
            @Override
            public boolean apply(final Location location) {
                if (location == null) {
                    return false;
                }
                for (final String token : tokens) {
                    try {
                        Integer asZipCode = Integer.parseInt(token);
                        if (location.getZips().contains(asZipCode)) {
                            return true;
                        }
                    } catch (NumberFormatException nfe) {
                        // ok...
                    }
                    if (location.getName().toLowerCase().contains(token) || //
                            location.getDescription().toLowerCase().contains(token)) {
                        return true;
                    }
                }
                return false;
            }
        }));
    }
}
