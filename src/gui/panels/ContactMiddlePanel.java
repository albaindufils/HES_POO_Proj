package src.gui.panels;

import src.gui.MainAppButton;
import src.helper.WrapLayout;
import src.models.Contact;
import src.models.ListContact;

import javax.swing.*;
import java.awt.*;


public class ContactMiddlePanel extends MyPanel {

    private JPanel cards;
    private JPanel ContactsPanel;
    private ListContact ListContact;
    private MyContactPanel ContactPanel;


    public ContactMiddlePanel() {
        super(new BorderLayout());

    }
    @Override
    protected void init() {

        cards = new JPanel(new CardLayout());
        ContactsPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
        ContactPanel = new MyContactPanel();


        JScrollPane jp = new JScrollPane(ContactsPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cards.add(jp,"ContactsPanel");
        cards.add(ContactsPanel,"ContactsPanel");
        add(cards,BorderLayout.CENTER);

        ListContact = new ListContact();

        for (int i=0; i<ListContact.getArrayList().size(); i++){
            System.out.println(i);
            Contact ctct = ListContact.getArrayList().get(i);
            MainAppButton btn = new MainAppButton();

        }

    }
}
