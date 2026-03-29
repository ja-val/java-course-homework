package ru.aston.hometask.module03.strategy;

public class Main {
    public void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("4321-9507"));
        cart.checkout(1748.34);

        cart.setPaymentStrategy(new PayPalPayment("admin@mail.ru"));
        cart.checkout(950.00);
    }
}
