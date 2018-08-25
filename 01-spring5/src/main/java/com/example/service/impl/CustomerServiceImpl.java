package com.example.service.impl;

import com.example.persistence.entity.Customer;
import com.example.persistence.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = REQUIRED, readOnly = true)
    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = REQUIRED, readOnly = false)
    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }
}
