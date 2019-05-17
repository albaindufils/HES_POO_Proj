package src.gui;

import gui.*;
import src.*;
import gui.panels.TopPanel;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;;



public class AppFrame extends JFrame {
     
    JPanel bot = new TopPanel();
    public AppFrame() {
        add(bot,BorderLayout.NORTH);
        setSize(Constants.frameHeight, Constants.frameHeight);
        setVisible(true);
    }
}
