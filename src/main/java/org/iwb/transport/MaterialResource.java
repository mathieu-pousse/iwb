package org.iwb.transport;

import org.iwb.business.Material;
import org.iwb.services.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/materials")
public class MaterialResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialResource.class);
    private MaterialService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Material> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Material findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

}
