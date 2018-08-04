package com.storemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "productname")
    private String productname;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    protected ProductDetails() {

    }

    public ProductDetails(String productname, String category, int quantity, int price) {
        this.productname = productname;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("ProductDetails[id=%d, productname='%s', category='%s', quantity=%d, price=%d]", id,
                productname, category, quantity, price);
    }
}
