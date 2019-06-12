package src.gui.panels;

import src.helper.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * La class "HomeMiddlePanel" va hériter des méthodes de la class "MyPanel".
 *le bufferedImage est la mise en mémoire tempon des données image "BACKGROUND_IMAGE".
 */
public class HomeMiddlePanel extends MyPanel {
    private BufferedImage image;

    /**
     * Le "HomeMiddlePanel" va permettre d'appeler la methode setBackgroudImge
     * pour ajouter le fond d'écran à la HomeMiddlePanel
     */
    public HomeMiddlePanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        setBackgroundImage();
    }

    /**
     * Le "setBackgroundImage" va permettre de lire le fichier contenant
     * l'image de la capture d'écran. 
     */

    private void setBackgroundImage() {
        try {
            image = ImageIO.read(new File(Constants.BACKGROUND_IMAGE));

        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(true);
    }

    /**
     * le constructeur "init" va lancer l'affichage de la home page
     * avec son image de fond d'écran.
     */
    @Override
    protected void init() {

    }

    /**
     * cette méthode  reçoit en arguments une image, les coordonnées du coin supérieur gauche,
     * les dimensions (l'image d'origine pourra être dilatée ou réduite en fonction de ces indications)
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image.getScaledInstance(Constants.MAIN_FRAME_WIDTH,Constants.MAIN_FRAME_HEIGHT,Image.SCALE_SMOOTH), 0, 0, this);
    }

}
