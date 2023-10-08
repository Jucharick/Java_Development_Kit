package ru.jucharick.lesson_1_chat;
import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    ServerWindow(){
        setSize(WIDTH, HEIGHT);
        setTitle("Server - window");
        setResizable(false);

        setVisible(true);
    }
}
