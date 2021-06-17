package ru.geekbrains.Java3.lesson4;

public class Main {

    public static void main(String[] args) {
        PrintObject printObject = new PrintObject();
        Thread thread1 = new Thread(() -> {
            printObject.printA();
        });
        Thread thread2 = new Thread(() -> {
            printObject.printB();
        });
        Thread thread3 = new Thread(() -> {
            printObject.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
