package org.iwb.services;

import org.iwb.business.SecondLife;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface SecondLifeService extends GenericService<SecondLife> {

    List<SecondLife> findByMaterialId(String materialId);

    List<SecondLife> findByLocationId(String locationId);

    List<SecondLife> findByMaterialAndLocationId(String materialId, String locationId);
}
