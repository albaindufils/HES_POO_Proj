package src.gui;

import src.helper.Constants;

import javax.swing.*;

/**
 * La classe "MyLabel" permet de définir la couleur de font.
 */
public class MyLabel extends JLabel {
    public MyLabel(String name) {
        super(name);
        setForeground(Constants.FONT_COLOR);
    }
}
