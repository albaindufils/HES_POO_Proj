package src.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * La class "BackgroundPanel" va hériter des méthodes de "Jpanel".
 *Construit un nouveau border layout sans espaces entre les composants.
 */
public class BackgroundPanel extends JPanel {
    public BackgroundPanel() {
        super(new BorderLayout());
    }

}
