package ru.jucharick.ex2_compare;

import java.util.Objects;

public class CompareArrays {
    public static <T, V> boolean compare(T[] arr, V[] comparedArr){
        if (arr.length != comparedArr.length) {return false;}
        for (int i = 0; i < arr.length; ++i) {
            if (!Objects.equals(arr[i], comparedArr[i])) {
                return false;
            }
        }
        return true;
    }
}
