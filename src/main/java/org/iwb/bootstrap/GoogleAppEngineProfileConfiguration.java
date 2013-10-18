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
@ProfileGAE
public class GoogleAppEngineProfileConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleAppEngineProfileConfiguration.class);

    /**
     * Default constructor.
     */
    public GoogleAppEngineProfileConfiguration() {
        LOGGER.info("loading 'google-app-engine' configuration");
    }

}
