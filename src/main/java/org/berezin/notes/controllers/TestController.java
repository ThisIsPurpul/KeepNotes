package org.berezin.notes.controllers;

import org.berezin.notes.entities.Item;
import org.berezin.notes.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private ItemRepo itemRepo;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        Iterable<Item> items = itemRepo.findAll();

        model.addAttribute("items", items);
        return "greeting";
    }

}
