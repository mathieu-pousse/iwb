package org.iwb.repository;

import org.iwb.business.AbstractEntityWithId;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface GenericDao<E extends AbstractEntityWithId> {

    List<E> findAll();

    E findById(String id);

    E save(E toSave);

    E update(E toUpdate);

    boolean delete(String entityId);

}
