package src.gui.panels;

import src.gui.MainAppButton;
import src.helper.Constants;
import src.helper.WrapLayout;
import src.models.MyImage;
import src.models.MyImagesList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GalleryMiddlePanel extends MyPanel {
    private JPanel imagesPanel;
    private MyImagePanel imagePanel;
    private MyImagesList imagesList;
    private JPanel cards;
    private CardLayout card_manager;
    private MainAppButton btnRetour;
    public GalleryMiddlePanel() {
        super(new BorderLayout());
        init();
    }
    @Override
    protected void init() {
        cards = new JPanel(new CardLayout());
        imagesPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
        imagePanel = new MyImagePanel();
        card_manager = (CardLayout) cards.getLayout();
        btnRetour = new MainAppButton(Constants.BACK_IMAGE,Constants.BACK_SIZE,Constants.BACK_SIZE);
        btnRetour.addActionListener(new ImageButtonBehavior(null,"imagesPanel"));
        imagePanel.getTopPanel().add(btnRetour,BorderLayout.WEST);

        JScrollPane jp = new JScrollPane(imagesPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cards.add(jp,"imagesPanel");
        cards.add(imagePanel,"imagePanel");
        add(cards,BorderLayout.CENTER);


        imagesList = new MyImagesList();

        for (MyImage img : imagesList.getArrayList()) {
            MainAppButton btn = new MainAppButton(Constants.IMAGES_DATA_PATH + img.getPath(),100,100);
            btn.addActionListener(new ImageButtonBehavior(img,"imagePanel"));
            imagesPanel.add(btn);
        }
    }
    class ImageButtonBehavior implements ActionListener {
        private MyImage img;
        private String card_index;
        public ImageButtonBehavior(MyImage img,String card_index){
            this.img = img;
            this.card_index = card_index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            card_manager.show(cards, card_index);
            if(img != null) {
                imagePanel.setCurrImage(img);
            }
        }
    }
}
