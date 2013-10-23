package org.iwb.business;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class SecondLife extends AbstractEntityWithId {

    private String locationId;
    private String materialId;
    private String trash;

    /**
     * Default constructor.
     */
    public SecondLife() {
        // void
    }

    public String getLocationId() {
        return this.locationId;
    }

    public void setLocationId(final String locationId) {
        this.locationId = locationId;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public void setMaterialId(final String materialId) {
        this.materialId = materialId;
    }

    public String getTrash() {
        return this.trash;
    }

    public void setTrash(final String trash) {
        this.trash = trash;
    }
}
