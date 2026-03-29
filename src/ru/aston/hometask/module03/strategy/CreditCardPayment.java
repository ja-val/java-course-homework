package ru.aston.hometask.module03.strategy;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Оплата %s руб. картой %s.\n", amount, cardNumber);
    }
}
