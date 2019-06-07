package src.helper;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public final class Constants {
    public static final int MAIN_FRAME_WIDTH = 480;
    public static final int MAIN_FRAME_HEIGHT = 800;
    public static final int MAIN_BTN_WIDTH = 65;
    public static final int MAIN_BTN_HEIGHT = 65;
    public static final String ASSETS_HOME_PNG = "src/assets/home.png";
    public static final String CONTACT_ICON = "src/assets/ios_icons/Contacts.png";
    public static final String GALLERIE_ICON = "src/assets/ios_icons/Photos.png";
    public static final String PICTURE_ICON = "src/assets/ios_icons/Camera.png";
    public static final String IMAGES_DATA_PATH = "src/data_images/";
    public static final String IMAGES_JSON_FILE = IMAGES_DATA_PATH + "images.json";
    public static final String BACKGROUND_IMAGE = "src/assets/phone-back.jpg";
    public static final Color FONT_COLOR = Color.WHITE;
    public static final Color TOP_PANEL_COLOR = Color.BLACK;
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
    private Constants() {}
}
