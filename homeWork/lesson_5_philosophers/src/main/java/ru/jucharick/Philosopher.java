package ru.jucharick;

import java.util.Random;

public class Philosopher extends Thread {
    //region Fields
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private Random random;
    private int countEat;
    private boolean canEatPh;
    //endregion

    //region Constructors
    public Philosopher(String name,Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        countEat = 3; // философ должен поесть три раза
        random = new Random();
        canEatPh = true; // философ не может есть два раза подряд, не прервавшись на размышления
    }
    //endregion

    //region Private Methods
    private void eat() throws InterruptedException{
        countEat --;
        leftFork.setUsedFork(true);
        rightFork.setUsedFork(true);
        System.out.println(name + " ест");
        sleep(random.nextInt(2, 3) * 1000L);
        System.out.println(name + " поел, осталось поесть еще " + countEat);
        canEatPh = false; // философ не может есть два раза подряд, не прервавшись на размышления
    }

    private void think() throws InterruptedException{
        System.out.println(name + " размышляет");
        sleep(random.nextInt(2, 5) * 1000L);
        //System.out.println(name + " закончил размышлять");
        canEatPh = true; // философ не может есть два раза подряд, не прервавшись на размышления
    }

    private boolean canEat() {
        if (!leftFork.isUsedFork() && !rightFork.isUsedFork() && canEatPh) {
            // философ может есть только тогда, когда держит две вилки — взятую справа и слева
            // &&
            // философ не может есть два раза подряд
            return true;
        } else {
            return false;
        }
    }
    //endregion

    //region Public Methods
    @Override
    public void run() {
        while (countEat > 0) {
            try {
                if (canEat()) {
                    eat();
                    leftFork.setUsedFork(false);
                    rightFork.setUsedFork(false);
                } else {
                    think();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //endregion
}
