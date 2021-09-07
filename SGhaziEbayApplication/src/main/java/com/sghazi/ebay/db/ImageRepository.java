package com.sghazi.ebay.db;

import com.sghazi.ebay.model.ImageURL;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<ImageURL, Long> {
    public List<ImageURL> findByItemItemID(Long itemID);
}
