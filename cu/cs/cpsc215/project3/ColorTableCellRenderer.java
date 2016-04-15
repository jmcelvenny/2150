package cu.cs.cpsc215.project3;

import java . awt .*;
import javax . swing .*;
import javax . swing . table .*;

@SuppressWarnings("serial")
public class ColorTableCellRenderer extends DefaultTableCellRenderer {
	private ContactTableModel m_model ;
	
	public ColorTableCellRenderer ( ContactTableModel tm ) {
		m_model = tm ;
	}
	
	public Component getTableCellRendererComponent ( JTable table ,
			Object value , boolean isSelected , boolean hasFocus ,
			int row , int column ) {
		Component component = super . getTableCellRendererComponent (
				table , value , isSelected , hasFocus , row , column );
		component . setBackground ((Color) m_model.getValueAt(row, 3));
		component . setForeground ((Color) m_model.getValueAt(row, 3));
		return ( component );
	}
}