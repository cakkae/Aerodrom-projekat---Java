import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class DodajLet extends JFrame{
JTextArea sifra,odrediste,vremep,tipa,brojmj;
JTextField s,vp,b1,b2;
JComboBox o,t;
JButton btn1;




public DodajLet(){
	super("Dodaj Let");
	String[] sItem2 ={ "New York", "Los Angeles ", "Miami", "Frankfurt", "Istambul", "Moskva", "Beograd", "Sarajevo", "Zagreb" };
	String []sItem3 = {"Airbus A350" ,"Airbus A380","Boeing 737","Boeing 787 ","Embraer 195 "};
	
	Container c = getContentPane();
	
	setSize(400,600);
	
	JPanel jp = new JPanel();
	JPanel jp3 = new JPanel();
	jp.setLayout(new BorderLayout(700,700));
	c.add(jp);
	jp.add(jp3);
	btn1 = new JButton("                 DODAJ                  ");
	sifra = new JTextArea("Sifra");
	odrediste = new JTextArea("Odredište");
	vremep = new JTextArea("Vreme Polaska");
	tipa = new JTextArea("Tip Aviona");
	brojmj = new JTextArea("Broj Mjesta");
	btn1.setFont(new Font("Times New Roman", Font.BOLD,15));
	odrediste.setFont(new Font("Times New Roman", Font.BOLD,13));
	sifra.setFont(new Font("Times New Roman", Font.BOLD,13));
	vremep.setFont(new Font("Times New Roman", Font.BOLD,13));
	tipa.setFont(new Font("Times New Roman", Font.BOLD,13));
	brojmj.setFont(new Font("Times New Roman", Font.BOLD,13));
	sifra.setEditable(false);
	vremep.setEditable(false);
	brojmj.setEditable(false);
	odrediste.setEditable(false);
	tipa.setEditable(false);
	s = new JTextField ();
	vp = new JTextField();
	t = new JComboBox(sItem3);
	b1= new JTextField();
	o = new JComboBox(sItem2);
	
	sifra.setBounds(50,170,50,20);
	odrediste.setBounds(50,200,60,20);
	vremep.setBounds(50,230,90,20);
	tipa.setBounds(50,260,60,20);
	brojmj.setBounds(50,290,70,20);
	s.setBounds(140,170,120,20);
	o.setBounds(140,200,120,20);
	vp.setBounds(140,230,120,20);
	t.setBounds(140,260,120,20);
	b1.setBounds(140, 290, 120, 20);
	
	
	

	btn1.setBounds(50,320,420,40);
	JPanel jp2 = new JPanel();
	jp2.setBounds(50,320,210,40);
	jp.add(jp2);
	jp2.add(btn1);
	
	
	jp.add(sifra);
	jp.add(odrediste);
	jp.add(vremep);
	jp.add(tipa);
	jp.add(brojmj);
	jp.add(s);
	jp.add(o);
	jp.add(vp);
    jp.add(t);
    jp.add(b1);
    jp.add(b2 = new JTextField());
    b2.setEditable(false);
	
		
	
    btn1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				File log = new File("dodajlet2.txt");
				PrintWriter outfile = new PrintWriter(new FileWriter(log, true));
				outfile.write("");
				outfile.write(s.getText());
				outfile.write(",");
				String x = String.valueOf(o.getSelectedItem());
				outfile.write(x);
				outfile.write(",");
				outfile.write(vp.getText());
				String x1 = String.valueOf(t.getSelectedItem());
				outfile.write(",");
				outfile.write(x1);
				outfile.write(",");
				outfile.write(b1.getText());
				outfile.write("");
				outfile.write("\r\n");
				outfile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File log2 = new File("dodajsifru.txt");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new FileWriter(log2, true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write("");
			out.write(s.getText());
			out.write("\r\n");
			out.close();
            
			
		}
	});
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DodajLet d = new DodajLet();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.show();
	}

}
