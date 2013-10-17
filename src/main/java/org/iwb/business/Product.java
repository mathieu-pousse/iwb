package org.iwb.business;

import java.util.List;

/**
 * Represents a product.
 */
public class Product {

    private Long id;
    private Long ean13;
    private String name;
    private String description;
    private String pathToPicture;
    private List<String> tags;

    /**
     * Default constructor.
     */
    public Product() {
        // void
    }


    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets pathToPicture.
     *
     * @return Value of pathToPicture.
     */
    public String getPathToPicture() {
        return this.pathToPicture;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return this.id;
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
     * Sets new tags.
     *
     * @param tags New value of tags.
     */
    public void setTags(final List<String> tags) {
        this.tags = tags;
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
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return this.name;
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
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(final String description) {
        this.description = description;
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
     * Sets new pathToPicture.
     *
     * @param pathToPicture New value of pathToPicture.
     */
    public void setPathToPicture(final String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }
}
