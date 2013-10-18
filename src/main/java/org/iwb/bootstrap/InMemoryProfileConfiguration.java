package org.iwb.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Configuration
@ProfileInMemory
public class InMemoryProfileConfiguration  {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryProfileConfiguration.class);

    /**
     * Default constructor.
     */
    public InMemoryProfileConfiguration() {
        LOGGER.info("loading 'in-memory' configuration");
    }

}
