package src.gui.panels;

import src.gui.MainAppButton;
import src.helper.Constants;
import src.models.Contact;
import src.models.ListContact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;


public class ContactMiddlePanel extends MyPanel {

    private JPanel contactsPanel;
    private JPanel cards;
    private MyContactPanel contactPanel;
    private JTextField search_bar;
    private ListContact ctct_list;

    public ContactMiddlePanel() {
        super(new BorderLayout());
        init();
    }
    @Override
    protected void init() {
        cards = new JPanel(new CardLayout());
        contactsPanel = new JPanel(/*new WrapLayout(WrapLayout.LEFT)*/);
        BoxLayout bl = new BoxLayout(contactsPanel,BoxLayout.Y_AXIS);
        contactPanel = new MyContactPanel();
        search_bar = new JTextField();
        contactsPanel.setLayout(bl);



        JScrollPane jp = new JScrollPane(contactsPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cards.add(jp,"contactsPanel");
        cards.add(contactPanel,"contactPanel");
        add(cards,BorderLayout.CENTER);
        add(search_bar,BorderLayout.NORTH);

        search_bar.addKeyListener(new FilterContact());
        ctct_list = new ListContact();
        Collections.sort(ctct_list.getArrayList());
        ctct_list.getArrayList();
        for (int i=0; i< ctct_list.getArrayList().size(); i++) {
            addContactToPanel(ctct_list.getArrayList().get(i));
        }

    }
    private void addContactToPanel(Contact ctct) {



        JLabel name=new JLabel(ctct.getLastName() + " " + ctct.getFirstName());
        JLabel number=new JLabel(ctct.getPhoneNumber());
        JLabel mail=new JLabel(ctct.getEmailAddress());

        JPanel middleInfos = new JPanel();
        JPanel rightInfos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel oneContactPanel = new JPanel(new BorderLayout());

        rightInfos.setLayout(new BoxLayout(rightInfos,BoxLayout.Y_AXIS));
        middleInfos.setLayout(new BoxLayout(middleInfos,BoxLayout.Y_AXIS));
        middleInfos.add(name);
        middleInfos.add(number);
        middleInfos.add(mail);
        middleInfos.setSize(new Dimension(480,64));
        MainAppButton btn_del = new MainAppButton(Constants.CONT_DEL_ICON,20,20);
        MainAppButton btn_edit = new MainAppButton(Constants.CONT_EDIT_ICON,20,20);
        btn_del.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        btn_del.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        btn_del.addActionListener(new DeleteContact());
        btn_edit.addActionListener(new DeleteContact());
        rightInfos.add(btn_del);
        rightInfos.add(btn_edit);
        oneContactPanel.add(new MainAppButton(Constants.CONT_ICON,50,50),BorderLayout.WEST);
        oneContactPanel.add(middleInfos,BorderLayout.CENTER);
        oneContactPanel.add(rightInfos,BorderLayout.EAST);
        contactsPanel.add(new JLabel(" "));
        contactsPanel.add(oneContactPanel);
        ctct.setOneContactPanel(oneContactPanel);

    }
    class DeleteContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class EditContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class FilterContact implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
            ArrayList<Contact> arr = new ArrayList<>();
            String txt = ((JTextField)e.getSource()).getText().toUpperCase();
            System.out.println("======================================");
            // contactsPanel.removeAll();

            for(Contact c: ctct_list.getArrayList()) {
                if (!(c.getLastName() + " " +c.getFirstName()).toUpperCase().contains(txt)) {
                    // System.out.println(c);
                    c.getOneContactPanel().setVisible(false);
                    // addContactToPanel(c);
                } else {
                    c.getOneContactPanel().setVisible(true);
                }
            }
            contactsPanel.repaint();
            contactsPanel.revalidate();
            // System.out.println("======================================");
        }
    }
}
