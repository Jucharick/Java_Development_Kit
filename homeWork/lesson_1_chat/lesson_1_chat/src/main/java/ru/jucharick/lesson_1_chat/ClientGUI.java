package ru.jucharick.lesson_1_chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    private ServerWindow chatServer;
    private boolean connect;
    private String name;

    private static final String BTN_LOGIN = "login";
    private static final String BTN_SENT = "sent";

    JButton btnLogin, btnSent;
    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField password;

    ClientGUI(ServerWindow chatServer){
        this.chatServer = chatServer;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(chatServer.getX() + 600, chatServer.getY());
        setTitle("Chat client");
        setResizable(false);

        add(createPanel());
        setVisible(true);
    }

    private Component createPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createPanelTop(), BorderLayout.NORTH);
        panel.add(createScrollPanelMain());
        panel.add(createPanelBottom(), BorderLayout.SOUTH);

        return panel;
    }

    private Component createPanelTop() {
        JPanel panel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Jucharick");
        password = new JPasswordField("admin");

        panel.add(tfIPAddress);
        panel.add(tfPort);
        panel.add(new JPanel());
        panel.add(tfLogin);
        panel.add(password);
        panel.add(createButtonLogin());

        return panel;
    }

    private Component createScrollPanelMain() {
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane panel = new JScrollPane(log);

        return panel;
    }

    private Component createPanelBottom() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        panel.add(tfMessage, BorderLayout.CENTER);
        panel.add(createButtonSent(), BorderLayout.EAST);

        return panel;
    }

    private Component createButtonLogin() {
        btnLogin = new JButton(BTN_LOGIN);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                connectToServer();
            }
        });
        return btnLogin;
    }

    private Component createButtonSent() {
        btnSent = new JButton(BTN_SENT);
        btnSent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });
        return btnSent;
    }

    private void connectToServer(){
        try {
            if (chatServer.connectUser(this)){
                appendLog("Is successful");
                connect = true;
                name = tfLogin.getText();
                String log = chatServer.readFile();
                if (log != null){
                    appendLog(log);
                }
            } else {
                appendLog("Not connected");
            }
        }
        catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }

    }

    public void disconnectFromServer() {
        try {
            if (connect) {
                connect = false;
                chatServer.disconnectUser(this);
                appendLog("Server STOP");
            }
        }
        catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    private void appendLog(String text){
        log.append(text + "\n");
    }

    public void answer(String text){
        log.append(text);
    }

    public void sendMsg() {
        if (connect){
            String str = tfMessage.getText() + "\n";
            if (!str.equals("")){
                chatServer.addMsg(name + ": " + str);
                tfMessage.setText("");
            }
        } else {
            appendLog("Ошибка отправки сообщения, нет подключения к серверу");
        }
    }
}
