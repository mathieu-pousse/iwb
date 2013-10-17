package org.iwb.transport;

import org.iwb.business.Location;
import org.iwb.business.User;
import org.iwb.services.LocationService;
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
@RequestMapping(value = "/user")
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/authenticate/{email}", method = RequestMethod.GET)
    public User authenticate(HttpSession session, @PathVariable("email") String email) {
        User current = (User) session.getAttribute("user");
        User authenticated = new User();
        authenticated.setEmail(email);
        session.setAttribute("user", authenticated);
        if (current != null && current.getEmail() == null) {
            // he was anonymous, copy its preferences
            authenticated.setLocation(current.getLocation());
        }
        return authenticated;
    }

    @RequestMapping(value = "/localize/{location}", method = RequestMethod.PUT)
    public Location localize(HttpSession session, @PathVariable("location") String locationId) {
        Location l = this.locationService.findById(locationId);
        if (l == null) {
            LOGGER.warn("unable to set user location to {}", locationId);
            return null;
        }

        User current = (User) session.getAttribute("user");
        if (current == null) {
            // create an anonymous user
            current = new User();
            session.setAttribute("user", current);
        }
        current.setLocation(current.getLocation());
        return l;
    }

}
