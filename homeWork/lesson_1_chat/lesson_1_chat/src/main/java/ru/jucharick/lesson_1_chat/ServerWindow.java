package ru.jucharick.lesson_1_chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;
    public static final String LOG_PATH = "src/main/java/ru/jucharick/lesson_1_chat/log.txt";

    public static final String BTN_START = "Start";
    public static final String BTN_STOP = "Stop";


    JButton btnStart;
    JButton btnStop;

    ServerWindow(){
        setSize(WIDTH, HEIGHT);
        setTitle("Server - window");
        setResizable(false);

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
                System.exit(0);
            }
        });
        return btnStart;
    }

    private Component createButtonStop() {
        btnStop = new JButton(BTN_STOP);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return btnStop;
    }
}
