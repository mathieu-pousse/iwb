package org.iwb.business;

import java.util.List;

/**
 * Represents a product.
 */
public class Product extends AbstractIDGeneratedEntity {

    private Long ean13;
    private String name;
    private String description;
    private String image;
    private List<String> tags;
    private List<Component> components;

    /**
     * Default constructor.
     */
    public Product() {
        // void
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
     * Gets tags.
     *
     * @return Value of tags.
     */
    public List<String> getTags() {
        return this.tags;
    }

    /**
     * Sets new tags.
     *
     * @param tags New value of tags.
     */
    public void setTags(final List<String> tags) {
        this.tags = tags;
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
     * Gets ean13.
     *
     * @return Value of ean13.
     */
    public Long getEan13() {
        return this.ean13;
    }

    /**
     * Sets new ean13.
     *
     * @param ean13 New value of ean13.
     */
    public void setEan13(final Long ean13) {
        this.ean13 = ean13;
    }

    /**
     * Gets components.
     *
     * @return Value of components.
     */
    public List<Component> getComponents() {
        return this.components;
    }

    /**
     * Sets new components.
     *
     * @param components New value of components.
     */
    public void setComponents(final List<Component> components) {
        this.components = components;
    }

    /**
     * Gets image.
     *
     * @return Value of image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets new image.
     *
     * @param image New value of image.
     */
    public void setImage(String image) {
        this.image = image;
    }
}
