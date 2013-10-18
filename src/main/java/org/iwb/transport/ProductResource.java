package org.iwb.transport;

import com.google.common.base.Strings;
import org.iwb.business.Product;
import org.iwb.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> search(@RequestParam("q") String query) {
        if (Strings.isNullOrEmpty(query)) {
            LOGGER.warn("no search query...");
            return Collections.emptyList();
        }
        LOGGER.debug("search for products w/ query '{}'", query);
        return this.service.search(query);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product id(@PathVariable("id") Long id) {
        LOGGER.debug("FETCHING product w/ id '{}'", id);
        return this.service.findById(id);
    }


}
