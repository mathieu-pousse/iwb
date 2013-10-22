package org.iwb.transport;

import org.iwb.services.FileSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Controller
@RequestMapping(value = "/images")
public class ImageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageResource.class);
    @Autowired
    private FileSystemService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> load(@PathVariable("id") String id) {
        LOGGER.debug("loading images/{}", id);
        try {
            byte[] buffer = this.service.load("images", id);
            ResponseEntity<byte[]> response = new ResponseEntity<>(buffer, HttpStatus.OK);
            // TODO add cache support to save bandwidth (it costs !)
            return response;
        } catch (IOException ioe) {
            LOGGER.warn("error while retrieving '" + id + "'", ioe);
        }

        // not found...
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
