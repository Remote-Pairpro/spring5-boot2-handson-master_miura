package com.example.service.impl;

import com.example.persistence.entity.Customer;
import com.example.persistence.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

// TODO 2-02 ビジネスロジッククラスのBeanであることを示すアノテーションを付加する

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

    // TODO 2-06 トランザクション管理アノテーションを付加する（伝播属性＝REQUIRED, 読み取り専用＝false）

    @Override
    public void save(Customer customer) {
        // TODO 2-07 CustomerRepositoryのsave(Customer)を呼び出す

    }
}
