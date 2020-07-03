package berezin.keepnotes.repositories;

import org.springframework.data.repository.CrudRepository;
import berezin.keepnotes.entities.TaskEntity;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findAll();
}
