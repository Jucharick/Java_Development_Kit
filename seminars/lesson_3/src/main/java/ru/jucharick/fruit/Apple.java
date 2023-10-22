package ru.jucharick.fruit;

public class Apple implements Fruit {
    public static final float WEIGHT = 1f;

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
