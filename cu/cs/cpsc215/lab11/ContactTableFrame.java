package cu.cs.cpsc215.lab11;

import javax.swing.*;

@SuppressWarnings("serial")
public class ContactTableFrame extends JFrame {
	
	public ContactTableFrame(String t, ContactTableModel tm) {
		super(t);
		this.setSize(400, 200);
		JTable jt = new JTable();
		jt.setModel(tm);
		jt.getColumnModel().getColumn(3).setCellRenderer(new ColorTableCellRenderer(tm));
		this.getContentPane().add(jt);
	}

}
