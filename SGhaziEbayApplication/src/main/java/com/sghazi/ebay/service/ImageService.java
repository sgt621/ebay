package com.sghazi.ebay.service;

import com.sghazi.ebay.db.ImageRepository;
import com.sghazi.ebay.db.ItemRepository;
import com.sghazi.ebay.model.ImageURL;
import com.sghazi.ebay.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ItemRepository itemRepository;

    public List<ImageURL> get() {
        List<ImageURL> imageList = new ArrayList<ImageURL>();
        imageRepository.findAll().forEach(imageList::add);
        return imageList;
    }
    public ImageURL get(Long imageUrlID) {
        return imageRepository.findById(imageUrlID).get();
    }
    public void delete(Long imageUrlID) {
        imageRepository.deleteById(imageUrlID);
    }
    public void deleteAll() {
        imageRepository.deleteAll();
    }
    public void deleteAll(List<Long> imageUrlIDList) {
        imageRepository.deleteAllById(imageUrlIDList);
    }
    public ImageURL update(ImageURL imageURL, Long imageUrlID) {
        imageURL.setImageUrlID(imageUrlID);
        ImageURL oldImage = imageRepository.findById(imageUrlID).get();
        Long itemID = oldImage.getItem().getItemID();
        imageURL.setItem(itemRepository.findById(itemID).get());
        return imageRepository.save(imageURL);
    }
    public Item update(Long itemID, List<ImageURL> imageUrlList) {
        Item item = itemRepository.findById(itemID).get();
        imageUrlList.forEach(a->a.setItem(item));
        return itemRepository.save(item);
    }
    public ImageURL update(Long imageUrlID, ImageURL imageUrl) {
        imageUrl.setImageUrlID(imageUrlID);
        return imageRepository.save(imageUrl);
    }
    public ImageURL save(Long imageUrlID, ImageURL imageUrl) {
        imageUrl.setImageUrlID(imageUrlID);
        return imageRepository.save(imageUrl);
    }
    public Item saveByItemID(Long itemID, List<ImageURL> imageUrlList) {
        Item item = itemRepository.findById(itemID).get();
        imageUrlList.forEach(a->a.setItem(item));
        return itemRepository.save(item);
    }
    public ImageURL save(ImageURL imageURL) {
        return imageRepository.save(imageURL);
    }
    public void deleteByItemID(Long itemID)
    {
        imageRepository.deleteAll(getByItemID(itemID));
    }
    public List<ImageURL> getByItemID(Long itemID) {
        return imageRepository.findByItemItemID(itemID);
    }
}
