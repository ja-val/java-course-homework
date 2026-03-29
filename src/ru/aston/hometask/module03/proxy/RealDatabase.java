package ru.aston.hometask.module03.proxy;

public class RealDatabase implements Database{
    @Override
    public void query(String sql) {
        System.out.printf("Выполнение запроса: %s\n", sql);
    }
}
