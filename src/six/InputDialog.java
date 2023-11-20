package six;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InputDialog extends JFrame{
    public ArrayList<Contact> getContactArrayList() {
        return contactArrayList;
    }

    private final ArrayList<Contact> contactArrayList = new ArrayList<>();

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

        JButton deleteContactButton = new JButton("DELETE");
        add(deleteContactButton);
        submitContactButton.addActionListener(e -> {
                contactArrayList.add(new Contact(nameField.getText(),phoneField.getText(),eMailField.getText()));
                nameField.setText("");
                phoneField.setText("");
                eMailField.setText("");
                ContactList.refreshTable();
        });

        deleteContactButton.addActionListener(e -> {
            for(int i=0;i<contactArrayList.size();i++){
                if(contactArrayList.get(i).name().equals(nameField.getText())){
                    contactArrayList.remove(i);
                    break;
                }
            }
            ContactList.refreshTable();
            nameField.setText("");
            phoneField.setText("");
            eMailField.setText("");
        });
    }

    public void showInputDialog(boolean condition){
        setVisible(condition);
    }

}
