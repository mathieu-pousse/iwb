package org.iwb.repository;

import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Component;
import org.iwb.business.Product;
import org.iwb.business.builder.ProductBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Repository
@ProfileInMemory
public class ProductDaoInMemory extends GenericDaoInMemory<Product> implements ProductDao {

    @PostConstruct
    public void initialize() {
        List<String> tags = new ArrayList<>(2);
        tags.add("tag-1");
        tags.add("tag-2");
        for (long i = 0; i < 1000; i++) {
            List<Component> components = new ArrayList<>();
            for (int id = 0; id < 4; id++) {
                Component component = new Component();
                component.setName("name " + id);
                component.setDescription("description " + id);
                component.setImage("auto-generated-" + id + ".png");
                component.setMaterialId("material-" + id);
                components.add(component);
            }

            save(ProductBuilder.aProduct().withId(i)
                    .withDescription("description " + i)
                    .withEan13(3000000000000L + i)
                    .withName("name." + i)
                    .withPathToPicture("image-" + i + ".png")
                    .withTags(tags)
                    .build());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> latest(final Integer startAt, final Integer limit) {
        List<Product> generated = new ArrayList(10);

        for (long i = startAt; i < limit; i++) {
            Product spotted = this.sink.get(i);
            if (spotted != null) {
                generated.add(spotted);
            }
        }
        return generated;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> search(final String query) {
        List<Product> generated = new ArrayList(10);

        for (long i = new Random().nextInt(300); i < 10; i++) {
            Product spotted = this.sink.get(i);
            if (spotted != null) {
                generated.add(spotted);
            }
        }
        return generated;  //To change body of implemented methods use File | Settings | File Templates.
    }

}

