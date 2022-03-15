package org.cleaningstore.catalog.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="clothing")
public class Clothing extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public Clothing(String title, Material material, BigDecimal price) {
        super(title,material, price);

    }

    public Clothing() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
