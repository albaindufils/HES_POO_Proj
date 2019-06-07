package src.gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class MyPanel extends JPanel {
    public MyPanel(LayoutManager lay) {
        super(lay);
        init();
    }
    protected abstract void init();

}
