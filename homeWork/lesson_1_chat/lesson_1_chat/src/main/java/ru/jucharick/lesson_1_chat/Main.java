package ru.jucharick.lesson_1_chat;

public class Main {
    public static void main(String[] args) {
        ServerWindow chatServer = new ServerWindow();
        new ClientGUI(chatServer);
    }
}
