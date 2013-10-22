package org.iwb.services;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface GenericService<E> {

    List<E> findAll();

    E findById(String id);

    E save(E toSave);

    E update(E toUpdate);

    boolean delete(String entityId);
}
