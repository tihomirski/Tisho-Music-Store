package com.tisho.music.store.dao;

import com.tisho.music.store.model.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);

    Customer getCustomerById(int id);

    Customer getCustomerByUsername(String username);

    List<Customer> getAllCustomers();
}
