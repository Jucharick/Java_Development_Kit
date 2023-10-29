package ru.jucharick;

import java.util.*;

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
    public static List<Employee> result = new ArrayList<>();

    public static void main(String[] args) {


        EmployeesDirect employeesBook = new EmployeesDirect();
        employeesBook.createEmployees();

        // печать справочника
        employeesBook.printEmployeesDirect();

        // добавление нового сотрудника в справочник
        employeesBook.addEmployee(new Employee("89874300", "Юлия", "Ли", 1));
        employeesBook.addEmployee(new Employee("87777700", "Юлия", "Александрова", 1));
        System.out.println();
        System.out.println("Справочник с новым сотрудником: ");
        employeesBook.printEmployeesDirect();

        // поиск по по стажу
        System.out.println();
        System.out.println("Поиск по стажу");
        result = employeesBook.searchByExperience(1);
        for (Employee employee: result) {
            System.out.println(employee);
        }

        // поиск номера телефона по имени
        System.out.println();
        System.out.println("Поиск номера телефона по имени");
        result = employeesBook.searchByName("Юлия");
        for (Employee employee: result) {
            System.out.println(employee.getName() + " " + employee.getPhoneNumber());
        }

        // поиск по табельному номеру
        System.out.println();
        System.out.println("Поиск по табельному номеру");
        result = employeesBook.searchByServiceNumber(10005);
        for (Employee employee: result) {
            System.out.println(employee);
        }
    }
}
