package org.iwb.transport;

import org.iwb.business.SecondLife;
import org.iwb.services.SecondLifeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/second-life")
public class SecondLifeResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondLifeResource.class);

    @Autowired
    private SecondLifeService secondLifeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SecondLife findById(@PathVariable("id") String id) {
        return this.secondLifeService.findById(id);
    }

}
