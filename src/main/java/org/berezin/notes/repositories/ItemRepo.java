package org.berezin.notes.repositories;

import org.berezin.notes.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Long> {
    List<Item> findByTitle(String title);
    List<Item> findByTagId(Long tagId);
}
