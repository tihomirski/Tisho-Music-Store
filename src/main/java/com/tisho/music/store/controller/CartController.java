package com.tisho.music.store.controller;

import com.tisho.music.store.model.Customer;
import com.tisho.music.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//In order to reach this class-level path, you must be logged in.
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    //@AuthenticationPrincipal represents the logged in person and Spring generates the info for this person.
    //It is part of the spring-security after version 3.2. So we changed that.
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        //We retrieve the cart we have created for the customer.
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
