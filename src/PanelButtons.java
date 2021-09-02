import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelButtons extends JPanel implements ActionListener{
	static JButton btnSave,btnClear,btnUpdate,btnDelete,btnClose;
	Vector rows;

	Movie movie=new Movie();
	
	PanelButtons(){
		btnSave=new JButton("Save");
		btnClear=new JButton("Clear");
		btnUpdate=new JButton("Update");
		btnDelete=new JButton("Delete");
		btnClose=new JButton("Close");
		
	
		
		 setLayout(new GridLayout(1,6));
		 add(btnSave) ;add(new JLabel(""));
		  add(btnClear) ;add(new JLabel(""));
		 add(btnUpdate); add(new JLabel(""));
		 add(btnDelete); add(new JLabel(""));
		  add(btnClose);// add(btnSave);
		  
		  setBackground(new Color(34,120,223));
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClose.addActionListener(this);
	
		
		//btnUpdate.setEnabled(false);
		//btnDelete.setEnabled(false);
	} //end of constructor
	
	
	

	
	public static void setSaveButtons(){
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}
	public static void setDefaultButtons(){
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSave)){
			PanelTable.TableM.addRow(PanelInfo.getValues());
			
			//pet.walaNaFinishNa();
			PanelInfo.clear();
		}else if(e.getSource().equals(btnUpdate)){
			
			rows=new Vector(PanelInfo.getValues());
			int row=PanelTable.tblMovie.getSelectedRow();
			JOptionPane.showMessageDialog(null, "Update Successfully");
			PanelTable.tblMovie.setValueAt(rows.get(1), row, 1);
			PanelTable.tblMovie.setValueAt(rows.get(2), row, 2);
			PanelTable.tblMovie.setValueAt(rows.get(3), row, 3);
			PanelTable.tblMovie.setValueAt(rows.get(4), row, 4);
			PanelTable.tblMovie.setValueAt(rows.get(5), row, 5);
			
			PanelInfo.clear();
			
		    PanelButtons.setDefaultButtons();
			btnSave.setEnabled(true);
			
		}else if(e.getSource().equals(btnClear)){
			PanelInfo.clear();
		}else if(e.getSource().equals(btnDelete)){
			int row=PanelTable.tblMovie.getSelectedRow();
			btnSave.setEnabled(true);
			PanelTable.TableM.removeRow(row);
		
		}
		else if(e.getSource().equals(btnClose)){
			movie.Shutdown();
			System.exit(0);
		}
	}

}
