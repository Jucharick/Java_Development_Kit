package ru.jucharick;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.start();
    }

    // синхронизированный метод tryGetForks (synchronized boolean) - допускает только один поток к ресурсу,
    // создан в Table
    // таким образом нет дедлока если у нас 2 философа
}