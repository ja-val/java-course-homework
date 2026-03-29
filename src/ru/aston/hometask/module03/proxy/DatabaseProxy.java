package ru.aston.hometask.module03.proxy;

public class DatabaseProxy implements Database {
    private RealDatabase realDatabase;
    private final String userRole;
    private String lastQuery;
    private String cachedResult;

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void query(String sql) {
        if (sql.toLowerCase().contains("drop") && !"ADMIN".equals(userRole)) {
            System.out.println("Доступ запрещен! Только ADMIN может удалять данные.");
            return;
        }

        if (sql.equals(lastQuery)) {
            System.out.printf("Возвращаем кэшированный результат для: %s\n", sql);
            System.out.printf("Результат: %s\n", cachedResult);
            return;
        }

        if (realDatabase == null) {
            realDatabase = new RealDatabase();
        }

        lastQuery = sql;
        realDatabase.query(sql);
        cachedResult = "Результат запроса " + sql;
    }
}
