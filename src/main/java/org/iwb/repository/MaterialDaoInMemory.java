package org.iwb.repository;

import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Material;
import org.springframework.stereotype.Repository;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class MaterialDaoInMemory extends GenericDaoInMemory<Material> implements MaterialDao {


}

