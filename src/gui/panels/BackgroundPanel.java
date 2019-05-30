package src.gui.panels;

import src.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private BufferedImage image;
    public BackgroundPanel() {
        super(new BorderLayout());
        try {
            image = ImageIO.read(new File(Constants.BACKGROUND_IMAGE));

        } catch (IOException ex) {
            // handle exception...
        }
    }
    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(image.getScaledInstance(Constants.MAIN_FRAME_WIDTH,Constants.MAIN_FRAME_HEIGHT,Image.SCALE_SMOOTH), 0, 0, this); // see javadoc for more info on the parameter

    }
}
