package src.gui;


import src.Constants;
import src.gui.panels.*;

import javax.swing.*;
import java.awt.*;


public class AppFrame extends JFrame {
    JPanel topPanel = new TopPanel();
    JPanel middlePan = new MainMiddlePanel();
    JPanel backImage = new BackgroundPanel();

    public  AppFrame() {
        super();
        initFrame();

        add(backImage);
        backImage.add(topPanel,BorderLayout.NORTH);
        backImage.add(middlePan,BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initFrame() {
        setSize(Constants.MAIN_FRAME_WIDTH, Constants.MAIN_FRAME_HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

    }
}
