import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class LetLista extends JFrame{
	Container c = getContentPane();
	JTable jtable;

	
	
public LetLista(){
	super("Lista Letova");
	JPanel jp = new JPanel();
	c.add(jp);
	setSize(400,200);
	
	
	
	FileInputStream fis = null;
	try {
		fis = new FileInputStream("dodajlet2.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	//Construct BufferedReader from InputStreamReader
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
	try {
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
	try {
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	

	Vector<Vector<String>> myVector = new Vector<Vector<String>>();
	try {
	    FileReader fReader = new FileReader("dodajlet2.txt");
	    BufferedReader inFile = new BufferedReader(fReader);
	    String input;
	    while ((input = inFile.readLine()) != null) {
	        String[] temp = input.split(",");
	        Vector<String> v = new Vector<String>(3);
	        for (int i = 0; i < temp.length; i++) {
	            v.add(temp[i]);
	        }
	        myVector.add(v);
	    }
	} catch (IOException e) {
	    e.printStackTrace(System.err);
	}
    Vector<String> header = new Vector<String>(2);
    header.add("Šifra :");
    header.add("Odredište");
    header.add("Vreme Polaska");
    header.add("Tip Aviona");
    header.add("Broj Mjesta");
    
    final TableModel model = new DefaultTableModel(myVector, header);
    final JTable table = new JTable(model);
    table.setPreferredScrollableViewportSize(new Dimension(500,50));
	table.setFillsViewportHeight(true);

	JScrollPane jsa = new JScrollPane(table);
c.add(jsa);

//Nije Potrebno
table.addMouseListener( new MouseListener() {
	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 int row = table.rowAtPoint(arg0.getPoint());
	        int col = table.columnAtPoint(arg0.getPoint());
	        if (row >= 0 && col >= 0) {
	        	Component source = (Component)arg0.getSource();
	        	Point location = source.getLocation();
	        	Dimension size = source.getSize();

	        	final JPopupMenu Pmenu = new JPopupMenu();
             JMenuItem menuItem = new JMenuItem("Poništi rezervaciju");
             menuItem.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if (table.getSelectedRow() != -1) {
				            // remove selected row from the model
				            ((DefaultTableModel) model).removeRow(table.getSelectedRow());
				        
					}}
				});
             Pmenu.add(menuItem);
             Pmenu.show();
             Component sources = (Component)arg0.getSource(); 
             Dimension sizes = source.getSize(); 


             int xPos = ((size.width - Pmenu.getPreferredSize().width /2) ); 
             int yPos = (size.height /5);
             Pmenu.show(source, xPos, yPos);
	        }
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	
	}
	
});

	
}

	public void setRezervacija (String s ){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
LetLista l = new LetLista();
l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
l.show();

	}

}
