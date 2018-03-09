package com.tisho.music.store.dao;

import com.tisho.music.store.model.CustomerOrder;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    //If you look at CustomerOrderServiceImpl, we don't need to access the DB to calculate the grandTotal. So we don't need this method here.
    //double getCustomerOrderGrandTotal(int cartId);
}
