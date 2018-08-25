package com.example.service.impl;

import com.example.persistence.entity.Customer;
import com.example.persistence.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// TODO 2-02 ビジネスロジッククラスのBeanであることを示すアノテーションを付加する

public class CustomerServiceImpl implements CustomerService {

    // TODO 2-03 CustomerRepositoryをコンストラクタインジェクションする



    // TODO 2-04 トランザクション管理アノテーションを付加する（伝播属性＝REQUIRED, 読み取り専用＝true）

    @Override
    public Iterable<Customer> findAll() {
        // TODO 2-05 CustomerRepositoryのfindAll()を呼び出す
        return null;
    }

    // TODO 2-06 トランザクション管理アノテーションを付加する（伝播属性＝REQUIRED, 読み取り専用＝false）

    @Override
    public void save(Customer customer) {
        // TODO 2-07 CustomerRepositoryのsave(Customer)を呼び出す

    }
}
