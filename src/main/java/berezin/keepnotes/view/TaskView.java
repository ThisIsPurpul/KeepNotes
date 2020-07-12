package berezin.keepnotes.view;

import berezin.keepnotes.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import berezin.keepnotes.repositories.CategoryRepository;
import berezin.keepnotes.repositories.TaskRepository;
import berezin.keepnotes.entities.CategoryEntity;

import java.util.*;

@Controller
public class TaskView {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TaskRepository taskRepository;


    private Map<Long, TaskEntity> getTasks() {
        Map<Long, TaskEntity> result = new HashMap<>();

        Iterable<TaskEntity> tasks = taskRepository.findAll();

        for (TaskEntity entity : tasks) {
            result.put(entity.getId(), entity);
        }

        return result;
    }

    private Map<Long, CategoryEntity> getCategories() {
        Map<Long, CategoryEntity> result = new HashMap<>();
        result.put(0L, new CategoryEntity(("Все")));

        Iterable<CategoryEntity> categories = categoryRepository.findAll();

        for (CategoryEntity entity : categories) {
            result.put(entity.getId(), entity);
        }

        return result;
    }


    @RequestMapping(value = {"/category/{parentId}/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long id, @PathVariable Long parentId) {
        Map<Long, TaskEntity> tasks = getTasks();

        model.addAttribute("tasks", tasks.values());

        return "category";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public String taskForm(Model model) {
        model.addAttribute("addTask", new TaskEntity());
        return "addTask";
    }

    @RequestMapping(value = {"/addTask"}, method = RequestMethod.POST)
    public String taskSubmit(@ModelAttribute TaskEntity addTask, Model model) {
        if (StringUtils.hasText(addTask.getTitle()) && addTask.getParentId() != null) {

            List<TaskEntity> tasks = categoryRepository.findCtgById(addTask.getParentId()).getTasks();
            tasks.add(addTask);
            getCategories().get(addTask.getParentId()).setTasks(tasks);

            addTask.setCtg(categoryRepository.findCtgById(addTask.getParentId()));

            taskRepository.save(addTask);

        }
        return "redirect:/category/" + addTask.getParentId();
    }

    @RequestMapping(value = {"/deleteTask"}, method = RequestMethod.POST)
    public String taskDelete(@ModelAttribute TaskEntity deleteTask, Model model) {
        System.out.println(deleteTask.getId());
        System.out.println(deleteTask.getParentId());
        System.out.println(taskRepository.findTaskById(deleteTask.getId()));

        //taskRepository.delete(taskRepository.findTaskById(deleteTask.getId()));

        taskRepository.deleteById(deleteTask.getId());
        System.out.println(taskRepository.findTaskById(deleteTask.getId()));

        if (deleteTask.getParentId() != null) {
            return "redirect:/category/" + deleteTask.getParentId();
        }
        return "redirect:/category/";
    }

    @RequestMapping(value = {"/redactTask"}, method = RequestMethod.POST)
    public String redTask(@ModelAttribute TaskEntity rdctTask, Model model) {
        if (StringUtils.hasText(rdctTask.getTitle())) {
            taskRepository.findTaskById(rdctTask.getId()).setTitle(rdctTask.getTitle());
            taskRepository.findTaskById(rdctTask.getId()).setDescription(rdctTask.getDescription());
        }
        return "redirect:/category/" + rdctTask.getParentId();
    }
}



