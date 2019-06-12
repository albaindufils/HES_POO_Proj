package src.gui;


import src.helper.Constants;
import src.gui.panels.*;

import javax.swing.*;
import java.awt.*;


/**
 * La classe "AppFrame" instancie les deux principal panel.
 *
 */

public class AppFrame extends JFrame {
    JPanel topPanel = new TopPanel();
    JPanel middlePan = new MainMiddlePanel();

    /**
     *
     */

    public  AppFrame() {
        super();
        initFrame();
    }

    /**
     * Le constructeur "initFrame" va permettre de lancer l'affichage
     * du frame principal. il va aussi permettre l'affichage des topPanel
     * et du middlePanel. Le "setDefaultCloseOperation" va permettre
     * d'arrêter automatiquement l'application une fois l'application fermée.
     */

    private void initFrame() {
        setSize(Constants.MAIN_FRAME_WIDTH, Constants.MAIN_FRAME_HEIGHT);
        setLayout(new BorderLayout());
        setResizable(true);
        add(topPanel,BorderLayout.NORTH);
        add(middlePan,BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
