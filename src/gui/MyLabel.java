package src.gui;

import src.Constants;

import javax.swing.*;

public class MyLabel extends JLabel {
    public MyLabel(String name) {
        super(name);
        setForeground(Constants.FONT_COLOR);
    }
}