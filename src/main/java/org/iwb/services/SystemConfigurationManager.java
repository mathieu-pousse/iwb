package org.iwb.services;

import org.iwb.business.ConfigurationProperty;
import org.springframework.stereotype.Service;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class SystemConfigurationManager implements ConfigurationManager {


    private String get(ConfigurationProperty property) {
        return System.getProperty(property.getKey());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAsString(ConfigurationProperty property) {
        String fConfiguration = get(property);
        return fConfiguration != null ? fConfiguration : (String) property.getDefaultValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getAsBoolean(ConfigurationProperty property) {
        String fConfiguration = get(property);
        return fConfiguration != null ? Boolean.parseBoolean(fConfiguration) : (Boolean) property.getDefaultValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getAsInteger(ConfigurationProperty property) {
        String fConfiguration = get(property);
        return fConfiguration != null ? Integer.parseInt(fConfiguration) : (Integer) property.getDefaultValue();
    }
}
