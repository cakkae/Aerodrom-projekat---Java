import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Dodajklijenta extends JFrame{
JTextArea ime,tel,datr,sifraa,datuml,mjesta,sa;
JTextField i,t,s,d,dl,m;
JButton btn1 ;
JLabel dater, datel;
JComboBox sifra1;



public Dodajklijenta(){
	super("Dodaj klijenta");
	Container c = getContentPane();
	setSize(400,600);
	JPanel jp = new JPanel();
	jp.setLayout(new BorderLayout(500,500));
	c.add(jp);
	
	
	ime = new JTextArea("Ime i Prezime :");
	tel = new JTextArea("Telefon :");
	/*datr = new JTextArea("Datum Rezervacije:");
	sifraa = new JTextArea("Sifra Leta:");*/
	datuml = new JTextArea("Datum uplate:");
	mjesta = new JTextArea("Cijena:");
	ime.setFont(new Font("Times New Roman", Font.BOLD,13));
	tel.setFont(new Font("Times New Roman", Font.BOLD,13));
	datr.setFont(new Font("Times New Roman", Font.BOLD,13));
	sifraa.setFont(new Font("Times New Roman", Font.BOLD,13));
	datuml.setFont(new Font("Times New Roman", Font.BOLD,13));
	mjesta.setFont(new Font("Times New Roman", Font.BOLD,13));
	datel = new JLabel("(DD.MM.YYYY)");
	datel.setForeground(Color.red);
	dater = new JLabel("(DD.MM.YYYY)");
	dater.setForeground(Color.red);
	ime.setEditable(false);
	tel.setEditable(false);
	datr.setEditable(false);
	sifraa.setEditable(false);
	datuml.setEditable(false);
	mjesta.setEditable(false);
	i = new JTextField();
	t = new JTextField();
	d = new JTextField();
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Date date = new Date();
	JLabel jl = new JLabel(dateFormat.format(date));
	JLabel jl2 = new JLabel("Današnji Datum je :");
	
	
	//s = new JTextField();
	dl = new JTextField();
	m = new JTextField();
	ime.setBounds(50,170,100,20);
	tel.setBounds(50,200,100,20);
	datr.setBounds(50,230,130,20);
	sifraa.setBounds(50,260,100,20);
	datuml.setBounds(50,290,100,20);
	mjesta.setBounds(50,320,100,20);
	i.setBounds(180,170,120,20);
	t.setBounds(180,200,120,20);
	jl.setBounds(160,120,100,20);
	jl2.setBounds(50,120,120,20);
	dater.setBounds(300,230,120,20);

	 
	 d.setBounds(180,230,120,20);
	dl.setBounds(180,290,120,20);
	datel.setBounds(300,290,120,20);
	m.setBounds(180,320,120,20);
	btn1 = new JButton("           DODAJ         ");
	btn1.setFont(new Font("Times New Roman", Font.BOLD, 15));
	JPanel j = new JPanel();
	
	
	j.setBounds(60,350,200,40);
	btn1.setBounds(60,350,200,40);
	
	
	
	Vector<Vector<String>> myVector = new Vector<Vector<String>>();
	FileReader fReader = null;
	try {
		fReader = new FileReader("dodajsifru.txt");
	
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    BufferedReader inFile = new BufferedReader(fReader);
    
    String input;
   
    
	try {
		while ((input = inFile.readLine()) != null) {
		    String[] temp = input.split(" ");
		    
		    Vector<String> v = new Vector<String>(3);
		    
		    for (int i=0; i < temp.length; i++) {
		        v.add(temp[i]);
		       
		    }
		    myVector.add(v);
		  
	        
		    
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
    
    
	
	
        System.out.println(myVector);
        sifra1 = new JComboBox(myVector);
        
    	sifra1.setBounds(180,260,120,20);
    
    	sifra1.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					
				}
			}
		});
	j.add(btn1);
	jp.add(j);
	
	jp.add(ime);
	jp.add(tel);
	jp.add(datr);
	jp.add(sifraa);
	jp.add(datuml);
	jp.add(mjesta);
	jp.add(i);
	jp.add(t);
	jp.add(sifra1);
	jp.add(d);
	jp.add(dl);
	jp.add(m);
	jp.add(datel);
	jp.add(dater);
	jp.add(jl);
	jp.add(jl2);
	
	jp.add(sa = new JTextArea());
	sa.setEditable(false);
	JPanel panel2 = new JPanel();
	panel2.setBounds(60,400,200,40);
	
	btn1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				File log = new File("dodajrezervaciju2.txt");
				PrintWriter outfile = new PrintWriter(new FileWriter(log, true));
				outfile.write("");
				outfile.write(i.getText());
				outfile.write(",");
				outfile.write(t.getText());
				outfile.write(",");
				outfile.write(d.getText());
				outfile.write(",");
				//outfile.write(s.getText());
				String x = String.valueOf(sifra1
						.getSelectedItem());
				outfile.write(x);
				outfile.write(",");
				outfile.write(dl.getText());
				outfile.write(",");
				outfile.write(m.getText());
				outfile.write("");
				outfile.write("\r\n");
				outfile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
}
public void brojMjesta (String S ){
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dodajklijenta r = new Dodajklijenta();
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.show();
	}

}
