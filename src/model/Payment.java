package model;

import java.util.Objects;

public class Payment {
    private static Integer paymentId = 0;  // тут глобальный счетчик надо смотри как в OrderBuilder
    private static double paymentAmount;  //static ?
    private static PaymentMethod paymentMethod;  //static ?

    public Payment(double paymentAmount, PaymentMethod paymentMethod) {
        paymentId++;
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Payment payment)) return false;
        return paymentId == payment.paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(paymentId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
