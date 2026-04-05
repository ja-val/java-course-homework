package ru.aston.hometask.module03.decorator;

public class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", со взбитыми сливками";
    }

    @Override
    public double getCost() {
        return super.getCost() + 30.0;
    }
}
