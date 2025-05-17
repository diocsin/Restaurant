package builder;

import model.Customer;
import model.MenuItem;
import model.Order;
import model.Status;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private static int orderIdCounter = 0; // глобальный счётчик
    private final int orderId;             // уникальный ID заказа
    private Customer customer;
    private List<MenuItem> listOfDishes = new ArrayList<>();
    private Status orderStatus;
    private double orderAmount;

    public OrderBuilder() {
        this.orderId = ++orderIdCounter;
    }

    public OrderBuilder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder listOfDishes(List<MenuItem> listOfDishes) {
        this.listOfDishes = listOfDishes;
        return this;
    }

    public OrderBuilder orderStatus(Status status) {
        this.orderStatus = status;
        return this;
    }

    public Order build() {
        return new Order(this);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MenuItem> getListOfDishes() {
        return listOfDishes;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

}
