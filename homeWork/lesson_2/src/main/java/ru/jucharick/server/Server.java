package ru.jucharick.server;

import ru.jucharick.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    List<Client> clientList;
    boolean work;
    private ServerGUI serverGUI;
    private Repository repository;

    public Server(ServerGUI serverGUI, Repository repository) {
        this.serverGUI = serverGUI;
        this.repository = repository;
        clientList = new ArrayList<>();
    }

    public void connect(){
        if (work){
            serverGUI.showMessage("Сервер уже запущен\n");
        } else {
            work = true;
            serverGUI.showMessage("Server START\n");
        }
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnect(){
        if (!work){
            serverGUI.showMessage("Сервер уже остановлен\n");
        } else {
            work = false;
            for (Client client: clientList){
                disconnectUser(client);
            }
            for (int i = clientList.size() - 1; i >= 0; i--) {
                disconnectUser(clientList.get(i));
            }
            serverGUI.showMessage("Server STOP\n");
        }
    }

    public void disconnectUser (Client client) {
        clientList.remove(client);
        if (client != null){
            client.disconnectFromServer();
        }
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        text += "";
        serverGUI.showMessage(text + "\n");
        answerAll(text);
        saveLog(text);
    }

    private void answerAll(String text){
        for (Client clientList: clientList){
            clientList.serverAnswer(text);
        }
    }

    private void saveLog(String text){
        repository.save(text);
    }

    public String getHistory() {
        return repository.read();
    }
}