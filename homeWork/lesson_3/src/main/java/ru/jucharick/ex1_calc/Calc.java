package ru.jucharick.ex1_calc;

public class Calc {

    public static double result;

    public static <T extends Number, V extends Number> double multiply(T t, V v) {
        result = t.doubleValue() * v.doubleValue();
        return result;
    }

    public static <T extends Number, V extends Number> double divide(T t, V v) {
        if (v.doubleValue() == 0) {throw new ArithmeticException("Делить на 0 нельзя");}
        result = t.doubleValue() / v.doubleValue();
        return result;
    }

    public static <T extends Number, V extends Number> double sum(T t, V v) {
        result = t.doubleValue() + v.doubleValue();
        return result;
    }

    public static <T extends Number, V extends Number> double subtract(T t, V v) {
        result = t.doubleValue() - v.doubleValue();
        return result;
    }
}
