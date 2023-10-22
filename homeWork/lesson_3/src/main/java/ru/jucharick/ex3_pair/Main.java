package ru.jucharick.ex3_pair;
/*
*Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы
* getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение метода toString(),
* возвращающее строковое представление пары.
*/
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair("Hello", 2);

        String result = pair.toString();
        System.out.println(result);

        System.out.println(pair);

        System.out.println("First: " + pair.getFirst());
        System.out.println("Second: " + pair.getSecond());
    }
}
