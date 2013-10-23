package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class Trash extends AbstractEntityWithId {

    private String color;
    private String image;
    private String description;

    /**
     * Default constructor.
     */
    public Trash() {
        // void
    }

    /**
     * Gets image.
     *
     * @return Value of image.
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Sets new image.
     *
     * @param image New value of image.
     */
    public void setImage(final String image) {
        this.image = image;
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

    /**
     * Gets color.
     *
     * @return Value of color.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Sets new color.
     *
     * @param color New value of color.
     */
    public void setColor(final String color) {
        this.color = color;
    }
}
