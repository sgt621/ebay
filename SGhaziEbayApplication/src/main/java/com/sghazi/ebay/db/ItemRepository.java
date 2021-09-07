package com.sghazi.ebay.db;

import com.sghazi.ebay.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
