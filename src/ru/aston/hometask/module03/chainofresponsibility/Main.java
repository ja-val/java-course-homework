package ru.aston.hometask.module03.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        JuniorSupport junior = new JuniorSupport();
        SeniorSupport senior = new SeniorSupport();
        ManagerSupport manager = new ManagerSupport();

        junior.setNext(senior);
        senior.setNext(manager);

        // Используем константы вместо чисел
        junior.handleRequest("Не открывается сайт", SupportHandler.LEVEL_EASY);
        junior.handleRequest("База данных недоступна", SupportHandler.LEVEL_HARD);
        junior.handleRequest("Сервер упал", SupportHandler.LEVEL_IMPOSSIBLE);
    }
}
