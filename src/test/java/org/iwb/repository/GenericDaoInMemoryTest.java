package org.iwb.repository;

import org.iwb.business.AbstractEntityWithId;
import org.iwb.business.TestEntityWithId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Give me more!
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@RunWith(JUnit4.class)
public abstract class GenericDaoInMemoryTest<E extends AbstractEntityWithId> {

    private GenericDaoInMemory<E> toTest;

    protected abstract GenericDaoInMemory<E> getDaoToTest();

    @Before
    public void setup() {
        this.toTest = getDaoToTest();
    }

    @Test
    public void testFindAll() throws Exception {
        Assert.assertNotNull(this.toTest.findAll());
        Assert.assertEquals(0, this.toTest.findAll().size());
    }

    @Test
    public void testFindById() throws Exception {
        Assert.assertNull(this.toTest.save(null));
    }

    @Test
    public void testSave() throws Exception {
        Assert.assertNull(this.toTest.save(null));
    }

    @Test
    public void testUpdate() throws Exception {
        Assert.assertNull(this.toTest.update(null));
    }

    @Test
    public void testDelete() throws Exception {
        Assert.assertFalse(this.toTest.delete(null));
    }
}
