package ru.jucharick;
import java.util.Random;
/*
каждый сотрудник должен иметь следующие атрибуты:
1. Табельный номер
2. Номер телефона
3. ФИО
4. Стаж
*/

import java.util.Random;

public class Employee {
    //region Fields
    /**
     * Табельный номер
     */
    private int id;
    /**
     * Номер телефона
     */
    private String phoneNumber;
    /**
     * Имя
     */
    private String name;
    /**
     * Фамилия
     */
    private String surname;
    /**
     * Стаж
     */
    private int experience;
    //endregion


    //region Constructors
    public Employee(String phoneNumber, String name, String surname, int experience){
        this(getCountId(), phoneNumber, name, surname, experience);
    }

    public Employee(int serviceNumber, String phoneNumber, String name, String surname, int experience) {
        this.id = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }
    //endregion

    //region Getters
    public int getId() {
        return id;
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

    public int getExperience() {
        return experience;
    }
    //endregion

    //region Public Methods
    @Override
    public String toString() {
        return  "{ " +
                "Табельный номер: " + id +
                ", Номер телефона: " + phoneNumber +
                ", Имя: " + name +
                ", Фамилия: " + surname +
                ", Опыт: " + experience +
                " }";
    }
    //endregion

    //region Static Fields
    private static int counter = 10000;
    //endregion

    //region Static Methods
    public static int getCountId() {
        counter = counter + 1;
        return counter;
    }
    //endregion
}
