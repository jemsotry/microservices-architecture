package com.soagrowers.productquery.domain;


import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ben on 07/10/15.
 */
//@Entity
@Entity
@Table(name = "product")
public class Product {
	
    private static final AtomicLong count = new AtomicLong(0);

    //@Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 32)
    private String name;
    
    
    private boolean saleable;
    
    @NotNull
    @DecimalMin("0")
    private BigDecimal currentPrice;
    
    @NotNull
    @Size(min = 2, max = 50)
    private String description;

    private Long lastUpdate;

    public Product() {
    	this.id = count.incrementAndGet();
        this.lastUpdate = System.currentTimeMillis();
    }

    public Product(Long id, String name, BigDecimal currentPrice, String description, boolean saleable) {
    	this.id = count.incrementAndGet();
    	this.name = name;
        this.currentPrice = currentPrice;
        this.description = description;
        this.lastUpdate = System.currentTimeMillis();
        this.saleable = saleable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSaleable() {
        return saleable;
    }

    public void setSaleable(boolean saleable) {
        this.saleable = saleable;
    }
    
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (currentPrice != null ? !currentPrice.equals(product.currentPrice) : product.currentPrice != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return lastUpdate != null ? lastUpdate.equals(product.lastUpdate) : product.lastUpdate == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (currentPrice != null ? currentPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    public Product clone() {
        Product s = new Product();
        s.setId(this.id);
        s.setName(this.name);
        s.setCurrentPrice(this.currentPrice);
        s.setDescription(this.description);
        s.setLastUpdate(this.getLastUpdate());
        return s;
    }
}
