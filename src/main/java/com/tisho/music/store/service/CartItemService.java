package com.tisho.music.store.service;

import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
