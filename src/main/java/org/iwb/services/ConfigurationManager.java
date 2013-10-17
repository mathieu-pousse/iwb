package org.iwb.services;

import org.iwb.business.ConfigurationProperty;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface ConfigurationManager {

    String getAsString(ConfigurationProperty property);

    Boolean getAsBoolean(ConfigurationProperty property);

    Integer getAsInteger(ConfigurationProperty property);


}
