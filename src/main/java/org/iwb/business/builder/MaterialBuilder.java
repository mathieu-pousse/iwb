package org.iwb.business.builder;

import org.iwb.business.Material;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class MaterialBuilder {
    private String id;
    private String name;
    private String description;

    private MaterialBuilder() {
    }

    public static MaterialBuilder aMaterial() {
        return new MaterialBuilder();
    }

    public MaterialBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public MaterialBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MaterialBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Material build() {
        Material material = new Material();
        material.setId(this.id);
        material.setName(this.name);
        material.setDescription(this.description);
        return material;
    }
}
