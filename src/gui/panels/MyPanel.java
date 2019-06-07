package src.gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class MyPanel extends JPanel {
    public MyPanel(LayoutManager lay) {
        super(lay);
    }
    protected abstract void init();

}
