package src.gui.panels;

import src.Constants;
import src.gui.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;


public class TopPanel extends MyPanel  {
    

    private JLabel datetime = new MyLabel(getTimeFormatted());
    //private JButton avion = new MainAppButton(Constants.ASSETS_PLANE_PNG,Constants.PLANE_SIZE, Constants.PLANE_SIZE);

    public TopPanel() {
        super(new BorderLayout());
        setBackground(Constants.TOP_PANEL_COLOR);
        add(datetime,BorderLayout.CENTER);
        // add(avion,BorderLayout.WEST);
        initDatetimeLable();
        setTimer();
    }
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
        return Constants.DATE_FORMATTER.format(LocalDateTime.now());
    }
    private void initDatetimeLable() {
        datetime.setHorizontalAlignment(SwingConstants.CENTER);
    }
}