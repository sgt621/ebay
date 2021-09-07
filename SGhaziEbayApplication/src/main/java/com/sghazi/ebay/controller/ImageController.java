package com.sghazi.ebay.controller;

import com.sghazi.ebay.model.ImageURL;
import com.sghazi.ebay.model.Item;
import com.sghazi.ebay.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/imageURL")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/get/{imageUrlID}")
    public ImageURL getByImageUrlID(@PathVariable Long imageUrlID) {
        return imageService.get(imageUrlID);
    }
    @GetMapping("/getImagesByItem/{itemID}")
    public List<ImageURL> getByItemID(@PathVariable Long itemID) {
        return imageService.getByItemID(itemID);
    }
    @DeleteMapping("/deleteByImageUrlID/{imageUrlID}")
    public void deleteByImageUrlID(@PathVariable Long imageUrlID) {
        imageService.delete(imageUrlID);
    }
    @DeleteMapping("/deleteByItemID/{itemID}")
    public void deleteByItemID(@PathVariable Long itemID) {
        imageService.deleteByItemID(itemID);
    }
    @DeleteMapping("/deleteAll")
    public void delete() {
        imageService.deleteAll();
    }
    @PutMapping("/update/{imageUrlID}/{url}")
    public ImageURL updateByImageUrlID(@PathVariable Long imageUrlID, @PathVariable String url) {
        ImageURL imageUrl = new ImageURL();
        imageUrl.setImageUrlID(imageUrlID);
        imageUrl.setImageURL(url);
        return imageService.update(imageUrl, imageUrlID);
    }
}