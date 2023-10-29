package ru.jucharick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeesDirect {
    //region Fields
    public List<Employee> employees;
    private int index;
    //endregion

    public EmployeesDirect() {
        employees = new ArrayList<>();
    }

    //region Public Methods
    /**
     * Поиск сотрудника по стажу (может быть список)
     */
    public List<Employee> searchByExperience (int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Поиск номера телефона сотрудника по имени (может быть список)
     */
    public List<Employee> searchByName (String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getName().equals(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Поиск сотрудника по табельному номеру
     */
    public List<Employee> searchByServiceNumber (int id) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getId() == id) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Добавление нового сотрудника в справочник
     */
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    /**
     * Печать справочника
     */
    public void printEmployeesDirect() {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    /**
     * Создание случайного справочника
     */
    public List<Employee> createEmployees () {
        employees.add(new Employee("39894320", namesMen[random.nextInt(namesMen.length)], surNamesMen[random.nextInt(surNamesMen.length)], (random.nextInt(1,10))));
        employees.add(new Employee("12345678", namesMen[random.nextInt(namesMen.length)], surNamesMen[random.nextInt(surNamesMen.length)], (random.nextInt(1,10))));
        employees.add(new Employee("98765432", namesWomen[random.nextInt(namesWomen.length)], surNamesWomen[random.nextInt(surNamesWomen.length)], (random.nextInt(1,10))));
        employees.add(new Employee("23456789", namesMen[random.nextInt(namesMen.length)], surNamesMen[random.nextInt(surNamesMen.length)], (random.nextInt(1,10))));
        employees.add(new Employee("34567890", namesMen[random.nextInt(namesMen.length)], surNamesMen[random.nextInt(surNamesMen.length)], (random.nextInt(1,10))));
        employees.add(new Employee("10101010", namesWomen[random.nextInt(namesWomen.length)], surNamesWomen[random.nextInt(surNamesWomen.length)], (random.nextInt(1,10))));
        employees.add(new Employee("44444444", namesMen[random.nextInt(namesMen.length)], surNamesMen[random.nextInt(surNamesMen.length)], (random.nextInt(1,10))));
        return employees;
    }
    //endregion

    //region Static Fields
    public static String[] namesMen = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    public static String[] namesWomen = new String[] { "Нинэль", "Татьяна", "Анна", "Катерина", "Любава", "Юлия", "Светлана", "Ольга", "Полина", "Милена" };
    public static String[] surNamesMen = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    public static String[] surNamesWomen = new String[] { "Иванова", "Гавриш", "Визнер", "Салтыкова", "Беггинс", "Петрова", "Волошаненко", "Понкратова", "Плахотник", "Емельянова" };
    public static Random random = new Random();
    //endregion
}
