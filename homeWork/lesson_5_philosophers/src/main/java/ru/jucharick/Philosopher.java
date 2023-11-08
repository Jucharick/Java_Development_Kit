package ru.jucharick;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private Random random;
    private CountDownLatch cdl;

    public Philosopher(String name,Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        cdl = new CountDownLatch(3); // философ должен поесть три раза
        random = new Random();
    }

    private void eat() throws InterruptedException{
        System.out.println(name + " начал есть");
        sleep(random.nextInt(2, 3) * 1000L);
        System.out.println(name + " поел, осталось поесть еще " + (int)(3-cdl.getCount()));
        cdl.countDown();
    }

    private void think() throws InterruptedException{
        System.out.println(name + " начал размышлять");
        sleep(random.nextInt(2, 5) * 1000L);
        System.out.println(name + " закончил размышлять");
    }

    @Override
    public void run() {
        try {
            if (!leftFork.isUsedFork() && !rightFork.isUsedFork()) {
                eat();
                leftFork.setUsedFork(!leftFork.isUsedFork());
            } else {
                think();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
