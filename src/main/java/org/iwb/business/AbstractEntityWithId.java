package org.iwb.business;

import java.io.Serializable;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public abstract class AbstractEntityWithId implements Serializable {

    private String id;

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(final String id) {
        this.id = id;
    }
}
