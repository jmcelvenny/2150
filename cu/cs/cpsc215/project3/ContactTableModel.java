package cu.cs.cpsc215.project3;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ContactTableModel extends AbstractTableModel {
	
	private ArrayList<Person> contacts;
	
	public ContactTableModel(ArrayList<Person> p) {
		if (p == null) {
			contacts = new ArrayList<Person>();
		} else {
			contacts = new ArrayList<Person>(p);
		}
	}
	
	public void addRow() {
		contacts.add(new Person("","","",""));
	}

	public void removeRow(int r) {
		contacts.remove(r -1);
	}
	
	public ArrayList<Person> copyList() {
		return new ArrayList<Person>(contacts); //a copy
	}
	
	public void setList(ArrayList<Person> l) {
		contacts = new ArrayList<Person>(l); //copy
	}
	
	@Override
	public void setValueAt(Object o, int r, int c) {
		switch(c) {
			case 0:
				contacts.get(r-1).setFname((String)o);
				break;
			case 1:
				contacts.get(r-1).setLname((String)o);
				break;
			case 2:
				contacts.get(r-1).setEmail((String)o);
				break;
			case 3:
				contacts.get(r-1).setColor((String)o);
				break;
			default:
				break;
		}
	}
 	
	@Override 
	public boolean isCellEditable(int r, int c) {
		if (r==0) return false;
		return true;
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
				return "Color";
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
			return contacts.get(rowIndex-1).getColor();
		default:
			return "Default";
		}
	}

}
