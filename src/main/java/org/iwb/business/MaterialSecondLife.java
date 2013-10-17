package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class MaterialSecondLife {

    private Long id;
    private String material;
    private String bin;

    /**
     * Default constructor.
     */
    public MaterialSecondLife() {
        // void
    }

    /**
     * Gets bin.
     *
     * @return Value of bin.
     */
    public String getBin() {
        return bin;
    }

    /**
     * Sets new bin.
     *
     * @param bin New value of bin.
     */
    public void setBin(String bin) {
        this.bin = bin;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets material.
     *
     * @return Value of material.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets new material.
     *
     * @param material New value of material.
     */
    public void setMaterial(String material) {
        this.material = material;
    }
}
