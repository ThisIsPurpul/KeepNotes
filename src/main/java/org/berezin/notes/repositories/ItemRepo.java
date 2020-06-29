package org.berezin.notes.repositories;

import org.berezin.notes.entitys.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Long> {
    List<Item> findByTitle(String title);
    List<Item> findByActive(String isActive);
    List<Item> findByTagId(Long tagId);
}
