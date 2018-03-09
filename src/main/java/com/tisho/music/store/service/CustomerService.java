package com.tisho.music.store.service;

import com.tisho.music.store.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int id);

    Customer getCustomerByUsername(String username);

    List<Customer> getAllCustomers();
}
