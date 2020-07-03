package berezin.keepnotes.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        model.addAttribute("categories", categories.values());
        model.addAttribute("currentCategory", categories.get(0L));

        return "category";
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long id){
        Map<Long, CategoryEntity> categories = getCategories();

        model.addAttribute("categories", categories.values());
        model.addAttribute("currentCategory", categories.get(id));

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

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String categoryForm(Model model) {
        model.addAttribute("addCategory", new CategoryEntity());
        return "addCategory";
    }

    @RequestMapping(value = {"/addCategory"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute CategoryEntity addСategory, Model model){
        if (StringUtils.hasText(addСategory.getName())){
            categoryRepository.save(new CategoryEntity(addСategory.getName()));
        }
        return "redirect:/category";
    }

}