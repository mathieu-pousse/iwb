package org.iwb.repository;

import org.iwb.business.Material;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface MaterialDao {

    /**
     * Returns all the materials.
     *
     * @return See description.
     */
    List<Material> findAll();

    /**
     * Return the specified material or null if not found.
     *
     * @param id the material id
     * @return See description.
     */
    Material findById(String id);

    Material save(Material material);

    Material update(Material material);

    boolean delete(String materialId);
}
