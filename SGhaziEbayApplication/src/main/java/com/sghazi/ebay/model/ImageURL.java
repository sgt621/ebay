package com.sghazi.ebay.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="image_url")
public class ImageURL {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="image_url_id", unique=true)
    private Long imageUrlID;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_id", nullable=false)
    @JsonBackReference
    private Item item;
    @Column
    private String imageURL;

    public ImageURL() {
    }

    public ImageURL(Long imageUrlID, Item item, String imageURL) {
        this.imageUrlID = imageUrlID;
        this.item = item;
        this.imageURL = imageURL;
    }

    public Long getImageUrlID() {
        return imageUrlID;
    }

    public void setImageUrlID(Long imageUrlID) {
        this.imageUrlID = imageUrlID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
