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

        itemRepo.save(new Item(1L, "Title", "Description", true, new Date(1555), 11L));

        Iterable<Item> allItems = itemRepo.findAll();
        for (Item item : allItems) {
            System.out.println(item.getTitle());
        }

        itemRepo.deleteAll();
        itemRepo.save(new Item(2L,"1Title", "1Description", true, new Date(1555), 12L));
        itemRepo.save(new Item(3L,"2Title", "2Description", false, new Date(1666), 13L));
        itemRepo.save(new Item(4L,"3Title", "3Description", true, new Date(1777), 14L));
        itemRepo.save(new Item(5L,"4Title", "4Description", false, new Date(1888), 15L));
        allItems = itemRepo.findAll();
        for (Item item : allItems) {
            System.out.println(item.getTitle());
        }

        //context.close();
    }
}