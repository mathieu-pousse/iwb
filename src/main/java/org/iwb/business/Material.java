package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class Material {

    private String id;
    private String name;
    private String description;

    /**
     * Default constructor.
     */
    public Material() {
        // void
    }

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

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }
}
