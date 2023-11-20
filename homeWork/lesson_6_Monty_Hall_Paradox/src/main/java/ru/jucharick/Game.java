package ru.jucharick;

import java.util.*;

public class Game {
    //region Fields
    private double win = 0;
    private double loose = 0;
    private int step = 1;
    private List<Integer> doors;
    private int playerChoiceIndex;
    private int choiceMontyHallIndex;
    private int secondPlayerChoiceIndex;
    private int countGame;
    private Map<Integer,String> result = new HashMap();
    //endregion

    //region Public Methods
    public void startGame(int count) {
        this.countGame = count;
        while (step <= countGame) {
            doors = new ArrayList<>(3);
            doors.add(0);
            doors.add(0);
            doors.add(0);
            getWinNumber();
            playerChoiceIndex = getPlayerChoiceIndex();
            choiceMontyHallIndex = getMontyHallChoiceIndex();
            secondPlayerChoiceIndex = getSecondPlayerChoiceIndex();
            if (doors.get(secondPlayerChoiceIndex).equals(1)) {
                result.put(step, "win");
                win++;
            } else {
                result.put(step, "loose");
                loose++;
            }
            step++;
        }
    }

    public void printResult() {
        System.out.println(result);
        System.out.println("Победа: " + String.format("%.3f",win/countGame*100) + "%");
        System.out.println("Проигрыш: " + String.format("%.3f",loose/countGame*100) + "%");
    }
    //endregion

    //region Public Methods
    private void getWinNumber(){
        doors.set(random.nextInt(doors.size()),1);
    }

    private int getPlayerChoiceIndex(){
        return random.nextInt(doors.size());
    }

    private int getMontyHallChoiceIndex(){
        for (int i = 0; i < doors.size(); i++) {
            if (i != playerChoiceIndex && !doors.get(i).equals(1)){
                return i;
            }
        }
        return 0;
    }

    private int getSecondPlayerChoiceIndex() {
        for (int i = 0; i < doors.size(); i++) {
            if (i != choiceMontyHallIndex && i != playerChoiceIndex){
                return i;
            }
        }
        return 0;
    }
    //endregion

    //region Static Fields
    public static Random random = new Random();
    //endregion
}

