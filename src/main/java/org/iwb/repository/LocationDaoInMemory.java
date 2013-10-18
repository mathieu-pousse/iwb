package org.iwb.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import javafx.geometry.Pos;
import org.apache.commons.io.HexDump;
import org.codehaus.jackson.map.ser.std.IterableSerializer;
import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Location;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In memory implementation of the LocationDao.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class LocationDaoInMemory implements LocationDao {

    private Map<String, Location> inMemory = new ConcurrentHashMap<>();

    /**
     * Initialize the memory with some values.
     */
    @PostConstruct
    public void initialize() {
        push("Rennes", "Rennes Metropole", 35000, 35100);
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
     */
    private void push(String name, String description, Integer... zips) {
        Location location = new Location();
        location.setId(Long.valueOf(Hashing.sha1().hashString(name, Charset.defaultCharset()).asLong()).toString());
        location.setName(name);
        location.setDescription(description);
        location.setZips(Arrays.asList(zips));
        inMemory.put(location.getId(), location);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> findAll() {
        return new ArrayList(this.inMemory.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location findById(String id) {
        return this.inMemory.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> findByZipCode(final Integer zip) {
        return new ArrayList<>(Collections2.filter(inMemory.values(), new Predicate<Location>() {
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
        return new ArrayList<>(Collections2.filter(inMemory.values(), new Predicate<Location>() {
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
