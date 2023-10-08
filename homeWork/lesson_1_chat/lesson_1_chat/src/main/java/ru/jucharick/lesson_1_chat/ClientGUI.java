package ru.jucharick.lesson_1_chat;
import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    ClientGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat client");
        setResizable(false);

        setVisible(true);
    }
}
