package com.tisho.music.store.dao;

import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}
