package org.iwb.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.SecondLife;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class SecondLifeDaoInMemory extends GenericDaoInMemory<SecondLife> implements SecondLifeDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findByMaterialId(final String materialId) {
        return Lists.newArrayList(Collections2.filter(this.sink.values(), new Predicate<SecondLife>() {
            @Override
            public boolean apply(final SecondLife secondLife) {
                return secondLife != null && secondLife.getMaterialId().equals(materialId);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findByLocationId(final String locationId) {
        return Lists.newArrayList(Collections2.filter(this.sink.values(), new Predicate<SecondLife>() {
            @Override
            public boolean apply(final SecondLife secondLife) {
                return secondLife != null && secondLife.getLocationId().equals(locationId);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SecondLife> findByMaterialAndLocationId(final String materialId, final String locationId) {
        return Lists.newArrayList(Collections2.filter(this.sink.values(), new Predicate<SecondLife>() {
            @Override
            public boolean apply(final SecondLife secondLife) {
                return secondLife != null && secondLife.getMaterialId().equals(materialId) && secondLife.getLocationId().equals(locationId);
            }
        }));
    }
}
