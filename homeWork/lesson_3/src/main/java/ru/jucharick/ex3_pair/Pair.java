package ru.jucharick.ex3_pair;

public class Pair<T, V> {
    T t;
    V v;

    public Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getFirst() {
        return t;
    }

    public V getSecond() {
        return v;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(this.t);
        stringBuilder.append(", ");
        stringBuilder.append(this.v);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
