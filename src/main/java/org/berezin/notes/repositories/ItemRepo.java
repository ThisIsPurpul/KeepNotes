package org.berezin.notes.repositories;

import org.berezin.notes.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepo extends CrudRepository<Item, Long> {
    List<Item> findByTitle(String title);
    List<Item> findByIsActive(String isActive);
    //todo: Поиск по тегу
    Optional<Item> findById(Long id);
}
