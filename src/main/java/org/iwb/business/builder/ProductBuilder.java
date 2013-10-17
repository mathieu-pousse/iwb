package org.iwb.business.builder;

import org.iwb.business.Product;

import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class ProductBuilder {
    private Long id;
    private Long ean13;
    private String name;
    private String description;
    private String pathToPicture;
    private List<String> tags;

    private ProductBuilder() {
    }

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withEan13(Long ean13) {
        this.ean13 = ean13;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder withPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
        return this;
    }

    public ProductBuilder withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setId(this.id);
        product.setEan13(this.ean13);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPathToPicture(this.pathToPicture);
        product.setTags(this.tags);
        return product;
    }
}
