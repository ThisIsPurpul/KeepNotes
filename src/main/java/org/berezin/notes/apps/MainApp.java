package org.berezin.notes.apps;

import org.berezin.notes.entity.Item;
import org.berezin.notes.repositories.ItemRepo;
import org.berezin.notes.repositories.TagRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

public class MainApp /*extends SpringBootServletInitializer*/ {
    public static void main(String[] args) {
        SpringApplication.run(org.berezin.notes.apps.MainApp.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class);

        ItemRepo itemRepo = context.getBean(ItemRepo.class);
        //TagRepo tagRepo = context.getBean(TagRepo.class);

        itemRepo.save(new Item("Title", "Description", true, new Date(1555), 1555L));

        Iterable<Item> allItems = itemRepo.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Item item : allItems) {
            System.out.println(item);
        }
        System.out.println();

        itemRepo.deleteAll();
        itemRepo.save(new Item("newTitle", "newDescription", true, new Date(1555), 1666L));
        allItems = itemRepo.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Item item : allItems) {
            System.out.println(item);
        }
        System.out.println();


    }
}