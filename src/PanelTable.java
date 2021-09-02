import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class PanelTable extends JPanel implements MouseListener{
	static JTable tblMovie;
	static DefaultTableModel TableM;
	static TableRowSorter tblSort;
	
	private Database Mstore=new Database("Movie.txt");
	private Database MColumn=new Database("MColumns.txt");
	private Vector value;
	
	public PanelTable() {
		tblSort=new TableRowSorter();
		TableM=new DefaultTableModel();
		tblMovie=new JTable(TableM);
		TableM.setColumnIdentifiers(MColumn.setColumns());
		Mstore.displayRecords(TableM);
		tblMovie.addMouseListener(this);
	}

	public void walaNaFinishNa(){
		String records="";	
		for (int row = 0; row < tblMovie.getRowCount(); row++) {
			for (int column = 0; column < tblMovie.getColumnCount(); column++) {
				records+=tblMovie.getValueAt(row, column)+"#";
			}
			records+="\n";
		}
		//JOptionPane.showMessageDialog(null, records);
		Mstore.addRecords(records);
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(tblMovie)){
			int row=tblMovie.getSelectedRow();
			value=new Vector();
			
			value.add(tblMovie.getValueAt(row,0)+"");
			value.add(tblMovie.getValueAt(row,1)+"");
			value.add(tblMovie.getValueAt(row,2)+"");
			value.add(tblMovie.getValueAt(row,3)+"");
			value.add(tblMovie.getValueAt(row,4)+"");
			value.add(tblMovie.getValueAt(row,5)+"");
			
			
			PanelInfo.setValues(value);
		
			PanelButtons.setDefaultButtons();
		}
	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
}
