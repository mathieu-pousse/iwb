package org.iwb.transport;

import org.iwb.business.SecondLife;
import org.iwb.services.SecondLifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/second-life")
public class SecondLifeResource {

    @Autowired
    private SecondLifeService secondLifeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SecondLife findById(@PathVariable("id") final String id) {
        return this.secondLifeService.findById(id);
    }

    @RequestMapping(value = "/material/{materialId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SecondLife> findByMaterial(@PathVariable("materialId") final String materialId) {
        return this.secondLifeService.findByMaterialId(materialId);
    }

    @RequestMapping(value = "/location/{locationId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SecondLife> findByLocation(@PathVariable("locationId") final String locationId) {
        return this.secondLifeService.findByLocationId(locationId);
    }

    @RequestMapping(value = "/material/{materialId}/location/{locationId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SecondLife> findByLocation(@PathVariable("materialId") final String materialId, @PathVariable("locationId") final String locationId) {
        return this.secondLifeService.findByMaterialAndLocationId(materialId, locationId);
    }

}
