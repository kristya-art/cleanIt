package org.cleaningstore.catalog.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="home_textile")
public class HomeTextile extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public HomeTextile(Material material, BigDecimal price) {

    }

    public HomeTextile() {
        super();
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
