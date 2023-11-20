package six;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ContactTableModel extends AbstractTableModel {
    private final ArrayList<Contact> peopleList;
    private final String[] columnNames = {"Name", "Last Name", "Email"};

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

        return switch (columnIndex) {
            case 0 -> person.name();
            case 1 -> person.phone();
            case 2 -> person.email();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
