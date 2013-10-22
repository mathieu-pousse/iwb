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
     * Initialize the memory with some values.
     */
    @PostConstruct
    public void initialize() {
        Location rennes = push("Rennes", "Rennes Metropole", 35000, 35100);
        Trash yellow = new Trash();
        yellow.setColor("yellow");
        yellow.setDescription("save a bit the planet");
        rennes.getTrashes().add(yellow);

        push("Paris", "Paris et la courrone", 75000, 77000, 78000, 92000);
        push("Reims", "Reims Metropole", 51000);
        push("Marseille", "Marseille agglomeration", 13000);
        push("Nice", "Nice plage", 6000);
        push("Lorient", "Lorient plage", 56100);
    }

    /**
     * Add the location.
     *
     * @param name        the name
     * @param description the description
     * @param zips        the zip code
     * @return the saved location
     */
    private Location push(String name, String description, Integer... zips) {
        Location location = new Location();
        location.setName(name);
        location.setDescription(description);
        location.setZips(Arrays.asList(zips));
        Trash everything = new Trash();
        everything.setColor("black");
        everything.setDescription("everything can goes here but...");
        everything.setImage("black.png");
        location.setTrashes(Arrays.asList(everything));
        return save(location);
    }

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
        final String[] tokens = query.split(" ");
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
                    return location.getName().contains(token) || //
                            location.getDescription().contains(token);
                }
                return false;
            }
        }));
    }
}
