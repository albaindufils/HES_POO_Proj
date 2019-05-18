package src.gui;

import src.Constants;

import javax.swing.JButton;
import java.awt.*;

public class MainAppButton extends JButton {
    public MainAppButton(String title) {
        super(title);
        setPreferredSize(new Dimension(Constants.buttonMainWidth,Constants.buttonMainHeight));
    }
}