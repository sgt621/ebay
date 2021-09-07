package com.sghazi.ebay.controller;

import com.sghazi.ebay.model.*;
import com.sghazi.ebay.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/odd")
    public List<Item> getOdd() {
        return itemService.getOdd();
    }
    @GetMapping("/getAll")
    public List<Item> get() {
        return itemService.get();
    }
    @GetMapping("/get/{itemID}")
    public Item get(@PathVariable Long itemID) {
        return itemService.get(itemID);
    }
    @DeleteMapping(value="/delete/{itemID}")
    public void delete(@PathVariable Long itemID) {
        itemService.delete(itemID);
    }
    @DeleteMapping(value="/deleteAll")
    public void delete() {
        itemService.deleteAll();
    }
    @PutMapping(value="/update/{itemID}")
    public Item update(@PathVariable Long itemID, @RequestBody Item item) {
        return itemService.update(item, itemID);
    }
    @PostMapping(value="/save")
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }
}
