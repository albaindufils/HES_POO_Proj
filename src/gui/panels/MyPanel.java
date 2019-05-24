package src.gui.panels;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel(LayoutManager lay) {
        super(lay);
        initPanel();
    }
    private void initPanel() {
        setOpaque(true);
        setBackground(new Color(0,0,0,0));

    }
}
