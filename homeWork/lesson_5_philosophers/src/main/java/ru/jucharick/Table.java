package ru.jucharick;

import java.util.ArrayList;
import java.util.List;

public class Table extends Thread {
    //region Fields
    private List<Philosopher> philosophers;
    private List<Fork> forks;
    //endregion

    //region Constructors
    public Table() {
        philosophers = new ArrayList<>(5);
        forks = new ArrayList<>(5);
        forks.add(new Fork(false));
        forks.add(new Fork(false));
        forks.add(new Fork(false));
        forks.add(new Fork(false));
        forks.add(new Fork(false));
        philosophers.add(new Philosopher("Философ_1",forks.get(0),forks.get(1)));
        philosophers.add(new Philosopher("Философ_2",forks.get(1),forks.get(2)));
        philosophers.add(new Philosopher("Философ_3",forks.get(2),forks.get(3)));
        philosophers.add(new Philosopher("Философ_4",forks.get(3),forks.get(4)));
        philosophers.add(new Philosopher("Философ_5",forks.get(4),forks.get(0)));
    }
    //endregion

    //region Private Methods
    private void startThreadPhilosophers() {
        for (Philosopher philosopher: philosophers) {
            philosopher.start();
        }
    }
    //endregion

    //region Public Methods
    @Override
    public void run() {
        startThreadPhilosophers();
    }
    //endregion
}
