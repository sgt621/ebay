package com.sghazi.ebay.service;

import com.sghazi.ebay.db.ItemRepository;
import com.sghazi.ebay.model.ImageURL;
import com.sghazi.ebay.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getOdd() {
        return Streamable.of(itemRepository.findAll()).toList().stream().filter(i->(i.getItemID()%2==1)).collect(Collectors.toList());
    }

    public List<Item> get() {
        List<Item> itemList = new ArrayList<Item>();
        itemRepository.findAll().forEach(itemList::add);
        return itemList;
    }
    public Item get(Long itemID) {
        return itemRepository.findById(itemID).get();
    }
    public void delete(Long itemID) {
        itemRepository.deleteById(itemID);
    }
    public void deleteAll() {
        itemRepository.deleteAll();
    }
    public void deleteAll(List<Long> itemIDList) {
        itemRepository.deleteAllById(itemIDList);
    }
    public Item update(Item item, Long itemID) {
        Set<ImageURL> imageURLSet = item.getImageUrl();
        imageURLSet.forEach(a->a.setItem(item));
        item.setItemID(itemID);
        return itemRepository.save(item);
    }
    public Item save(Item item) {
        Set<ImageURL> imageURLSet = item.getImageUrl();
        imageURLSet.forEach(a->a.setItem(item));
        return itemRepository.save(item);
    }
}
