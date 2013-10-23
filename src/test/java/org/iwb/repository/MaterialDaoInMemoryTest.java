package org.iwb.repository;

import org.junit.Test;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class MaterialDaoInMemoryTest extends GenericDaoInMemoryTest {

    @Override
    protected GenericDaoInMemory getDaoToTest() {
        return new MaterialDaoInMemory();
    }

}
