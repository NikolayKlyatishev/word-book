package ru.nklyatyshev.demo.wordbook.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.nklyatyshev.demo.wordbook.entity.Customer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerDao extends
        CrudRepository<Customer, UUID>,
        PagingAndSortingRepository<Customer, UUID> {

    Optional<Customer> findByName(String name);
}
