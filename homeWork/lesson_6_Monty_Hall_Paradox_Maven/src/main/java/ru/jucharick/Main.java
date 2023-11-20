package ru.jucharick;

public class Main {
    public static void main(String[] args) {
        Game montyHallParadox = new Game();
        montyHallParadox.startGame(1000);
        System.out.println("Результат: ");
        montyHallParadox.printResult();
    }
}
