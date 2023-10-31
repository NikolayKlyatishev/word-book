package ru.nklyatyshev.demo.wordbook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nklyatyshev.demo.wordbook.entity.Customer;
import ru.nklyatyshev.demo.wordbook.service.CustomerService;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class UserController {

    private final CustomerService customerService;

    @GetMapping("{id}")
    public Customer getUser(@PathVariable UUID id) {
        return customerService.getUserById(id)
                .orElseThrow();
    }

    @GetMapping("byName/{name}")
    public ResponseEntity<Customer> getUser(@PathVariable String name) {
        var customer = customerService.getByName(name);
        if (customer.isPresent()) {
            return ResponseEntity.of(customer);
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("page")
    public Page<Customer> getPage() {
        return customerService.getPage();
    }

    @PostMapping
    public void updateUser(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }
}


