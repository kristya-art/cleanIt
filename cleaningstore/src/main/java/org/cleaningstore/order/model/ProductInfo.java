package org.cleaningstore.order.model;

import org.cleaningstore.catalog.model.Material;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Embeddable
public class ProductInfo {

    private String title;

    @Enumerated(EnumType.STRING)
    private Material material;

    private BigDecimal price;



    public ProductInfo(String title, Material material, BigDecimal price) {
        this.title = title;
        this.material = material;
        this.price = price;

    }
    public ProductInfo(){}

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