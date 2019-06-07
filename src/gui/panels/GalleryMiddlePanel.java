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
    public GalleryMiddlePanel() {
        super(new BorderLayout());
        cards = new JPanel(new CardLayout());
        imagesPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
        imagePanel = new MyImagePanel();
        card_manager = (CardLayout) cards.getLayout();
        init();
    }
    @Override
    protected void init() {
        JScrollPane jp = new JScrollPane(imagesPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cards.add(jp,"imagesPanel");
        cards.add(imagePanel,"imagePanel");
        add(cards,BorderLayout.CENTER);


        imagesList = new MyImagesList();

        for (MyImage img : imagesList.getArrayList()) {
            MainAppButton btn = new MainAppButton(Constants.IMAGES_DATA_PATH + img.getPath(),100,100);
            btn.addActionListener(new ImageButtonBehavior(img));
            imagesPanel.add(btn);
        }
    }
    class ImageButtonBehavior implements ActionListener {
        private MyImage img;
        public ImageButtonBehavior(MyImage img){
            this.img = img;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            card_manager.show(cards,"imagePanel");
            imagePanel.setCurrImage(img);
            System.out.println(img.getName());
        }
    }
}
