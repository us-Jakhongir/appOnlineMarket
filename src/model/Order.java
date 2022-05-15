package model;

import enums.OrderStatus;

public class Order {

    private Long id;
    private User customer;
    private OrderStatus orderStatus;
    private Double totalPrice;

    public Order(Long id, User customer, OrderStatus orderStatus, Double totalPrice) {
        this.id = id;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order: " +
                "id: " + id + "\n" +
                "customer: " + customer +
                "orderStatus: " + orderStatus + "\n" +
                "totalPrice: " + totalPrice +
                "\n";
    }
}
