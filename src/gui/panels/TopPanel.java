package src.gui.panels;

import src.helper.Constants;
import src.gui.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;


public class TopPanel extends MyPanel  {


    /**
     * Le JLabel ci-dessous va aider à ajouter l'horloge sur le haute de notre application.
     *
     */

    private JLabel datetime = new MyLabel(getTimeFormatted());

    /**
     * La méthode TopPanel va permettre de la'fficher au haut du cadre.
     */
    public TopPanel() {
        super(new BorderLayout());
        init();
    }

    /**
     * cette méthode init va permettre son affichage à l'endroit souhaité.
     */

    @Override
    protected void init() {
        setBackground(Constants.TOP_PANEL_COLOR);
        add(datetime,BorderLayout.CENTER);
        initDatetimeLable();
        setTimer();
    }

    /**
     * La méthode "setTimer" va permettre de configurer le bon format.
     */

    private void setTimer() {
        Timer timer = new Timer(1000, e -> {
            updateTime(getTimeFormatted());
        });
        timer.start();
    }
    private void updateTime(String time) {
       datetime.setText(time);
    }
    private String getTimeFormatted() {
        return Constants.CLOCK_DATETIME_FORMATTER.format(LocalDateTime.now());
    }
    private void initDatetimeLable() {
        datetime.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
