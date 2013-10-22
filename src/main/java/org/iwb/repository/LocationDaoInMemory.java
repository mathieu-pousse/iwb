package org.iwb.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Location;
import org.iwb.business.Trash;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
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
        return new ArrayList<>(Collections2.filter(findAll(), new Predicate<Location>() {
            @Override
            public boolean apply(Location location) {
                return location != null && location.getZips().contains(zip);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> search(String query) {
        final String[] tokens = query.toLowerCase().split(" ");
        return new ArrayList<>(Collections2.filter(findAll(), new Predicate<Location>() {
            @Override
            public boolean apply(Location location) {
                if (location == null) {
                    return false;
                }
                for (String token : tokens) {
                    try {
                        Integer asZipCode = Integer.parseInt(token);
                        if (location.getZips().contains(asZipCode)) {
                            return true;
                        }
                    } catch (NumberFormatException nfe) {
                        // ok...
                    }
                    return location.getName().toLowerCase().contains(token) || //
                            location.getDescription().toLowerCase().contains(token);
                }
                return false;
            }
        }));
    }
}
