package model;

import java.util.Map;

public class OrderDetails {

    private Long id;
    private Order order;
    private Map<Product, Integer> products;


    public OrderDetails(Long id, Order order, Map<Product, Integer> products) {
        this.id = id;
        this.order = order;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", order=" + order +
                ", products=" + products +
                '}';
    }
}
