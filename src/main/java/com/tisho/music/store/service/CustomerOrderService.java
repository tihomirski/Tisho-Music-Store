package com.tisho.music.store.service;

import com.tisho.music.store.model.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
