package ru.aston.hometask.module03.decorator;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с сахаром";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0;
    }
}
