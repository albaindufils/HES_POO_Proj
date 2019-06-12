package src.gui;

import javax.swing.*;
import java.awt.*;

/**
 *La classe "MainAppButton" contient tous les bontons changement ou initialisation
 * d'image faite sur l'application.
 */
public class MainAppButton extends JButton {
    private ImageIcon basedImageIcon;
    private int height;
    private int width;
    public MainAppButton(String iconPath, int height, int width) {
        super();
        setButton(iconPath,height,width);
    }
    public MainAppButton() {
        super();
    }
    public void setButton(String iconPath, int height, int width) {
        setImage(iconPath);
        this.height = height;
        this.width = width;
        initializeButton();
    }

    /**
     * Cette méthode définit la taille des images en format icon.
     * pour que toutes les images soient au même format et qu'elles n'empiètent pas sur les autres.
     * @param iconPath
     */
    public void setImage(String iconPath) {
        basedImageIcon = new ImageIcon(iconPath);
    }
    private void initializeButton() {
        setPreferredSize(new Dimension(width,height));
        setBorder(null);
        setBackground(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        Image img = basedImageIcon.getImage().getScaledInstance(width-(5/100*width),(height-(5/100*height)),Image.SCALE_AREA_AVERAGING);

        setIcon(new ImageIcon(img));
    }

    /**
     * La méthode "getImage" pour l'obtention d'une nouvelle image dans les icones.
     * @return
     */
    public Image getImage() {
        return basedImageIcon.getImage();
    }
}
