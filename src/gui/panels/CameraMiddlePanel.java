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
 * Class CameraMiddlePanel est la principale classe qui va prendre en charge l'utilisation de camera du laptop.
 *
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
     * Le constructeur init met en place les méthodes pour pour capturer des photos à l'aide de la caméra.
     *
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
    class TakePictureBehavior implements ActionListener {

        /**
         * Le constructeur "actionPerformed" va permettre de donner des attributs à la photo prise dans le constructeur du dessus.
         * @param e
         */
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
