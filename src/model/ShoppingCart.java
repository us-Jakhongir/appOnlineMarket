package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private Long id;
    private List<Product> products;
    private Double totalAmount;
    private Double totalPrice;

    public ShoppingCart(Long id) {
        this.id = id;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public ShoppingCart(Long id, List<Product> products, Double amountProducts, Double totalPrice) {
        this.id = id;
        this.products = new LinkedList<>();
        this.totalAmount = 0.0 ;
        this.totalPrice = totalPrice;

    }

    public ShoppingCart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
