package src.gui.panels;

import src.helper.Constants;
import src.gui.MainAppButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *La classe "MainMiddlePanel" contient tous les attributs utilisé
 * dans la vue principal de l'application. Dans cette nous allons
 * retrouver les boutons contacts, gallery, camera et même le bouton back
 * pour le retour à la page initiale. toutes les valeurs ont été instancié dans cette classe.
 */
public class MainMiddlePanel extends MyPanel  {
    JButton btnContact = new MainAppButton(Constants.CONTACT_ICON,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JButton btnGallery = new MainAppButton(Constants.GALLERIE_ICON,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JButton btnPhoto = new MainAppButton(Constants.PICTURE_ICON,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JButton btnBackContact = new MainAppButton(Constants.ASSETS_HOME_PNG,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JButton btnBackGallery = new MainAppButton(Constants.ASSETS_HOME_PNG,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JButton btnBackCamera = new MainAppButton(Constants.ASSETS_HOME_PNG,Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_WIDTH);
    JPanel cards = new JPanel(new CardLayout());
    JPanel contactPanel = new ContactMiddlePanel();
    JPanel cameraPanel = new CameraMiddlePanel();
    GalleryMiddlePanel galleryPanel = new GalleryMiddlePanel();
    JPanel btnPanel = new HomeMiddlePanel();

    CardLayout card_manager;


    /**
     * Le constructeur "MainMiddlePanel" va permettre d'instancier le BorderLayout.
     * et le "init" va permettre de lancer l'affichage.
     */

    public MainMiddlePanel() {
        super(new BorderLayout());
        card_manager = (CardLayout) cards.getLayout();
        init();
    }

    /**
     * On peut voir que dans le "init"
     */

    @Override
    protected void init() {


        btnContact.addActionListener(new ButtonBehaviors("contactPanel"));
        btnGallery.addActionListener(new ButtonBehaviors( "galleryPanel"));
        btnPhoto.addActionListener(new ButtonBehaviors( "cameraPanel"));
        btnBackContact.addActionListener(new ButtonBehaviors( "btnPanel"));
        btnBackGallery.addActionListener(new ButtonBehaviors( "btnPanel"));
        btnBackCamera.addActionListener(new ButtonBehaviors( "btnPanel"));
        btnPanel.add(btnContact);
        btnPanel.add(btnGallery);
        btnPanel.add(btnPhoto);
        contactPanel.add(btnBackContact,BorderLayout.SOUTH);
        galleryPanel.add(btnBackGallery,BorderLayout.SOUTH);
        cameraPanel.add(btnBackCamera,BorderLayout.SOUTH);
        cards.add(btnPanel,"btnPanel");
        cards.add(contactPanel,"contactPanel");
        cards.add(galleryPanel,"galleryPanel");
        cards.add(cameraPanel,"cameraPanel");
        // add(btnPanel,BorderLayout.NORTH);
        add(cards);
        card_manager.show(cards,"btnPanel");
    }

    class ButtonBehaviors implements ActionListener {
        private String index;
        public ButtonBehaviors(String index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            card_manager.show(cards,index);
            if(index == "galleryPanel") {
                galleryPanel.updateList();
            }
        }
    }
}

