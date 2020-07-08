package berezin.keepnotes.repositories;

import berezin.keepnotes.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();

    CategoryEntity findCtgById(Long id);
}
