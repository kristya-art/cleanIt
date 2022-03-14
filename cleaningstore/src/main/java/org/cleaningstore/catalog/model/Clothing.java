package org.cleaningstore.catalog.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="clothing")
public class Clothing extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ClothingType type;

    public Clothing(Material material, BigDecimal price, ClothingType type) {
        super(material, price);
        this.type = type;
    }

    public Clothing() {

    }

    public ClothingType getType() {
        return type;
    }

    public void setType(ClothingType type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
