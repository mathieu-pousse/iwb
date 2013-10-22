package org.iwb.repository;

import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Material;
import org.iwb.business.builder.MaterialBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class MaterialDaoInMemory extends GenericDaoInMemory<Material> implements MaterialDao {


    /**
     * Initialize with fake data.
     */
    @PostConstruct
    public void initialize() {
        save(MaterialBuilder.aMaterial().withId("material-0").withName("default").build());
        save(MaterialBuilder.aMaterial().withId("material-1").withName("Emballage carton").build());
        save(MaterialBuilder.aMaterial().withId("material-2").withName("Barquette plastique").build());
        save(MaterialBuilder.aMaterial().withId("material-3").withName("Film plastique").build());
        save(MaterialBuilder.aMaterial().withId("material-4").withName("Nourriture 4").build());
        save(MaterialBuilder.aMaterial().withId("material-5").withName("Nourriture 5").build());
        save(MaterialBuilder.aMaterial().withId("material-6").withName("Nourriture 6").build());
        save(MaterialBuilder.aMaterial().withId("material-7").withName("Nourriture 7").build());
        save(MaterialBuilder.aMaterial().withId("material-8").withName("Nourriture 8").build());
        save(MaterialBuilder.aMaterial().withId("material-9").withName("Nourriture 9").build());
        save(MaterialBuilder.aMaterial().withId("material-10").withName("Nourriture 10").build());
    }


}

