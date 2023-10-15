package ru.jucharick.server;

import ru.jucharick.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;
    public static final String LOG_PATH = "./src/main/java/ru/jucharick/lesson_1_chat/log.txt";

    public static final String BTN_START = "Start";
    public static final String BTN_STOP = "Stop";


    JButton btnStart;
    JButton btnStop;
    JTextArea log;
    boolean connect;
    List<Client> clientList;

    ServerWindow(){
        clientList = new ArrayList<>();

        setSize(WIDTH, HEIGHT);
        setTitle("Server - window");
        setResizable(false);

        log = new JTextArea();
        add(log);
        add(createPanelBottom(),BorderLayout.SOUTH);
        setVisible(true);
    }

    private Component createPanelBottom() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(createButtonStart());
        panel.add(createButtonStop());

        return panel;
    }

    private Component createButtonStart() {
        btnStart = new JButton(BTN_START);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connect){
                    log.append("Сервер уже запущен\n");
                } else {
                    connect = true;
                    log.append("Server START\n");
                }
            }
        });
        return btnStart;
    }

    private Component createButtonStop() {
        btnStop = new JButton(BTN_STOP);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!connect){
                    log.append("Сервер уже остановлен\n");
                } else {
                    connect = false;
                    for (Client client: clientList){
                        disconnectUser(client);
                    }
                    log.append("Server STOP\n");
                }
            }
        });
        return btnStop;
    }

    public boolean connectUser(Client client){
        if (!connect){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

    public void addMsg(String str){
        if (!connect){
            return;
        }
        str += "";
        log.append(str);
        answerAll(str);
        saveFile(str);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text); // serverAnswer
        }
    }

    private void saveFile(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String readFile(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

