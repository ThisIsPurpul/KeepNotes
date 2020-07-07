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

import java.util.HashMap;
import java.util.Map;

@Controller
public class CategoryView {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = {"/", "/category"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, CategoryEntity> categories = getCategories();
        Map<Long, TaskEntity> tasks = getTasks();

        model.addAttribute("categories", categories.values());
        model.addAttribute("currentCategory", categories.get(0L));
        model.addAttribute("tasks", tasks.values());
        return "category";
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long id){
        Map<Long, CategoryEntity> categories = getCategories();
        Map<Long, TaskEntity> tasks = getTasks();

        model.addAttribute("categories", categories.values());
        model.addAttribute("currentCategory", categories.get(id));
        model.addAttribute("tasks", tasks.values());
        return "category";
    }

    private Map<Long, CategoryEntity> getCategories(){
        Map<Long, CategoryEntity> result = new HashMap<>();
        result.put(0L, new CategoryEntity(("Все")));

        Iterable<CategoryEntity> categories = categoryRepository.findAll();

        for (CategoryEntity entity: categories){
            result.put(entity.getId(), entity);
        }

        return result;
    }
    private Map<Long, TaskEntity> getTasks() {
        Map<Long, TaskEntity> result = new HashMap<>();

        Iterable<TaskEntity> tasks = taskRepository.findAll();

        for (TaskEntity entity : tasks) {
            result.put(entity.getId(), entity);
        }

        return result;
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String categoryForm(Model model) {
        model.addAttribute("addCategory", new CategoryEntity());
        return "addCategory";
    }

    @RequestMapping(value = {"/addCategory"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute CategoryEntity addСategory, Model model){
        if (StringUtils.hasText(addСategory.getName())){
            CategoryEntity result = categoryRepository.save(new CategoryEntity(addСategory.getName()));
            Long id = result.getId();
            return "redirect:/category/" + id;
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/category/deleteCategory/{id}", method = RequestMethod.POST)
    public String categoryDelete(@ModelAttribute CategoryEntity deleteCategory, Model model){
        categoryRepository.delete(deleteCategory);
        return "redirect:/category";
    }


}