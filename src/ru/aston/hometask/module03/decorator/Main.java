package ru.aston.hometask.module03.decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " руб.");

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(milkCoffee.getDescription() + " - " + milkCoffee.getCost() + " руб.");

        Coffee fancyCoffee = new WhippedCreamDecorator(
                new SugarDecorator(
                        new MilkDecorator(new SimpleCoffee())));
        System.out.println(fancyCoffee.getDescription() + " - " + fancyCoffee.getCost() + " руб.");
    }
}
