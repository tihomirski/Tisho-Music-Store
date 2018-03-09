package com.tisho.music.store.service;

import com.tisho.music.store.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
