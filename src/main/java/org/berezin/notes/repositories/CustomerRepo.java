package org.berezin.notes.repositories;

import org.berezin.notes.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String lastName);
    //Optional<Customer> findById(Long id);
}
