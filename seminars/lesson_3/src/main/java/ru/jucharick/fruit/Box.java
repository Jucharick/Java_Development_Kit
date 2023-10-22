package ru.jucharick.fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    // T - дженерик, переменная, хранящая тип
    // ограничиваем тип данных: в коробку могут положить только фрукты. котиков нельзя
    // в коробку можем положить любой тип данных, которые реализуют интерфес Fruit (в др.случаях - являются наследниками класса Fruit  и сам Fruit)
    // не смотря на то, что Fruit интерфейс, все-равно extends
    // <T extends Fruit> - ограничение сверху

    private final List<T> CONTAINER;

    Box (){
        CONTAINER = new ArrayList<>();
    }

    void addFruit(T fruit) {
        CONTAINER.add(fruit);
    }

    void print(){
        System.out.println(getWeight());
    }

    float getWeight(){ // метод возврата общего веса коробки
        return (CONTAINER.isEmpty()) ? 0 : CONTAINER.get(0).getWeight() * CONTAINER.size();
    }

    boolean compare(Box<?> with) { // метод сравнивает вес коробок
        // ? - обозначает, что любой тип данных
        return this.getWeight() == with.getWeight();
    }

    void transferTo(Box<? super T> dest) { // метод, позволяющий пересыпать фрукты из одной коробки в другую
        // ? super T  коробка должна быть или такого же типа данных или большего
        // <? super T> - ограничение снизу
        dest.CONTAINER.addAll(CONTAINER);
        this.CONTAINER.clear();
    }
}
