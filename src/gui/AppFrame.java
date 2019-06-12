package src.gui;


import src.helper.Constants;
import src.gui.panels.*;

import javax.swing.*;
import java.awt.*;


public class AppFrame extends JFrame {
    JPanel topPanel = new TopPanel();
    JPanel middlePan = new MainMiddlePanel();

    public  AppFrame() {
        super();
        initFrame();
    }

    /**
     * le constructeur "initFrame" va permettre intialiser le la structure principal et la gardée constante.
     */
    private void initFrame() {
        setSize(Constants.MAIN_FRAME_WIDTH, Constants.MAIN_FRAME_HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        add(topPanel,BorderLayout.NORTH);
        add(middlePan,BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
