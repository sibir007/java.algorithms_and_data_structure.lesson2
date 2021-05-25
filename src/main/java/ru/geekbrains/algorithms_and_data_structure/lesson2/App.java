package ru.geekbrains.algorithms_and_data_structure.lesson2;

import java.time.Duration;
import java.time.Instant;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyIntArr arr1 = new MyIntArr(1000000);
        arr1.arrRandomFill();
        MyIntArr arr2 = (MyIntArr) arr1.clone();
        MyIntArr arr3 = (MyIntArr) arr1.clone();

        //пузырьковая сортировка
        Instant start1 = Instant.now();
        arr1.sortBubble();
        Instant finish1 = Instant.now();
        long elapsed1 = Duration.between(start1, finish1).toMillis();
        System.out.println("Время выполнения пузырьковой сортировки, мс: " + elapsed1);



        //сортировка методом вставки
        Instant start2 = Instant.now();
        arr2.sortInsert();
        Instant finish2 = Instant.now();
        long elapsed2 = Duration.between(start2, finish2).toMillis();
        System.out.println("Время сортировки методом вставки, мс: " + elapsed2);


        //сортировка методом выбора
        Instant start3 = Instant.now();
        arr3.sortSelect();
        Instant finish3 = Instant.now();
        long elapsed3 = Duration.between(start3, finish3).toMillis();
        System.out.println("Время сортировки методом выбора, мс: " + elapsed3);

    }
}
