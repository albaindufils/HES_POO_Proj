package src.helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

/**
 * La class "Constants" contient les valeurs static de la strucutre, des icones et fond d'ecran.
 * Toutes ces valeurs doivent rester inchangée et seront utilisée dans les autres classes.
 */
public final class Constants {
    public static final int MAIN_FRAME_WIDTH = 480;
    public static final int MAIN_FRAME_HEIGHT = 800;
    public static final int MAIN_BTN_WIDTH = 65;
    public static final int MAIN_BTN_HEIGHT = 65;
    public static final int BACK_SIZE = 25;
    public static final String ASSETS_HOME_PNG = "src/assets/home.png";
    public static final String CONTACT_ICON = "src/assets/ios_icons/Contacts.png";
    public static final String GALLERIE_ICON = "src/assets/ios_icons/Photos.png";
    public static final String PICTURE_ICON = "src/assets/ios_icons/Camera.png";
    public static final String IMAGES_DATA_PATH = "src/data_images/";
    public static final String IMAGES_JSON_FILE = IMAGES_DATA_PATH + "images.json";
    public static final String BACKGROUND_IMAGE = "src/assets/phone-back.jpg";
    public static final String BACK_IMAGE = "src/assets/back.png";
    public static final String PREVIOUS_IMAGE = "src/assets/previous.png";
    public static final String NEXT_IMAGE = "src/assets/next.png";
    public static final String TRASH_IMAGE = "src/assets/delete.png";
    public static final String ADD_PIC_IMAGE = "src/assets/add-image.png";
    public static final String TAKE_PIC_IMAGE = "src/assets/take-pic.png";

    public static final Color FONT_COLOR = Color.WHITE;
    public static final Color TOP_PANEL_COLOR = Color.BLACK;
    public static final DateTimeFormatter CLOCK_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
    public static final DateTimeFormatter DATETIME_FILE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
    private Constants() {}

    /**
     * Le constructeur "Dimension" va permettre de réajuster les dimensions de l'image.
     * Vue que les images ne sont pas toujours dans le même format the constructeur va forcer le format des images de la galerie.
     * @param img_tmp
     * @param parent_width
     * @param parent_height
     * @return
     */
    public static Dimension getRatioImage(Image img_tmp, int parent_width, int parent_height){
        int width_final = 0;
        int height_final = 0;
        int width = img_tmp.getWidth(null);
        int height = img_tmp.getHeight(null);

        if(height == width) {
            height_final = parent_width;
            width_final = parent_width;
        } else if(height > width){
            height_final = parent_height;
            width_final = (height_final * width) / height;
        } else if(height < width){
            width_final = parent_width;
            height_final = (width_final * height) / width;
        }
        return new Dimension(width_final,height_final);
    }

    /**
     * le constructeur "removeAllActionInButton" va permettre un retour au mainpanel ou ce trouve les icons des applications.
     * @param btn
     */
    public static void removeAllActionInButton(JButton btn) {
        for(ActionListener al: btn.getActionListeners() ) {
            btn.removeActionListener(al);
        }
    }

}
