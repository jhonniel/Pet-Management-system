import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelInfo extends JPanel implements KeyListener,MouseListener{
	private JLabel lblID,lblMovieT,lblSeat,lblMovieTyp,lblMovietitle,lblPrice;
	static JTextField txtID,txtMovieT,txtSeat,txtPrice;
	
	private static JComboBox cboType,cboTitle,cboTime;
	private static JButton btnCal;
	
Movie p=new Movie();


	private Database Type=new Database("Type.txt");
	private Database Title=new Database("Title.txt");
	
	private static Vector rows;
	
	
		
	
	public PanelInfo() {
		
		lblID =new JLabel("Ticket no. : ");
		lblMovietitle =new JLabel("Movie Title: ");
		lblMovieT =new JLabel("Movie Time : ");
		lblMovieTyp =new JLabel("Movie type : ");
		lblSeat=new JLabel("Number of Seat : ");
		lblPrice=new JLabel("Total Price : ");
		
		
		
		txtID=new JTextField();
		txtID.setEditable(false);
		
		txtSeat=new JTextField("");
		txtPrice=new JTextField("0.00");
		txtPrice.setEditable(false);
		btnCal=new JButton("Calculate");
		
		
		
		String time[]={"10:00-11:30 Am","11:30-1:00Pm","1:00-2:30Pm","2:30-4:00Pm","4:00-6:30Ev","6:30-8:00Ev","8:00-10:30Ev"};
		cboTime=new JComboBox(time);
		
		cboType=new JComboBox();
		Type.loadToComboBox(cboType);
		cboTitle=new JComboBox();
		Title.loadToComboBox(cboTitle);
		setBackground(new Color(34,120,223));
		
		 
		
		 setLayout(new GridLayout(3,2));
		 setBorder(BorderFactory.createTitledBorder(null,"Movie Ticket",
				TitledBorder.CENTER,2));
		 add(lblID); add(txtID);
		 add(lblMovieTyp); add(cboType);
		 add(lblMovietitle); add(cboTitle);
		 add(lblSeat); add(txtSeat);
		 add(lblMovieT); add(cboTime);
		 add(lblPrice); add(txtPrice);
		 add(new JLabel(""));add(new JLabel(""));
		 add(new JLabel(""));add(new JLabel(""));
		 add(new JLabel("")); add(btnCal);
	
		 
		 
		 
	    txtPrice.addKeyListener(this);
	    txtSeat.addKeyListener(this);
		txtID.setText((PanelTable.tblMovie.getRowCount()+1)+"");
		txtSeat.addMouseListener(this);
		txtPrice.addMouseListener(this);
		
	}
	
	
	
	
	public static void clear(){
		txtID.setText((PanelTable.tblMovie.getRowCount()+1)+"");
		cboTitle.setSelectedIndex(0);
		cboTime.setSelectedIndex(0);
		cboType.setSelectedIndex(0);
		txtSeat.setText("");
		txtPrice.setText("0.00");
		
		

		
	}
	
	public static Vector getValues(){
		rows=new Vector();
		rows.add(txtID.getText());
		rows.add(cboTitle.getSelectedItem());
		rows.add(cboTime.getSelectedItem());
		rows.add(cboType.getSelectedItem());
		rows.add(txtSeat.getText());
		rows.add(txtPrice.getText());
		
		return rows;
	}
	public static void setValues(Vector value){
		txtID.setText(value.get(0).toString());
		cboTitle.setSelectedItem(value.get(1).toString());
		cboTime.setSelectedItem(value.get(2).toString());
		cboType.setSelectedItem(value.get(3).toString());
		txtSeat.setText(value.get(4).toString());
		txtPrice.setText(value.get(5).toString());
		
	}

	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		
			
		
	}
	

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { 
		 if(e.getSource().equals(txtSeat)){
			if(txtSeat.getText().equals("")){
				txtSeat.setText("");
			}
		}else if(e.getSource().equals(txtPrice)){
			if(txtPrice.getText().equals("")){
				txtPrice.setText("0.00");
			}
		}
	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	
	btnCal.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//String a = null;
			double seat = Double.parseDouble(txtSeat.getText());
			String regular = String.valueOf(seat*150);
			String VIP = String.valueOf(seat*200);
			String Gold = String.valueOf(seat*250);
			String movie = String.valueOf("PG");
			
			
			String rgl = String.valueOf(8);
			String dis = String.valueOf(7);
	     
	        if(cboType.getSelectedItem().equals("Regular"))
	        	
	        {
	        	txtPrice.setText(regular);
	        	
	        }
	        if(cboType.getSelectedItem().equals("VIP"))
	        {
	        	txtPrice.setText(VIP);
	        	
	        }
	        if(cboType.getSelectedItem().equals("3D"))
	        {
	        	txtPrice.setText(Gold);
	        	
	        }
	        
	      
	       
	        
	      
	        
	        
	        
		}});	  
   
	}

}
