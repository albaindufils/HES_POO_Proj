package src.gui.panels;

import src.gui.MainAppButton;
import src.helper.Constants;
import src.models.MyImage;

import javax.swing.*;
import java.awt.*;

public class MyImagePanel extends JPanel {
    MyImage currImage;
    MainAppButton image;
    JLabel lbl_name;
    JLabel lbl_path;
    JLabel lbl_creation_date;
    JLabel lbl_modification_date;
    public MyImagePanel() {
        super(new FlowLayout());
        init();
    }
    public void init() {
        image = new MainAppButton();
        lbl_name=new JLabel();
        lbl_path=new JLabel();
        lbl_creation_date=new JLabel();
        lbl_modification_date=new JLabel();
    }


    public void setCurrImage(MyImage img) {
        System.out.println(getParent().getHeight());

        currImage = img;
        image.setButton(Constants.IMAGES_DATA_PATH + currImage.getPath(),getParent().getHeight(),getParent().getWidth());
        System.out.println(image.getIcon().getIconHeight());
        lbl_name.setText(currImage.getName());
        lbl_path.setText(currImage.getPath());
        lbl_creation_date.setText(currImage.getCreation_date());
        lbl_modification_date.setText(currImage.getModification_date());
        add(lbl_name);
        add(lbl_creation_date);
        add(lbl_modification_date);
        add(image);
    }
}
