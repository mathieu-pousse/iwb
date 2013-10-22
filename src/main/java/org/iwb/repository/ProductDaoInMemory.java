package org.iwb.repository;

import org.iwb.bootstrap.ProfileInMemory;
import org.iwb.business.Product;
import org.springframework.stereotype.Repository;

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

