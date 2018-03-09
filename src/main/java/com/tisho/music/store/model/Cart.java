package com.tisho.music.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Cart implements Serializable {

    //Ctrl+Alt+o imports what is missing
    private static final long serialVersionUID = -1886789543055172720L;


    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }


    //    private String cartId;
//    private Map<String,CartItem> cartItems;
//    private double grandTotal;
//
//    private Cart() {
//        cartItems = new HashMap<String,CartItem>();
//        grandTotal = 0;
//    }
//
//    public Cart(String cartId) {
//        this();
//        this.cartId = cartId;
//    }
//
//    public String getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(String cartId) {
//        this.cartId = cartId;
//    }
//
//    public Map<String, CartItem> getCartItems() {
//        return cartItems;
//    }
//
//    public void setCartItems(Map<String, CartItem> cartItems) {
//        this.cartItems = cartItems;
//    }
//
//    public double getGrandTotal() {
//        return grandTotal;
//    }
//
//    public void setGrandTotal(double grandTotal) {
//        this.grandTotal = grandTotal;
//    }
//    //-----------------------------------------------------------------------------------------------------------
//
//    public void addCartItem(CartItem item) {
//        String productId = item.getProduct().getProductId();
//
//        if (cartItems.containsKey(productId)) {
//            CartItem existingCartItem = cartItems.get(productId);
//            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
//            cartItems.put(productId, existingCartItem);
//        } else {
//            cartItems.put(productId, item);
//        }
//
//        updateGrandTotal();
//    }
//
//    public void removeCartItem(CartItem item) {
//        String productId = item.getProduct().getProductId();
//        cartItems.remove(productId);
//        updateGrandTotal();
//    }
//
//    public void updateGrandTotal() {
//        grandTotal = 0;
//        for (CartItem item : cartItems.values()) {
//            grandTotal += item.getTotalPrice();
//        }
//    }





}
