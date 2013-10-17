package org.iwb.business;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class Location {

    private Long id;
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
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets zips.
     *
     * @return Value of zips.
     */
    public List<Integer> getZips() {
        return zips;
    }

    /**
     * Sets new zips.
     *
     * @param zips New value of zips.
     */
    public void setZips(List<Integer> zips) {
        this.zips = zips;
    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets latitude.
     *
     * @return Value of latitude.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Gets longitude.
     *
     * @return Value of longitude.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets new longitude.
     *
     * @param longitude New value of longitude.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets new latitude.
     *
     * @param latitude New value of latitude.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
