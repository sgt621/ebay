package com.sghazi.ebay.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="item_id", unique=true, nullable=false)
    private Long itemID;
    @Column
    private String title;
    @Column
    private String condition;
    @Column
    private BigDecimal price;
    @Column
    private Integer quantity;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="item")
    @JsonManagedReference
    private Set<ImageURL> imageUrl;
    @Column
    private String itemSpecifics;
    @Column
    private String description;

    public Item() {
    }

    public Item(Long itemID, String title, String condition, BigDecimal price, Integer quantity, Set<ImageURL> imageUrl, String itemSpecifics, String description) {
        this.itemID = itemID;
        this.title = title;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.itemSpecifics = itemSpecifics;
        this.description = description;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public void setImageUrl(Set<ImageURL> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<ImageURL> getImageUrl() {
        return imageUrl;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemSpecifics() {
        return itemSpecifics;
    }

    public void setItemSpecifics(String itemSpecifics) {
        this.itemSpecifics = itemSpecifics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
