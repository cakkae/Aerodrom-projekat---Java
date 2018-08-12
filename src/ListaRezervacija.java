import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




public class ListaRezervacija extends JFrame  {
	Container c = getContentPane();
String [] col1 = {"Ime i Prezime","Telefon","Datum R.","Šifra L.","Datum L.","Rezerviše"};
	 
		JTable jtable;
		String dataStr = null;
    

        
	 
	 public ListaRezervacija(){
		 super("Lista Rezervacija");
		JPanel jp = new JPanel();
		c.add(jp);
		setSize(400,200);
		
		 
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("dodajrezervaciju2.txt");
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
	
		String dataStr = line;
		

		

		Vector<Vector<String>> myVector = new Vector<Vector<String>>();
		try {
		    FileReader fReader = new FileReader("dodajrezervaciju2.txt");
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
        header.add("Ime i Prezime");
        header.add("Telefon");
        header.add("Datum R.");
        header.add("Sifra L.");
        header.add("Datum L.");
        header.add("Rezervise");
        final TableModel model = new DefaultTableModel(myVector, header);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
		table.setFillsViewportHeight(true);
		 

		JScrollPane jsa = new JScrollPane(table);
c.add(jsa);


table.addMouseListener(new MouseListener() {
	
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
               
                int selectedrow = table.getSelectedRow();
				
				int colona2 = 4;
				
				final Object selectedObject2 = (Object)table.getModel().getValueAt(selectedrow, colona2);
				
				
				final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				final Date date = new Date();
				dateFormat.format(date);
			
				final Date date4 = new Date(date.getTime()+(10000*60*60*24));
				
				System.out.print("Date4");
				System.out.println(dateFormat.format(date4 ));
				final String s = (String) selectedObject2;
				
				
				
					
				
			
				
				
			
					
				
                menuItem.addActionListener(new ActionListener() {
                	
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Date date2 = new Date();
						try {
							date2= dateFormat.parse(s);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(dateFormat.format(date2));
						
						if (date2.after(date4)){
							
							
						if (table.getSelectedRow() != -1) {
				            // remove selected row from the model
							
							
							
				            ((DefaultTableModel) model).removeRow(table.getSelectedRow());
							
						
						
					
						
						}
						}else{
							System.out.println("NE MOZETE OTKAZATI REZERVACIJU");
							}
						}
						}
					

);
	        	
                Pmenu.add(menuItem);
                Pmenu.show();
                Component sources = (Component)arg0.getSource(); 
                Dimension sizes = source.getSize(); 


                int xPos = ((size.width - Pmenu.getPreferredSize().width /2) ); 
                int yPos = (size.height /5);
                Pmenu.show(source, xPos, yPos);
	        
	        	
	        }
	        }
	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
});
		
	
				
		   
		    
    }

	        
	 
		 protected static void removeLineFromFile(String string, int selectedRow) {
		// TODO Auto-generated method stub
		
	}
		 



		public static void main(String[] args) {
				// TODO Auto-generated method stub
			
		ListaRezervacija l = new ListaRezervacija();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.show();
		

        
       

     //end main()

		

}
		}
