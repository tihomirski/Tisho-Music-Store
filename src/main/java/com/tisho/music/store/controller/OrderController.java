package com.tisho.music.store.controller;

import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.Customer;
import com.tisho.music.store.model.CustomerOrder;
import com.tisho.music.store.service.CartService;
import com.tisho.music.store.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

//    @Autowired
//    private CustomerOrder customerOrder;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable int cartId) {
        //customerOrder should be autowired ??????
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        //Here we go to the checkout-flow and we need to pass the cartId, which we will need in checkout-flow.xml
        return "redirect:/checkout?cartId=" + cartId;

    }
}
