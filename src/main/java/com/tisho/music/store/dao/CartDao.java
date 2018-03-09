package com.tisho.music.store.dao;

import com.tisho.music.store.model.Cart;

import java.io.IOException;

public interface CartDao {

    Cart getCartById(int cartId);

    void update(Cart cart);

    Cart validate(int cartId) throws IOException;



//    Cart create(Cart cart);
//
//    //Read cart information having the cart id.
//    Cart read(String cartId);
//
//    void update(String cartId, Cart cart);
//
//    void delete(String cartId);
}
