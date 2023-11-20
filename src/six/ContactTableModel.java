package six;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ContactTableModel extends AbstractTableModel {
    private ArrayList<Contact> peopleList;
    private String[] columnNames = {"Name", "Last Name", "Email"};

    public ContactTableModel(ArrayList<Contact> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public int getRowCount() {
        return peopleList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contact person = peopleList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return person.getName();
            case 1:
                return person.getPhone();
            case 2:
                return person.getEmail();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
