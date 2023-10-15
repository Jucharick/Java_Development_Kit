package ru.jucharick.client;

import ru.jucharick.server.ServerWindow;

public class Client {
    private String name;
    private ClientView clientView;
    private ServerWindow serverWindow;
    private boolean connected; //изначально имеет значение false

    public Client(ClientView clientView, ServerWindow serverWindow) {
        this.clientView = clientView;
        this.serverWindow = serverWindow;
    }

    private boolean connectToServer(String name) {
        this.name = name;
        return true;
    }

    // мы отправляем
    public void sendMsg(String message) {

    }

    // нам отправляют
    public void serverAnswer () {

    }

}
