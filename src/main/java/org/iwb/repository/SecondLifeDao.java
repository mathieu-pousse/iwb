package org.iwb.repository;

import org.iwb.business.SecondLife;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface SecondLifeDao extends GenericDao<SecondLife> {

    List<SecondLife> findByMaterialId(String materialId);

    List<SecondLife> findByLocationId(String locationId);

    List<SecondLife> findByMaterialAndLocationId(String materialId, String locationId);

}
