package ru.aston.hometask.module02;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = JsonParser.readStudentsFromJsonFile("students.json");

        if (students == null || students.isEmpty()) {
            System.out.println("Не удалось загрузить студентов из файла");
            return;
        }

        System.out.println("=== Результат работы стрима ===\n");

        students.stream()
                // Выводим каждого студента
                .peek(student -> System.out.println("Студент: " + student))

                // Получаем для каждого студента список книг
                .map(Student::getBooks)

                // Получаем книги
                .flatMap(List::stream)

                // Сортируем по количеству страниц
                .sorted(Comparator.comparingInt(Book::getPages))

                // Оставляем только уникальные книги
                .distinct()

                // Фильтруем книги после 2000 года
                .filter(book -> book.getYear() > 2000)

                // Ограничиваем на 3 элемента
                .limit(3)

                // Получаем годы выпуска
                .map(Book::getYear)

                // Метод короткого замыкания
                .findFirst()

                // Обрабатываем Optional
                .ifPresentOrElse(
                        year -> System.out.println("\nНайден год выпуска: " + year),
                        () -> System.out.println("\nТакая книга отсутствует")
                );
    }
}
