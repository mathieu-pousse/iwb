package org.iwb.services;

import org.iwb.business.Location;
import org.iwb.business.MaterialSecondLife;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class MaterialSecondLifeServiceImpl implements MaterialSecondLifeService {
    @Override
    public List<MaterialSecondLife> findAll(Location location) {
        return null;
    }

    @Override
    public MaterialSecondLife findById(String location, String id) {
        return null;
    }
}
