package six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactList implements ActionListener {
    private static final InputDialog inputDialog = new InputDialog();
    private static final JFrame contactListMainWindow = new JFrame();
    private final String[] columnNames = {"Name","Phone","Email"};
    private static final JTable table = new JTable(new ContactTableModel(inputDialog.getContactArrayList()));
    private static final JScrollPane scrollPane = new JScrollPane(table);
    ContactList(){
        contactListMainWindow.setLayout(new BorderLayout());
        contactListMainWindow.setResizable(true);
        contactListMainWindow.setSize(800,600);
        contactListMainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton addContactButton = new JButton("OPEN EDITOR");
        contactListMainWindow.add(addContactButton, BorderLayout.NORTH);
        addContactButton.addActionListener(this);

        contactListMainWindow.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputDialog.showInputDialog(true);
        scrollPane.revalidate();
        scrollPane.repaint();
    }


    public static void refreshTable(){
        contactListMainWindow.remove(scrollPane);
        contactListMainWindow.add(scrollPane, BorderLayout.CENTER);
    }

    public void showContactList(){
        contactListMainWindow.setVisible(true);
    }
}
