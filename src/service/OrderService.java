package service;


import builder.OrderBuilder;
import model.Customer;
import model.MenuItem;
import model.Order;

import static model.Status.CREATED;

public class OrderService {

    public Order createOrder(final Customer customer) {
        return new OrderBuilder().customer(customer).orderStatus(CREATED).build();
    }

    public void addMenuItemToOrder(final Order order, final MenuItem menuItem) {
        order.getListOfDishes().add(menuItem);
    }

    public void removeMenuItemsFromOrder(final Order order, final MenuItem menuItem) {
        order.getListOfDishes().remove(menuItem);
    }

    public void recalculateOrderAmount(final Order order) {
        double orderAmount = order.getListOfDishes().stream().mapToDouble(MenuItem::getItemPrice).sum();
        order.setOrderAmount(orderAmount);
    }

}
