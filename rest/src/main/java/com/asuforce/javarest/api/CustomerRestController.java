package com.asuforce.javarest.api;

import com.asuforce.javarest.domain.Customer;
import com.asuforce.javarest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/cusotmer")
public class CustomerRestController {
    @Autowired
    CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomer() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postCustomer(@PathVariable Customer customer) {
        return service.create(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return service.update(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        service.delete(customer);
    }
}
