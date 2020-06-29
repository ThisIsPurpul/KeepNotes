package org.berezin.notes.repositories;

import org.berezin.notes.entitys.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepo extends CrudRepository<Tag, Long> {
    List<Tag> findByName(String name);
    Optional<Tag> findById(Long id);
}
