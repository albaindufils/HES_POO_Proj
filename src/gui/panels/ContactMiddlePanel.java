package src.gui.panels;

import src.gui.MainAppButton;
import src.helper.Constants;

import javax.swing.*;
import java.awt.*;


public class ContactMiddlePanel extends MyPanel {

    private JPanel oneContactPanel;
    private JPanel middleInfos;
    private JPanel rightInfos;
    private JPanel contactsPanel;
    private JPanel cards;
    private MyContactPanel contactPanel;
    private JLabel name;
    private JLabel number;

    public ContactMiddlePanel() {
        super(new BorderLayout());
        init();
    }
    @Override
    protected void init() {

        cards = new JPanel(new CardLayout());
        contactsPanel = new JPanel(new GridBagLayout());
        contactPanel = new MyContactPanel();
        oneContactPanel = new JPanel(new BorderLayout());
        middleInfos = new JPanel();
        rightInfos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        middleInfos.setLayout(new BoxLayout(middleInfos,BoxLayout.Y_AXIS));
        rightInfos.setLayout(new BoxLayout(rightInfos,BoxLayout.Y_AXIS));

        name=new JLabel("Nom Prénom");
        number=new JLabel("079 623 58 96");
        middleInfos.add(name);
        middleInfos.add(number);
        rightInfos.add(new MainAppButton(Constants.CONT_DEL_ICON,20,20));
        rightInfos.add(new MainAppButton(Constants.CONT_EDIT_ICON,20,20));




        JScrollPane jp = new JScrollPane(contactsPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cards.add(jp,"contactsPanel");
        cards.add(contactPanel,"contactPanel");
        add(cards,BorderLayout.CENTER);
        contactsPanel.add(oneContactPanel);
        oneContactPanel.add(new MainAppButton(Constants.CONT_ICON,50,50),BorderLayout.WEST);
        oneContactPanel.add(middleInfos,BorderLayout.CENTER);
        oneContactPanel.add(rightInfos,BorderLayout.EAST);
        oneContactPanel.setSize(new Dimension(480,64));
        // System.out.println(jp.getParent().getSize().height);


        // ListContact = new ListContact();

        /*for (int i=0; i<ListContact.getArrayList().size(); i++){
            System.out.println(i);
            Contact ctct = ListContact.getArrayList().get(i);
            MainAppButton btn = new MainAppButton();

        }*/


    }
}
