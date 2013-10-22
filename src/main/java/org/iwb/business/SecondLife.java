package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class SecondLife extends AbstractIDGeneratedEntity {

    private String material;
    private String bin;

    /**
     * Default constructor.
     */
    public SecondLife() {
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
