package ru.jucharick;

import ru.jucharick.client.ClientGUI;
import ru.jucharick.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerGUI server = new ServerGUI();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}
