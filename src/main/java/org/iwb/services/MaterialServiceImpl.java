package org.iwb.services;

import org.iwb.business.Material;
import org.iwb.repository.MaterialDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDao dao;

    @Override
    public List<Material> findAll() {
        return dao.findAll();
    }

    @Override
    public Material findById(String id) {
        return dao.findById(id);
    }
}
