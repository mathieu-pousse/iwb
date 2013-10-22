package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface ConfigurationProperty {

    /**
     * {@link Enum#name()}.
     *
     * @return see description
     */
    String name();

    String getKey();

    Object getDefaultValue();
}
