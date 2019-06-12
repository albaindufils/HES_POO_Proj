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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

/**
 *La class "GalleryMiddlePanel" possède les différents attributs lié
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
    private MainAppButton btnTrash;
    private JLabel lblNbrPic;
    private MainAppButton btnAddImage;
    private JFileChooser jFileChooser;


    /**
     *le constructeur "GalleryMiddlePanel" va créer et initialiser un borderlayout
     *init lancer l
     */
    public GalleryMiddlePanel() {

        super(new BorderLayout());
        init();
    }
    public void updateList() {
        for (int i=0; i<imagesList.getArrayList().size(); i++){
            MyImage img = imagesList.getArrayList().get(i);
            if(img.getImageButton() == null) {
                imagesPanel.remove(btnAddImage);
                addBtnToGUI(i);
                imagesPanel.add(btnAddImage);
                System.out.println(img.getName());
            }
        }
    }
    @Override
    protected void init() {
        cards = new JPanel(new CardLayout());
        imagesPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
        imagePanel = new MyImagePanel();
        lblNbrPic = new JLabel("-/-");
        card_manager = (CardLayout) cards.getLayout();
        btnRetour = new MainAppButton(Constants.BACK_IMAGE,Constants.BACK_SIZE,Constants.BACK_SIZE);
        btnNext = new MainAppButton(Constants.NEXT_IMAGE, Constants.BACK_SIZE,Constants.BACK_SIZE);
        btnPrevious = new MainAppButton(Constants.PREVIOUS_IMAGE, Constants.BACK_SIZE,Constants.BACK_SIZE);
        btnTrash = new MainAppButton(Constants.TRASH_IMAGE, Constants.BACK_SIZE,Constants.BACK_SIZE);
        btnAddImage = new MainAppButton(Constants.ADD_PIC_IMAGE, Constants.MAIN_BTN_HEIGHT,Constants.MAIN_BTN_HEIGHT);
        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("./"));
        imagePanel.getTopPanel().add(btnRetour,BorderLayout.WEST);
        imagePanel.getTopPanel().add(btnTrash,BorderLayout.EAST);
        imagePanel.getTopPanel().add(lblNbrPic,BorderLayout.SOUTH);
        lblNbrPic.setHorizontalAlignment(JLabel.CENTER);
        lblNbrPic.setFont(javax.swing.UIManager.getDefaults().getFont("Label.font"));


        btnTrash.addActionListener(new ImageButtonBehavior(-1,"imagesPanel"));
        JScrollPane jp = new JScrollPane(imagesPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cards.add(jp,"imagesPanel");
        cards.add(imagePanel,"imagePanel");
        add(cards,BorderLayout.CENTER);


        imagesList = MyImagesList.getInstance();
        btnRetour.addActionListener(new ImageButtonBehavior(-1,"imagesPanel"));

        for (int i=0; i<imagesList.getArrayList().size(); i++){
            addBtnToGUI(i);
        }


        imagesPanel.add(btnAddImage);
        btnAddImage.addActionListener(new AddImageBehavior());

        imagePanel.add(btnPrevious,BorderLayout.WEST);
        imagePanel.add(btnNext,BorderLayout.EAST);
        
    }
    private void addBtnToGUI(int indexOfArrayList) {
        MyImage img = imagesList.getArrayList().get(indexOfArrayList);
        MainAppButton btn = new MainAppButton(Constants.IMAGES_DATA_PATH + img.getPath(),Constants.MAIN_BTN_HEIGHT, Constants.MAIN_BTN_WIDTH);
        img.setImageButton(btn);
        Dimension img_size = Constants.getRatioImage(btn.getImage(), Constants.MAIN_BTN_WIDTH, Constants.MAIN_BTN_HEIGHT);
        btn.setButton(Constants.IMAGES_DATA_PATH + img.getPath(),img_size.height,img_size.width);
        btn.addActionListener(new ImageButtonBehavior(indexOfArrayList,"imagePanel"));
        imagesPanel.add(btn);
    }
    private void reconfigueButtonBehaviorFromImage() {
        for (int i=0; i<imagesList.getArrayList().size(); i++){
            MyImage img = imagesList.getArrayList().get(i);
            Constants.removeAllActionInButton(img.getImageButton());
            img.getImageButton().addActionListener(new ImageButtonBehavior(i,"imagePanel"));
        }


    }

    class AddImageBehavior implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = jFileChooser.showOpenDialog(new JFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                File sel = jFileChooser.getSelectedFile();
                String new_date = Constants.DATETIME_FILE_FORMATTER.format(LocalDateTime.now());
                Path fileToCopy = Paths.get(sel.getPath());
                Path newFile = Paths.get(Constants.IMAGES_DATA_PATH+new_date+"_"+sel.getName());
                MyImage img = imagesList.addImage(new_date+"_"+sel.getName(),sel.getName(),new_date,new_date);
                try {
                    Files.copy(fileToCopy, newFile, StandardCopyOption.REPLACE_EXISTING);
                }
                catch (IOException err){
                    err.printStackTrace();
                }

                MainAppButton btn = new MainAppButton(newFile.toString(),Constants.MAIN_BTN_HEIGHT, Constants.MAIN_BTN_WIDTH);
                img.setImageButton(btn);
                Dimension img_size = Constants.getRatioImage(btn.getImage(), Constants.MAIN_BTN_WIDTH, Constants.MAIN_BTN_HEIGHT);
                btn.setButton(Constants.IMAGES_DATA_PATH + img.getPath(),img_size.height,img_size.width);
                btn.addActionListener(new ImageButtonBehavior(imagesList.getArrayList().size()-1,"imagePanel"));

                imagesPanel.remove(btnAddImage);
                imagesPanel.add(btn);
                imagesPanel.add(btnAddImage);

            }
        }
    }
    class DeleteImageBehavior implements ActionListener {
        private MyImage img;
        public DeleteImageBehavior(MyImage img) {
            this.img = img;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("delete image");
            img.deleteImage();
            imagesPanel.remove(img.getImageButton());
            imagesList.getArrayList().remove(img);
            reconfigueButtonBehaviorFromImage();
        }
    }
    class ImageButtonBehavior implements ActionListener {
        private int img_index;
        private String card_index;
        private MyImage img;
        public ImageButtonBehavior(int img_index, String card_index){
            this.img_index = img_index;
            this.card_index = card_index;
            if(img_index >= 0 && img_index <= imagesList.getArrayList().size()-1) {
                this.img = imagesList.getArrayList().get(img_index);
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            card_manager.show(cards, card_index);
            System.out.println(img_index+":"+imagesList.getArrayList().size());
            if(img_index >= 0 && img_index <= imagesList.getArrayList().size()-1) {
                imagePanel.setCurrImage(img);
                Constants.removeAllActionInButton(btnNext);
                Constants.removeAllActionInButton(btnPrevious);
                Constants.removeAllActionInButton(btnTrash);
                btnNext.addActionListener(new ImageButtonBehavior(img_index+1,"imagePanel"));
                btnPrevious.addActionListener(new ImageButtonBehavior(img_index-1,"imagePanel"));
                btnTrash.addActionListener(new ImageButtonBehavior(-1,"imagesPanel"));
                btnTrash.addActionListener(new DeleteImageBehavior(img));
                lblNbrPic.setText((img_index+1) + " / " + imagesList.getArrayList().size());
            }
        }
    }
}
