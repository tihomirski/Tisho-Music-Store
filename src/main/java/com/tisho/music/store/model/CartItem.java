package com.tisho.music.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

//To become a persistent object in the DB
@Entity
public class CartItem implements Serializable {


    private static final long serialVersionUID = 5827908257981216745L;

    @Id
    @GeneratedValue
    private int cartItemId;

    //@JoinColumn is used to refer to Cart when making the CartItem table
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    //The CartItem side is many and Product side is 1.
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    //quantity represents the amount of Products we put in a cart
    private int quantity;

    //The total price of this cart Item
    private double totalPrice;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //    private Product product;
//    private int quantity;
//    private double totalPrice;
//
//    public CartItem() {}
//
//    public CartItem(Product product) {
//        this.product = product;
//        this.quantity = 1;
//        this.totalPrice = product.getProductPrice();
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice * quantity;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
}
