package src.gui.panels;

import src.Constants;
import src.gui.MainAppButton;

import javax.swing.*;
import java.awt.*;


public class MiddlePanel extends MyPanel  {
    JButton btnContact = new MainAppButton(Constants.CONTACT_ICON,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JButton btnGalerie = new MainAppButton(Constants.GALLERIE_ICON,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    // JButton btnPhoto = new MainAppButton(Constants.ASSETS_PLANE_PNG,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);

    public MiddlePanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        add(btnContact);
        add(btnGalerie);
        //add(btnPhoto);
    }


}