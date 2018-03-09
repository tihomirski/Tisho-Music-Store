package com.tisho.music.store.service.impl;

import com.tisho.music.store.dao.CustomerOrderDao;
import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.CartItem;
import com.tisho.music.store.model.CustomerOrder;
import com.tisho.music.store.service.CartService;
import com.tisho.music.store.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);

    }

    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getTotalPrice();
        }

        return grandTotal;
    }
}
