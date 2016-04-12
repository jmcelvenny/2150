package cu.cs.cpsc215.lab11;

import javax.swing.table.AbstractTableModel;

import java.awt.Color;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ContactTableModel extends AbstractTableModel {
	
	private ArrayList<Person> contacts;
	
	public ContactTableModel(ArrayList<Person> p) {
		contacts = new ArrayList<Person>(p);
	}

	@Override
	public int getRowCount() {
		return contacts.size()+1;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex==0) {
			switch(columnIndex) {
			case 0:
				return "First Name";
			case 1:
				return "Last Name";
			case 2:
				return "E-mail";
			case 3:
				return Color.WHITE;
			default:
				return "Default";
			}
		}
		switch(columnIndex) {
		case 0:
			return contacts.get(rowIndex-1).getFname();
		case 1:
			return contacts.get(rowIndex-1).getLname();
		case 2:
			return contacts.get(rowIndex-1).getEmail();
		case 3:
			return contacts.get(rowIndex-1).getFavorite();
		default:
			return "Default";
		}
	}

}
