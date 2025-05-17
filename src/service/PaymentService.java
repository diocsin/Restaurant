package service;

import exception.OrderAlreadyPaidException;
import model.*;

import static model.Status.PAID;

public class PaymentService {

    public Payment createPayment(final Order order, final PaymentMethod paymentMethod) {
        double paymentAmount = order.getListOfDishes().stream().mapToDouble(MenuItem::getItemPrice).sum();
        order.setOrderStatus(PAID);
        return new Payment(paymentAmount, paymentMethod);
    }

    public void checkOrderStatus(final Order order) throws OrderAlreadyPaidException {
        if (order.getOrderStatus() == PAID) {
            throw new OrderAlreadyPaidException("Заказ Номер " + order.getOrderId() + " уже оплачен");
        }
    }
}
