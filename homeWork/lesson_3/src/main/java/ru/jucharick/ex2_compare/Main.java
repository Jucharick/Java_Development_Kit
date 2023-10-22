package ru.jucharick.ex2_compare;
/*
* Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и
* false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать
* элементы одного типа.
*/
public class Main {
    public static void main(String[] args) {
        String[] seasons = {"Winter", "Spring", "Summer", "Autumn"};
        String[] seasons2 = {"Winter", "Spring", "Summer", "Autumn"};

        System.out.println(CompareArrays.compare(seasons, seasons2));

        Integer[] numbers1 = {1, 6, 5, 4};
        Integer[] numbers2 = {1, 6, 5, 4};
        System.out.println(CompareArrays.compare(numbers1, numbers2));

        Integer[] numbers3 = {1, 6, 5, 4};
        Float[] numbers4 = {1f, 6f, 5f, 4f};
        System.out.println(CompareArrays.compare(numbers3, numbers4));

        System.out.println(CompareArrays.compare(seasons, numbers4));
    }
}
