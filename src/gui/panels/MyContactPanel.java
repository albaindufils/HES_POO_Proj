package src.gui.panels;

import src.gui.MainAppButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyContactPanel extends JPanel {

    JTextField txt_Search;
    MainAppButton Contact;
    JPanel topPanel;

    public MyContactPanel() {
        super(new BorderLayout());
        init();
    }

    public void init() {

        Contact = new MainAppButton();
        txt_Search=new JTextField();
        txt_Search.addKeyListener(new MyContactPanel.KeyWritted());
        topPanel = new JPanel(new BorderLayout());
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
