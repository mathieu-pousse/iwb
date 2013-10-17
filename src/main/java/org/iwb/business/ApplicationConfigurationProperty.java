package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public enum ApplicationConfigurationProperty implements ConfigurationProperty {
    APPLICATION_PROFILE("application.profile", "local");

    private String key;
    private Object defaultValue;

    /**
     * Default constructor.
     */
    private ApplicationConfigurationProperty(String key, Object defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Object getDefaultValue() {
        return this.defaultValue;
    }
}
