package org.cleaningstore.catalog.model;


import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public class Product {

    private String title;

    @Enumerated(EnumType.STRING)
    private Material material;

    private BigDecimal price;

    private String imageUrl;

    public Product(String title, Material material, BigDecimal price) {
        this.title = title;
        this.material = material;
        this.price = price;

    }
    public Product(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
