package src.gui.panels;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import src.gui.MainAppButton;
import src.helper.Constants;
import src.models.MyImagesList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Class CameraMiddlePanel contient les différents attributs qui seront utilisé pour
 * l'application camera de notre projet. Le boderlayout a été instanciée.
 */
public class CameraMiddlePanel extends MyPanel {
    private Webcam webcam;
    private MyImagesList myImagesList;
    private JPanel middlePan;
    public CameraMiddlePanel() {
        super(new BorderLayout());
        init();
    }

    /**
     * Le constructeur "init" va lancer l'affichage de l'application et
     * permettre l'utilisation de la webcam pour notre application camera.
     * cette caméra et connecté à la webcam de l'ordinateur et va permettre de prendre une photo
     * avec le bouton take_pic et celle-ci va être ajoutée dans la liste des images.
     */
    @Override
    protected void init() {
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        middlePan=new JPanel(new BorderLayout());
        WebcamPanel panel = new WebcamPanel(webcam);

        MainAppButton take_pic=new MainAppButton(Constants.TAKE_PIC_IMAGE,50,50);
        take_pic.setBackground(Color.BLACK);
        take_pic.setOpaque(true);
        take_pic.addActionListener(new TakePictureBehavior());
        middlePan.add(panel,BorderLayout.CENTER);
        middlePan.add(take_pic, BorderLayout.SOUTH);
        add(middlePan, BorderLayout.CENTER);
        myImagesList=MyImagesList.getInstance();
    }

    /**
     * Cette classe va définir les différents attributs de la photo prise par la caméra.
     * la date d'aujourd'hui avec "now" et l'attribut "webcam.png" pour chaque photo.
     * le format de l'image est définit en png comme mentionné dans le formatName.
     */
    class TakePictureBehavior implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                webcam = Webcam.getDefault();
                webcam.open();
                String now = Constants.DATETIME_FILE_FORMATTER.format(LocalDateTime.now());
                String name = now+"_webcam.png";
                String path = Constants.IMAGES_DATA_PATH+name;
                ImageIO.write(webcam.getImage(), "PNG", new File(path));
                myImagesList.addImage(name,name,now,now);
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }
}
