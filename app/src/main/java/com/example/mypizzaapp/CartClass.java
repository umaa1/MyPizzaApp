package com.example.mypizzaapp;

public class CartClass {

    private int cartId;
    private int quantity;
    private String title;
    private String description;

    public CartClass(int cartId, int quantity, String title, String description) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.title = title;
        this.description = description;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
