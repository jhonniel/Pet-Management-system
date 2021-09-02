import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Movie extends JFrame implements WindowListener,MouseListener{
	Vector rows;
	JFrame f;
	PanelTable table=new PanelTable();
	JScrollPane pane;
	Database Mstore=new Database("Movie.txt");

	Movie(){ } //end of constructor
	
	public void setWindow(){

		
		
	
		pane=new JScrollPane();
		pane.setViewportView(PanelTable.tblMovie); //so table is viewed
		//PanelTable.tblPet.setFillsViewportHeight(true);
		setLayout(null);
		
		add(new PanelInfo()).setBounds(12,10, 760, 100);
		add(new PanelButtons()).setBounds(15, 400, 750, 30);
		add(new PanelSearch()).setBounds(5,115,200,30);
		
		add(new JScrollPane(PanelTable.tblMovie)).setBounds(12,150,760,240);
		
		
		getContentPane().setBackground(new Color(34,120,223));
		//btnAdd.setFont(new Font("Calibri", Font.PLAIN, 50));
		//getContentPane().setBackground(Color.);
		setTitle("Movie Ticketing");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		addWindowListener(this);
		addMouseListener(this);
		
	
	} //end of setWindow
	
	public void Shutdown(){
		String records="";	
		for (int row = 0; row < PanelTable.tblMovie.getRowCount(); row++) {
			for (int column = 0; column < PanelTable.tblMovie.getColumnCount(); column++) {
				records+=PanelTable.tblMovie.getValueAt(row, column)+"#";
			}
			records+="\n";
		}
		//JOptionPane.showMessageDialog(null, records);
		Mstore.addRecords(records);
	}
	
	
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {
		Shutdown();
	}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

	public void mouseClicked(MouseEvent e) {
		PanelButtons.setSaveButtons();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	
}//end of class
