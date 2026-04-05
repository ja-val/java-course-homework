package ru.aston.hometask.module03.decorator;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с молоком";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20.0;
    }
}
