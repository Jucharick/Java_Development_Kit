package ru.jucharick.client;

import ru.jucharick.server.Server;

public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected; //изначально имеет значение false

    public Client(ClientView clientView, Server serverWindow) { // ServerWindow заменить на server
        this.clientView = clientView;
        this.server = serverWindow;
    }

    public boolean connectToServer(String name) { // должны еще передаваться login and password или должен быть отдельный класс для пользователя
        this.name = name;
        if (server.connectUser(this)){
            printText("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    // мы отправляем
    public void sendMsg(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    // нам отправляют
    public void serverAnswer(String answer) {
        printText(answer);
    }

    public void disconnect(){
        if (connected) {
            connected = false;
            clientView.disconnectFromServer(); // плашка с кнопкой login
            server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    private void printText(String text){
        clientView.showMessage(text);
    }
}
