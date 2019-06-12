package src.gui.panels;

import src.gui.MainAppButton;
import src.helper.Constants;
import src.models.MyImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La class "MyImagePanel"
 */

public class MyImagePanel extends JPanel {
    MyImage currImage;
    MainAppButton image;
    JTextField txt_name;
    JLabel lbl_path;
    JLabel lbl_name;
    JLabel lbl_creation_date;
    JLabel lbl_modification_date;
    JPanel topPanel;
    JPanel bottomPanel;
    JSlider js;

    /**
     * Le constructeur "MyImagePanel" fait appel à la classe 
     */
    public MyImagePanel() {
        super(new BorderLayout());
        init();
    }
    public void init() {
        image = new MainAppButton();
        txt_name=new JTextField();
        lbl_path=new JLabel();
        lbl_name=new JLabel();
        lbl_creation_date=new JLabel();
        lbl_modification_date=new JLabel();
        topPanel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
        txt_name.addKeyListener(new KeyWritted());
        js = new JSlider(JSlider.HORIZONTAL,0,100,50);
    }
    public JPanel getTopPanel() {
        return topPanel;
    }

    /**
     * Cette fonction sert à mettre à jour le panel
     */
    private void update() {
        txt_name.setText(currImage.getName());
        lbl_path.setText("Filename: " + currImage.getPath());
        lbl_name.setText("Name: " + currImage.getName());
        lbl_creation_date.setText("Creation date: " + currImage.getCreation_date());
        lbl_modification_date.setText("Modification date: " + currImage.getModification_date());
    }

    /**
     * @param img
     */
    public void setCurrImage(MyImage img) {
        currImage = img;
        image.setImage(Constants.IMAGES_DATA_PATH + currImage.getPath());
        Dimension img_size = Constants.getRatioImage(image.getImage(),getParent().getWidth(),getParent().getHeight());
        image.setButton(Constants.IMAGES_DATA_PATH + currImage.getPath(),img_size.height,img_size.width);
        update();
        topPanel.add(txt_name);
        bottomPanel.add(js);
        bottomPanel.add(lbl_creation_date);
        bottomPanel.add(lbl_modification_date);
        bottomPanel.add(lbl_path);
        bottomPanel.add(lbl_name);
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        add(image, BorderLayout.CENTER);



    }

    class KeyWritted implements KeyListener {
        public KeyWritted() {}
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {
            currImage.setName(((JTextField) e.getSource()).getText());
            currImage.setModificationDateNow();
            update();
        }
    }
}
