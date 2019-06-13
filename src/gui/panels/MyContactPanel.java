package src.gui.panels;

import src.models.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La classe "MyContactPanel" définit les différents attributs utilisé.
 *
 */

public class MyContactPanel extends MyPanel {

    private JPanel topPanel;
    private JPanel middlePanel;
    private JTextField txt_firstName;
    private JTextField txt_lastName;
    private JTextField txt_companyName;
    private JTextField txt_phoneNumber;
    private JTextField txt_address;
    private JTextField txt_dateOfBirth;
    private JTextField txt_emailAddress;
    private JTextField txt_city;
    private Contact currContact;

    /**
     * Cette méthode va généré un nouveau layout pour cette panel.
     * Elle va aussi lancer la méthode d'affichage.
     */

    public MyContactPanel() {
        super(new BorderLayout());


        init();
    }

    /**
     * dans cette méthode les attributs ont été instancié dans la méthode init.
     * elle va aussi aidé a redefinir l'affichage des contacts selon la structure prédefini ci-dessous.
     * @return
     */
    public JPanel getTopPanel() {
        return topPanel;
    }
    @Override
    public void init() {
        middlePanel = new JPanel();
        Dimension myDim = new Dimension(Integer.MAX_VALUE,30);
        topPanel=new JPanel(new BorderLayout());
        txt_firstName=new MyContactTextField(myDim);
        txt_lastName=new MyContactTextField(myDim);
        txt_companyName=new MyContactTextField(myDim);
        txt_phoneNumber=new MyContactTextField(myDim);
        txt_address=new MyContactTextField(myDim);
        txt_dateOfBirth=new MyContactTextField(myDim);
        txt_emailAddress=new MyContactTextField(myDim);
        txt_city=new MyContactTextField(myDim);


        BoxLayout bl = new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS);
        middlePanel.setLayout(bl);


        add(middlePanel,BorderLayout.CENTER);
        add(topPanel,BorderLayout.NORTH);

        middlePanel.add(new JLabel("Firstname:"));
        middlePanel.add(txt_firstName);
        middlePanel.add(new JLabel("Lastname:"));
        middlePanel.add(txt_lastName);
        middlePanel.add(new JLabel("Company:"));
        middlePanel.add(txt_companyName);
        middlePanel.add(new JLabel("Phone number:"));
        middlePanel.add(txt_phoneNumber);
        middlePanel.add(new JLabel("Address:"));
        middlePanel.add(txt_address);
        middlePanel.add(new JLabel("City:"));
        middlePanel.add(txt_city);
        middlePanel.add(new JLabel("Date of birth:"));
        middlePanel.add(txt_dateOfBirth);
        middlePanel.add(new JLabel("Email:"));
        middlePanel.add(txt_emailAddress);
        txt_firstName.addKeyListener(new KeyWritted("firstname"));
        txt_lastName.addKeyListener(new KeyWritted("lastname"));
        txt_companyName.addKeyListener(new KeyWritted("companyname"));
        txt_phoneNumber.addKeyListener(new KeyWritted("phonenumber"));
        txt_address.addKeyListener(new KeyWritted("address"));
        txt_dateOfBirth.addKeyListener(new KeyWritted("dateofbirth"));
        txt_emailAddress.addKeyListener(new KeyWritted("email"));
        txt_city.addKeyListener(new KeyWritted("city"));

    }

    /**
     * Cette méthode va aider à redefinir les attributs au moment de la modification.
     * @param ctc
     */
    public void setCurrContact(Contact ctc) {
        currContact = ctc;
        txt_firstName.setText(ctc.getFirstName());
        txt_lastName.setText(ctc.getLastName());
        txt_companyName.setText(ctc.getCompanyName());
        txt_phoneNumber.setText(ctc.getPhoneNumber());
        txt_address.setText(ctc.getAddress());
        txt_dateOfBirth.setText(ctc.getDateOfBirth());
        txt_emailAddress.setText(ctc.getEmailAddress());
        txt_city.setText(ctc.getcity());

    }


    class KeyWritted implements KeyListener {
        private String prop;
        public KeyWritted(String prop) {
            this.prop=prop;
        }
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
            String val=((JTextField)e.getSource()).getText();
            switch (prop){
                case "city":
                    currContact.setCity(val);
                    break;
                case "lastname":
                    currContact.setLastName(val);
                    break;
                case "firstname":
                    currContact.setFirstName(val);
                    break;
                case "address":
                    currContact.setAddress(val);
                    break;
                case "companyname":
                    currContact.setCompanyName(val);
                    break;
                case "dateofbirth":
                    currContact.setDateOfBirth(val);
                    break;
                case "phonenumber":
                    currContact.setPhoneNumber(val);
                    break;
                case "email":
                    currContact.setEmailAddress(val);
                    break;
                default:
                    break;

            }

        }
    }
}
