package com.tisho.music.store.controller;


import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.CartItem;
import com.tisho.music.store.model.Customer;
import com.tisho.music.store.model.Product;
import com.tisho.music.store.service.CartItemService;
import com.tisho.music.store.service.CartService;
import com.tisho.music.store.service.CustomerService;
import com.tisho.music.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Acts like a REST service controller but we use it to provide resources for the cart page.
@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    //With @ResponseBody Spring make the response in JSON format. This comes from the jackson dependency.
    //This method will help us retrieve our cart and it will be sent as JSON to cart view page.
    //The info will be processed with AngularJS
    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById(@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId,
                        @AuthenticationPrincipal User activeUser) {

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        //This loop take care of the case when the product is in the cart.
        for (int i=0; i<cartItems.size(); i++) {
            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId) {
    //public void removeItem(@PathVariable(value = "productId") int productId) {
        //These 2 method signatures are equivalent because the Path var is only one and its name coincides with the name of the param.

        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);

    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    //It is a good practice to define exception handlers.
    //Otherwise you will not know that something went wrong.
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request. Please verify your payload.")
    public void handleClientErrors(Exception e) { }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal serverr error.")
    public void handleServerErrors(Exception e) { }

}
