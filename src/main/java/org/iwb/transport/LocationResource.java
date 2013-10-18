package org.iwb.transport;

import org.iwb.business.Location;
import org.iwb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/locations")
public class LocationResource {

    @Autowired
    private LocationService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Location findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> search(@RequestParam("q") String query) {
        return this.service.search(query);
    }

}
