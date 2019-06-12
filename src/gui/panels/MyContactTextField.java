package src.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * La classe "MyContactTextField" va hériter des
 * fonctions JtextField qui seront utiliser pour les classes contacts.
 * La dimension du text à afficher a été initiée.
 */

public class MyContactTextField extends JTextField {

    public MyContactTextField(Dimension maxDim) {
        super();
        setMaximumSize(maxDim);
    }
}
