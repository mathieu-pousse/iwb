package org.iwb.transport;

import org.iwb.business.Location;
import org.iwb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/location")
public class LocationResource {

    @Autowired
    private LocationService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Location> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Location> search(@RequestParam("q") String query) {
        return this.service.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public Location setLocalisation(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

}
