package org.iwb.repository;

import org.junit.Test;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class LocationDaoInMemoryTest extends GenericDaoInMemoryTest {

    @Override
    protected GenericDaoInMemory getDaoToTest() {
        return new LocationDaoInMemory();
    }

    @Test
    public void testLatest() throws Exception {

    }

    @Test
    public void testSearch() throws Exception {

    }
}
