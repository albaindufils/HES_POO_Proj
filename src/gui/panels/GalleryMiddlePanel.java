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

/**
 *
 */
public class GalleryMiddlePanel extends MyPanel {
    private JPanel imagesPanel;
    private MyImagePanel imagePanel;
    private MyImagesList imagesList;
    private JPanel cards;
    private CardLayout card_manager;
    private MainAppButton btnRetour;
    private MainAppButton btnNext;
    private MainAppButton btnPrevious;

    /**
     *
     */
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
        btnNext = new MainAppButton(Constants.NEXT_IMAGE, Constants.BACK_SIZE,Constants.BACK_SIZE);
        btnPrevious = new MainAppButton(Constants.PREVIOUS_IMAGE, Constants.BACK_SIZE,Constants.BACK_SIZE);
        imagePanel.getTopPanel().add(btnRetour,BorderLayout.WEST);
        /*imagePanel.add(btnNext,BorderLayout.EAST);
        imagePanel.add(btnPrevious,BorderLayout.WEST);*/

        JScrollPane jp = new JScrollPane(imagesPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cards.add(jp,"imagesPanel");
        cards.add(imagePanel,"imagePanel");
        add(cards,BorderLayout.CENTER);


        imagesList = new MyImagesList();

        /*for (MyImage img : imagesList.getArrayList()) {
            MainAppButton btn = new MainAppButton(Constants.IMAGES_DATA_PATH + img.getPath(),100,100);
            btn.addActionListener(new ImageButtonBehavior(img,"imagePanel"));
            btnRetour.addActionListener(new ImageButtonBehavior());
            imagesPanel.add(btn);
        }*/
        btnRetour.addActionListener(new ImageButtonBehavior(-1,"imagesPanel"));

        for (int i=0; i<imagesList.getArrayList().size(); i++){
            System.out.println(i);
            MyImage img = imagesList.getArrayList().get(i);
            MainAppButton btn = new MainAppButton(Constants.IMAGES_DATA_PATH + img.getPath(),100,100);
            btn.addActionListener(new ImageButtonBehavior(i,"imagePanel"));
            imagesPanel.add(btn);
        }
        imagePanel.add(btnPrevious,BorderLayout.WEST);
        imagePanel.add(btnNext,BorderLayout.EAST);
    }

   /* class ImageButtonNavigation implements ActionListener {
        private MyImage img;
        private int index;
        public ImageButtonNavigation(int index) {
            img = imagesList.getArrayList().get(index);
            this.index=index;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.print(index);
            imagePanel.setCurrImage(img);
        }
    }*/
    class ImageButtonBehavior implements ActionListener {
        private int img_index;
        private String card_index;
        private MyImage img;
        public ImageButtonBehavior(int img_index, String card_index){
            this.img_index = img_index;
            this.card_index = card_index;
            if(img_index >= 0 && img_index < imagesList.getArrayList().size()-1) {
                this.img = imagesList.getArrayList().get(img_index);
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            card_manager.show(cards, card_index);
            System.out.println(img_index+":"+imagesList.getArrayList().size());
            if(img_index >= 0 && img_index < imagesList.getArrayList().size()-1) {
                imagePanel.setCurrImage(img);
                removeAllAction(btnNext);
                removeAllAction(btnPrevious);
                btnNext.addActionListener(new ImageButtonBehavior(img_index+1,"imagePanel"));
                btnPrevious.addActionListener(new ImageButtonBehavior(img_index-1,"imagePanel"));
            }
        }
        private void removeAllAction(JButton btn) {
            for( ActionListener al : btn.getActionListeners() ) {
                btn.removeActionListener( al );
            }
        }
    }
}
