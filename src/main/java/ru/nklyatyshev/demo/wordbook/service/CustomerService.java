package ru.nklyatyshev.demo.wordbook.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import ru.nklyatyshev.demo.wordbook.dao.CustomerDao;
import ru.nklyatyshev.demo.wordbook.entity.Customer;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public Optional<Customer> getUserById(UUID id) {
        Assert.notNull(id, "id can not be null");

        return customerDao.findById(id);
    }

    public Optional<Customer> getByName(String name) {
        return customerDao.findByName(name);
    }

    public Page<Customer> getPage() {
        return customerDao.findAll(Pageable.ofSize(25));
    }

    public void updateCustomer(Customer customer) {
        customerDao.save(customer);
    }
}
