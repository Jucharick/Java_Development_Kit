package ru.jucharick;

/*
каждый сотрудник должен иметь следующие атрибуты:
1. Табельный номер
2. Номер телефона
3. ФИО
4. Стаж
*/

public class Employee {
    private int serviceNumber;
    private String phoneNumber;
    private String name;
    private String surname;
    private String experience;

    public Employee(int serviceNumber, String phoneNumber, String name, String surname, String experience) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getExperience() {
        return experience;
    }
}
