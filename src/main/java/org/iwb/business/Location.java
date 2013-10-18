package org.iwb.business;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class Location {

    private String id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private List<Integer> zips;

    /**
     * Default constructor.
     */
    public Location() {
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
     * Gets zips.
     *
     * @return Value of zips.
     */
    public List<Integer> getZips() {
        return this.zips;
    }

    /**
     * Sets new zips.
     *
     * @param zips New value of zips.
     */
    public void setZips(final List<Integer> zips) {
        this.zips = zips;
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
     * Gets latitude.
     *
     * @return Value of latitude.
     */
    public Double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets longitude.
     *
     * @return Value of longitude.
     */
    public Double getLongitude() {
        return this.longitude;
    }

    /**
     * Sets new longitude.
     *
     * @param longitude New value of longitude.
     */
    public void setLongitude(final Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets new latitude.
     *
     * @param latitude New value of latitude.
     */
    public void setLatitude(final Double latitude) {
        this.latitude = latitude;
    }
}
