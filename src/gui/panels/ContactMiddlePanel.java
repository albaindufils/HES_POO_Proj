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


/**
 * La classe "ContactMiddlePanel" liste les panels principaux dans cette classe.
 * Cette classe est instancier de la classe parent MyPanel,
 * qui est une classe abstract et doit être redefini pour chaque sous classe.
 */

public class ContactMiddlePanel extends MyPanel {

    private JPanel contactsPanel;
    private JPanel cards;
    private MyContactPanel contactPanel;
    private JTextField search_bar;
    private ListContact ctct_list;
    private CardLayout card_manager;
    private MainAppButton btnRetour;


    /**
     * ce constructeur va afficher le borderLayout de panel contact
     * grace au constructor "init"
     */

    public ContactMiddlePanel() {
        super(new BorderLayout());
        init();
    }

    /**
     * Vue que le MyPanel est un abstract on va devoir faire un override
     * et redefinir le "init" pour l'adapter à la au layout
     * du nouvelle affichage pour les contacts.
     */

    @Override
    protected void init() {
        cards = new JPanel(new CardLayout());
        card_manager = (CardLayout) cards.getLayout();
        contactsPanel = new JPanel(/*new WrapLayout(WrapLayout.LEFT)*/);
        BoxLayout bl = new BoxLayout(contactsPanel,BoxLayout.PAGE_AXIS);
        contactPanel = new MyContactPanel();
        search_bar = new JTextField();
        contactsPanel.setLayout(bl);
        btnRetour = new MainAppButton(Constants.BACK_IMAGE,Constants.BACK_SIZE,Constants.BACK_SIZE);


        JScrollPane jp = new JScrollPane(contactsPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cards.add(jp,"contactsPanel");
        cards.add(contactPanel,"contactPanel");
        add(cards,BorderLayout.CENTER);
        add(search_bar,BorderLayout.NORTH);
        btnRetour.addActionListener(new ActionListener() {
            /**
             * une barre de recherche a été ajoutée avec la classe "actionPerformed"
             * qui va appeler une méthode pour mettre à jour la liste selon la recherche effectuée.
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                search_bar.setVisible(true);
                updateDisplay();
                card_manager.show(cards,"contactsPanel");
            }
        });
        contactPanel.getTopPanel().add(btnRetour, BorderLayout.WEST);
        search_bar.addKeyListener(new FilterContact());
        ctct_list = new ListContact();
        Collections.sort(ctct_list.getArrayList());
        ctct_list.getArrayList();
        contactsPanel.removeAll();
        updateDisplay();


    }

    /**
     * La méthode "updateDisplay" permet d'afficher les contact.
     */

    private void  updateDisplay() {
        contactsPanel.removeAll();
        for (int i=0; i< ctct_list.getArrayList().size(); i++) {
            addContactToPanel(ctct_list.getArrayList().get(i));
        }
    }

    /**
     * Cette méthode permet d'ajouter les contact dans le panel selon la structuration
     * mise en place ci-dessous.
     * @param ctct
     */
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
        btn_del.addActionListener(new DeleteContact(ctct));
        btn_edit.addActionListener(new EditContact(ctct));
        rightInfos.add(btn_del);
        rightInfos.add(btn_edit);
        oneContactPanel.add(new MainAppButton(Constants.CONT_ICON,Constants.CONTACT_MAX_HEIGHT-5,Constants.CONTACT_MAX_HEIGHT-5),BorderLayout.WEST);
        oneContactPanel.add(middleInfos,BorderLayout.CENTER);
        oneContactPanel.add(rightInfos,BorderLayout.EAST);
        oneContactPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Constants.CONTACT_MAX_HEIGHT+5));
        contactsPanel.add(new JLabel(" "));
        contactsPanel.add(oneContactPanel);
        ctct.setOneContactPanel(oneContactPanel);

    }

    /**
     * la classe "DeleteContact" permets de supprimer un contact de la liste des contactes.
     * cette classe a la méthode défini par la classe mère "ActionListener".
     */

    class DeleteContact implements ActionListener {
        private Contact ctc;
        public DeleteContact(Contact ctc) {
            this.ctc=ctc;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            contactsPanel.removeAll();
            ctct_list.removeContact(ctc);
            updateDisplay();
        }
    }

    /**
     * La classe "EditContact" permet de modifier les attributs d'un contact
     * selon ce qu'on souhaite modifier.
     */

    class EditContact implements ActionListener {
        private Contact ctc;
        public EditContact(Contact ctc) {
            this.ctc=ctc;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            search_bar.setVisible(false);
            card_manager.show(cards,"contactPanel");
            contactPanel.setCurrContact(ctc);
        }
    }

    /**
     ** une barre de recherche a été ajoutée avec la classe "actionPerformed"
     *  qui va appeler une méthode pour mettre à jour la liste selon la recherche effectuée.
     *  cette recherche va réajuster la liste selon la recherche
     */


    class FilterContact implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
            ArrayList<Contact> arr = new ArrayList<>();
            String txt = ((JTextField)e.getSource()).getText().toUpperCase();
            contactsPanel.removeAll();

            for(Contact c: ctct_list.getArrayList()) {
                if ((c.getLastName() + " " +c.getFirstName()).toUpperCase().contains(txt)) {
                    contactsPanel.add(c.getOneContactPanel());
                    contactsPanel.add(new JLabel(" "));
                }
            }
        }
    }
}
