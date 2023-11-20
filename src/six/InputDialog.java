package six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputDialog extends JFrame{
    ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    InputDialog(){
        setTitle("Enter contact!");
        setSize(300,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        add(nameLabel);
        add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();
        add(phoneLabel);
        add(phoneField);

        JLabel eMailLabel = new JLabel("eMail:");
        JTextField eMailField = new JTextField();
        add(eMailLabel);
        add(eMailField);

        JButton submitContactButton = new JButton("SUBMIT");
        add(submitContactButton);
        submitContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    contactArrayList.add(new Contact(nameField.getText(),phoneField.getText(),eMailField.getText()));
                    nameField.setText("");
                    phoneField.setText("");
                    eMailField.setText("");
                    ContactList.refreshTable();
            }
        });
    }

    public void message(String message){
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    public void showInputDialog(boolean condition){
        setVisible(condition);
    }

}
