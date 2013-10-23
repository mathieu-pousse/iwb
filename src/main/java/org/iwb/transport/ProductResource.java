package org.iwb.transport;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.iwb.business.Product;
import org.iwb.services.LocationService;
import org.iwb.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/products")
public class ProductResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService service;

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> search(@RequestParam("q") final String query) {
        if (Strings.isNullOrEmpty(query)) {
            LOGGER.warn("no search query...");
            return Collections.emptyList();
        }
        return this.service.search(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product id(@PathVariable("id") final String id) {
        return this.service.findById(id);
    }

    @RequestMapping(value = "/{id}/location/{locationId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> details(@PathVariable("id") final String id, @PathVariable("locationId") final String locationId) {
        Product product = this.service.findByIdForLocation(id, locationId);
        if (product == null) {
            return null;
        }

        Map<String, Object> result = Maps.newHashMap();
        result.put("product", product);
        result.put("location", this.locationService.findById(locationId));

        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findAll() {
        return this.service.findAll();
    }


}
