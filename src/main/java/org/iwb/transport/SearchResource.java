package org.iwb.transport;

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
@RequestMapping(value = "/search")
public class SearchResource {

    @RequestMapping(value = "/{locationId}", method = RequestMethod.GET)
    @ResponseBody
    public void search(@PathVariable("q") String query) {

    }

}
