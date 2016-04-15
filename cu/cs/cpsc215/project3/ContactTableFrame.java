package cu.cs.cpsc215.project3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class ContactTableFrame extends JFrame implements ActionListener, WindowListener {
	
	private ArrayList<Person> stored;
	private ContactTableModel tm;
	
	public ContactTableFrame(String t) {
		super(t);
		tm = new ContactTableModel(stored);
		this.setSize(450, 400);
		JTable jt = new JTable();
		JPanel jp = new JPanel();
		jt.setModel(tm);
		
		JButton add = new JButton();
		JButton delete = new JButton();
		
		add.setText("Add");
		delete.setText("Delete");
		
		add.addActionListener(this);
		delete.addActionListener(this);
		
		jp.add(add, BorderLayout.PAGE_START);
		jp.add(delete,  BorderLayout.PAGE_END);
		jp.add(jt,  BorderLayout.CENTER);
		
		this.getContentPane().add(jp);
		
		this.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//extremely inconvenient way to access table and model
		JTable jt = ((JTable)((JPanel)this.getContentPane().getComponents()[0]).getComponents()[2]);
		ContactTableModel ref = (ContactTableModel) jt.getModel();
		if (e.getActionCommand().equals("Add")) {
			ref.addRow();
			ref.fireTableDataChanged();
		} else if (e.getActionCommand().equals("Delete")) {
				int r = jt.getSelectedRow();
			if (r == 0) {
				JOptionPane.showMessageDialog(this, "wat the fock r u doin m8");
			} else {
				ref.removeRow(r);
				ref.fireTableDataChanged();
			}
		} else {
			JOptionPane.showMessageDialog(this, "no idea wat ur doin m8");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void windowOpened(WindowEvent e) {
		File f = new File("contacts.db");
		if (f.exists()) {
			try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				stored = (ArrayList<Person>) ois.readObject();
				ois.close();
			} catch (Exception ex) {
				System.out.println("Encountered an exception while reading contacts");
				ex.printStackTrace();
			}
		} else {
			stored = new ArrayList<Person>();
		}
		
		tm.setList(stored);
		tm.fireTableDataChanged();
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		JTable jt = ((JTable)((JPanel)this.getContentPane().getComponents()[0]).getComponents()[2]);
		ContactTableModel ref = (ContactTableModel) jt.getModel();
		stored = ref.copyList();
		
		File f = new File("contacts.db");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(stored);
			oos.close();
		} catch (Exception ex) {
			System.out.println("Encountered an exception while writing contacts");
			ex.printStackTrace();
		}
		System.exit(0);
	}


	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}
	
	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
