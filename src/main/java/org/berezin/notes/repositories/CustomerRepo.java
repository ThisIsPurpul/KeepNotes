package org.berezin.notes.repositories;

import org.berezin.notes.entitys.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String lastName);
    //Optional<Customer> findById(Long id);
}
