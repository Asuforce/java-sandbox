package com.asuforce.javarest.service;

import com.asuforce.javarest.domain.Customer;
import com.asuforce.javarest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findOne(Integer id) {
        return repository.getOne(id);
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    public void delete(Customer customer) {
        repository.delete(customer);
    }

}
