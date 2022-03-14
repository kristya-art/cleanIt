package org.cleaningstore.catalog.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="home_textile")
public class HomeTextile extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    HomeType type;
    public HomeTextile(Material material, BigDecimal price, HomeType type) {
        super(material, price);
        this.type=type;
    }

    public HomeTextile() {
        super();
    }

    public HomeType getType() {
        return type;
    }

    public void setType(HomeType type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
