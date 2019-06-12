package src.gui.panels;

import src.helper.Constants;
import src.gui.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;


/**
 * la class "TopPanel" va permettre de setuper le dessus de l'écran avec l'orloge temps.
 */
public class TopPanel extends MyPanel  {
    

    private JLabel datetime = new MyLabel(getTimeFormatted());

    public TopPanel() {
        super(new BorderLayout());
        init();
    }

    @Override
    protected void init() {
        setBackground(Constants.TOP_PANEL_COLOR);
        add(datetime,BorderLayout.CENTER);
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
        return Constants.CLOCK_DATETIME_FORMATTER.format(LocalDateTime.now());
    }
    private void initDatetimeLable() {
        datetime.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
