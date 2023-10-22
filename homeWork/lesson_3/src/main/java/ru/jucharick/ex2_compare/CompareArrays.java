package ru.jucharick.ex2_compare;

import java.util.Objects;

public class CompareArrays {
    public static <T, V> boolean compare(T[] arr, V[] comparedArr){
        if (!arr.getClass().equals(comparedArr.getClass())) {return false;} // должны содержать элементы одного типа
        if (arr.length != comparedArr.length) {return false;} // должны иметь одинаковую длину
        for (int i = 0; i < arr.length; ++i) {
            if (!Objects.equals(arr[i], comparedArr[i])) {
                return false;
            }
        }
        return true;
    }
}
