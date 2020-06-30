package org.berezin.notes;

import org.berezin.notes.entities.Item;
import org.berezin.notes.repositories.ItemRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@EnableAutoConfiguration
public class MainApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class);

        ItemRepo itemRepo = context.getBean(ItemRepo.class);

        itemRepo.save(new Item("Title", "Description", true, new Date(1555), 1555L));

        Iterable<Item> allItems = itemRepo.findAll();
        for (Item item : allItems) {
            System.out.println(item.getTitle());
        }

        itemRepo.deleteAll();
        itemRepo.save(new Item("newTitle", "newDescription", true, new Date(1555), 1666L));
        allItems = itemRepo.findAll();
        for (Item item : allItems) {
            System.out.println(item.getTitle());
        }

        context.close();
    }
}