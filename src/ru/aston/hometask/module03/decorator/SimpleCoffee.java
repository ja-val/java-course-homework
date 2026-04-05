package ru.aston.hometask.module03.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Обычный кофе";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
}
