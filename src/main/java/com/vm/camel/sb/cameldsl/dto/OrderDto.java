package com.vm.camel.sb.cameldsl.dto;

public class OrderDto {
    private String orderId;
    private String product;
    private int quantity;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // Getters, setters, constructors...
}