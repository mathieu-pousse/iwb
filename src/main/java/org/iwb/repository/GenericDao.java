package org.iwb.repository;

import org.iwb.business.AbstractIDGeneratedEntity;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface GenericDao<E extends AbstractIDGeneratedEntity> {

    List<E> findAll();

    E findById(String id);

    E save(E toSave);

    E update(E toUpdate);

    boolean delete(String entityId);

}
