package src.gui.panels;

import src.helper.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeMiddlePanel extends MyPanel {
    private BufferedImage image;

    public HomeMiddlePanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        setBackgroundImage();
    }
    private void setBackgroundImage() {
        try {
            image = ImageIO.read(new File(Constants.BACKGROUND_IMAGE));

        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(true);
    }
    @Override
    protected void init() {

    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image.getScaledInstance(Constants.MAIN_FRAME_WIDTH,Constants.MAIN_FRAME_HEIGHT,Image.SCALE_SMOOTH), 0, 0, this);
    }

}
