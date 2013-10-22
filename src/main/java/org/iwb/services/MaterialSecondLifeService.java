package org.iwb.services;

import org.iwb.business.Location;
import org.iwb.business.SecondLife;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface MaterialSecondLifeService {

    List<SecondLife> findAll(Location location);

    SecondLife findById(String location, String id);
}
