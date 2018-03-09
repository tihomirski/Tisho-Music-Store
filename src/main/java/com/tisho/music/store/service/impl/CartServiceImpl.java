package com.tisho.music.store.service.impl;

import com.tisho.music.store.dao.CartDao;
import com.tisho.music.store.model.Cart;
import com.tisho.music.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart) {
        cartDao.update(cart);
    }



}
