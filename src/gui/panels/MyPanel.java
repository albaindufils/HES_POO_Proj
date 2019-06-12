package src.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 *La class "myPanel" est abstract, pour permettre de la redefinir dans les classes filles MiddlePanel et TopPanel.
 *La constructeur init va lancer l'affichage.
 */
public abstract class MyPanel extends JPanel {
    public MyPanel(LayoutManager lay) {
        super(lay);
    }
    protected abstract void init();

}
