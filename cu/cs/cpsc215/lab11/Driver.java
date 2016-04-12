package cu.cs.cpsc215.lab11;

import java.awt.Color;
import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(new Person("Billy", "Bob", "bob@gmail.com", Color.BLACK));
		plist.add(new Person("Gordon", "Zhang", "gordon@gordon.com", Color.RED));
		plist.add(new Person("Geoff", "Rubilliough", "jeff@rubillo.com", Color.GREEN));
		plist.add(new Person("Wayne", "Trane", "Goddard", Color.BLUE));

		ContactTableModel f = new ContactTableModel(plist);
		ContactTableFrame t = new ContactTableFrame("table", f);
		t.setVisible(true);	
	}
}
