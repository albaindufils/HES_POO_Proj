package gui.panels;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;




public class TopPanel extends JPanel  {
    private JLabel datetime=new JLabel("10:41");
    private JLabel avion=new JLabel("avion");
    
    public TopPanel() {
        super();
        setLayout(new BorderLayout());
        add(datetime,BorderLayout.CENTER);
        /* add(avion,BorderLayout.WEST); */
    }
}