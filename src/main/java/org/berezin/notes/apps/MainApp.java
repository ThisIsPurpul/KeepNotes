package org.berezin.notes.apps;

import org.berezin.notes.entitys.Item;
import org.berezin.notes.repositories.ItemRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@EnableAutoConfiguration
public class MainApp /*extends SpringBootServletInitializer*/ {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class);

        ItemRepo itemRepo = context.getBean(ItemRepo.class);
        //TagRepo tagRepo = context.getBean(TagRepo.class);

        itemRepo.save(new Item("Title", "Description", true, new Date(1555), 1555L));

        Iterable<Item> allItems = itemRepo.findAll();
        System.out.println("Items found with findAll():");
        System.out.println("-------------------------------");
        for (Item item : allItems) {
            System.out.println(item);
        }
        System.out.println();

        itemRepo.deleteAll();
        itemRepo.save(new Item("newTitle", "newDescription", true, new Date(1555), 1666L));
        allItems = itemRepo.findAll();
        System.out.println("Items found with findAll():");
        System.out.println("-------------------------------");
        for (Item item : allItems) {
            System.out.println(item);
        }
        System.out.println();

        context.close();
    }
}