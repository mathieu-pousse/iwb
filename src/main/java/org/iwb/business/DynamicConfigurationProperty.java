package org.iwb.business;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public final class DynamicConfigurationProperty implements ConfigurationProperty {

    /**
     * Holds the dynamic configuration properties that have been registered.
     */
    public static final Map<String, ConfigurationProperty> PROPERTIES = new HashMap<>();

    /**
     * Creates or reuses {@link DynamicConfigurationProperty}.
     *
     * @param key the property key
     * @return the initialized property
     */
    public static ConfigurationProperty property(final String key) {
        return property(key, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "DYNAMIC_" + getKey();
    }

    /**
     * Creates a {@link DynamicConfigurationProperty}.
     *
     * @param key          the property key
     * @param defaultValue the property default value
     * @return the initialized property
     */
    public static ConfigurationProperty property(final String key, final Object defaultValue) {
        if (!PROPERTIES.containsKey(key)) {
            PROPERTIES.put(key, new DynamicConfigurationProperty(key, defaultValue));
        }
        return PROPERTIES.get(key);
    }

    private final String key;

    private final Object defaultValue;

    /**
     * Default constructor.
     *
     * @param key          the property key
     * @param defaultValue the property default value
     */
    private DynamicConfigurationProperty(final String key, final Object defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey() {
        return this.key;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getDefaultValue() {
        return this.defaultValue;
    }

}
