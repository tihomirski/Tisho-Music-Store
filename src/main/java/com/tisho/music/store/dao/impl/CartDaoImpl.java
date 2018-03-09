package com.tisho.music.store.dao.impl;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.tisho.music.store.dao.CartDao;
import com.tisho.music.store.model.Cart;
import com.tisho.music.store.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
//        session.flush();
    }

    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);

        //If the cart is null means that it doesn't exist.
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException("" + cartId);
        }

        update(cart);

        return cart;
    }
}
