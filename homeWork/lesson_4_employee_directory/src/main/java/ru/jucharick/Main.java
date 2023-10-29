package ru.jucharick;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников -
каждый сотрудник должен иметь следующие атрибуты:
1. Табельный номер
2. Номер телефона
3. ФИО
4. Стаж

Создать методы:
1. который ищет сотрудника по стажу (может быть список)
2. который выводит номер телефона сотрудника по имени (может быть список)
3. который ищет сотрудника по табельному номеру
4. добавление нового сотрудника в справочник
*/


public class Main {
    public static void main(String[] args) {
        EmployeesDirect employeesBook = new EmployeesDirect();
        employeesBook.createEmployees();
        // печать справочника
        employeesBook.printEmployeesDirect();

        // добавление нового сотрудника в справочник
        employeesBook.addEmployee(new Employee("89874300", "Юлия", "Ли", 1));
        employeesBook.addEmployee(new Employee("89874300", "Юлия", "Александрова", 1));
        System.out.println();
        System.out.println("Справочник с новым сотрудником: ");
        employeesBook.printEmployeesDirect();

        // поиск по по стажу
        System.out.println();
        System.out.println("Поиск по стажу");
        System.out.println(employeesBook.searchByExperience(1));
        // поиск номера телефона по имени
        System.out.println();
        System.out.println("Поиск номера телефона по имени");
        System.out.println(employeesBook.searchByName("Юлия"));
        // поиск по табельному номеру
        System.out.println();
        System.out.println("Поиск по табельному номеру");
        System.out.println(employeesBook.searchByServiceNumber(10005));
    }
}
