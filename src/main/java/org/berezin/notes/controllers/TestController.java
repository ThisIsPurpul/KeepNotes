package org.berezin.notes.controllers;

import org.berezin.notes.entities.Item;
import org.berezin.notes.entities.Tag;
import org.berezin.notes.repositories.ItemRepo;
import org.berezin.notes.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private TagRepo tagRepo;
    private ItemRepo itemRepo;

    @RequestMapping(value = "/test-page", method = RequestMethod.GET)
    public String getIndex(Model model) {
        Iterable<Tag> tags = tagRepo.findAll();

        System.out.println(tags);

        model.addAttribute("tags", tags);

        return "tag";
    }

    @GetMapping("/tag/{id}")
    public String getItems(@PathVariable Long id, Model model){
        Iterable<Item> items = itemRepo.findByTagId(id);

        model.addAttribute("items", items);
        return "item";
    }

}
