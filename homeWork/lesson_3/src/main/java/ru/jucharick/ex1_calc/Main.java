package ru.jucharick.ex1_calc;
/*
* Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(),
* multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа (но необязательно
* разного между собой), над которыми должна быть произведена операция.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println(Calc.sum(3, 8.99));
        System.out.println(Calc.subtract(11, 2));
        System.out.println(Calc.multiply(3, 1.1));
        System.out.println(Calc.divide(11, 3));
        System.out.println(Calc.divide(10, 2f));
    }
}
