package org.iwb.repository;

import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.SecondLife;
import org.springframework.stereotype.Repository;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class SecondLifeDaoInMemory extends GenericDaoInMemory<SecondLife> implements SecondLifeDao {

}
