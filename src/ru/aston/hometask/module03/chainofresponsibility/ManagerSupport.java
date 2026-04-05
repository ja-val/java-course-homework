package ru.aston.hometask.module03.chainofresponsibility;

public class ManagerSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        System.out.printf("Менеджер из поддержки решил проблему: %s.\n", issue);
    }
}
