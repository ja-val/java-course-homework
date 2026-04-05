package ru.aston.hometask.module03.strategy;

public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Оплата %s руб. через PayPal: %s.\n", amount, email);
    }
}
