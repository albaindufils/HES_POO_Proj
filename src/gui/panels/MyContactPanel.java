package src.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyContactPanel extends JPanel {

    private JTextField txt_Search;
    private JPanel topPanel;
    private JPanel middlePanel;


    public MyContactPanel() {
        super(new BorderLayout());
        init();
    }

    public void init() {
        middlePanel = new JPanel(new SpringLayout());
        middlePanel.add(new JLabel("Label: "));
        middlePanel.add(new JTextField("Text field", 15));
        add(middlePanel,BorderLayout.CENTER);
    }


    class KeyWritted implements KeyListener {
        public KeyWritted() {}
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
