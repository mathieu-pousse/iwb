package org.iwb.transport;

import org.iwb.business.MaterialSecondLife;
import org.iwb.business.User;
import org.iwb.services.MaterialSecondLifeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/second-life")
public class MaterialSecondLifeResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialSecondLifeResource.class);

    @Autowired
    private MaterialSecondLifeService service;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public MaterialSecondLife findById(HttpSession session, @PathVariable("id") String id) {
        User current = (User) session.getAttribute("user");
        return this.service.findById(current.getLocation(), id);
    }

}
