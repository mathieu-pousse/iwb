package org.iwb.services;

import org.iwb.business.Location;
import org.iwb.business.Material;
import org.iwb.business.MaterialSecondLife;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface MaterialSecondLifeService {

    List<MaterialSecondLife> findAll(Location location);

    MaterialSecondLife findById(String location, String id);
}
