package ru.jucharick.lesson_1_chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    private static final String BTN_LOGIN = "login";
    private static final String BTN_SENT = "sent";
    private boolean connected;

    JButton btnLogin, btnSent;
    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField password;

    ClientGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
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
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return btnLogin;
    }

    private Component createButtonSent() {
        btnSent = new JButton(BTN_SENT);
        btnSent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return btnSent;
    }

}
