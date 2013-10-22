package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class Component {

    private String name;
    private String description;
    private String image;
    private String materialId;
    private Material material;

    /**
     * Default constructor.
     */
    public Component() {
        // void
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
     * Gets material.
     *
     * @return Value of material.
     */
    public Material getMaterial() {
        return this.material;
    }

    /**
     * Sets new material.
     *
     * @param material New value of material.
     */
    public void setMaterial(final Material material) {
        this.material = material;
    }

    /**
     * Gets materialId.
     *
     * @return Value of materialId.
     */
    public String getMaterialId() {
        return this.materialId;
    }

    /**
     * Sets new materialId.
     *
     * @param materialId New value of materialId.
     */
    public void setMaterialId(final String materialId) {
        this.materialId = materialId;
    }
}
