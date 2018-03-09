package com.tisho.music.store.service.impl;

import com.tisho.music.store.dao.CartItemDao;
import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.CartItem;
import com.tisho.music.store.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service, So that it can be registered as a bean.
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }
}
