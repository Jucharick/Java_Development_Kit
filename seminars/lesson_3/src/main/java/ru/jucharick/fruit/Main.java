package ru.jucharick.fruit;

/*
* Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
* Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можете использовать ArrayList;
* Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес
одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
* Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
которую подадут в compare в качестве параметра, true - если их веса равны,
false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
* Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые
были в этой коробке.
*/


public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> boxFruit = new Box<>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        //appleBox.addFruit(new Orange());

        boxFruit.addFruit(new Apple());
        boxFruit.addFruit(new Orange());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        //orangeBox.addFruit(new Apple());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(boxFruit));

        appleBox.transferTo(boxFruit); // могу пересыпать в коробку того же типа данных или выше (Fruit)
    }
}
