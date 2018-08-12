import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Let extends JFrame {
	JButton btn1,btn2,btn3,btn4;
JPanel jp = new JPanel();
JFrame frame ;
JTextArea text;



	public Let(){
		super("Aerodrom");
	
	
		setSize(600,600);
		final Container c = this.getContentPane();

		c.setLayout(new GridLayout(2,3));
	
		
		JLabel label = new JLabel();
		label.setText("Prvo Dodajte Let, Pa tek onda rezervaciju");
		label.setBounds(50,120,120,20);
		final JPanel jp = new JPanel();
		
		jp.setSize(500,500);
		c.add(jp);
		
		
		
		btn1 = new JButton();
		
	
		
		btn1.setText("Lista Letova");
		btn2 = new JButton("Lista Rezervacija");
		
		jp.add( btn3 = new JButton("Dodaj Let"));
		
		jp.add ( btn4 = new JButton("Dodaj Rezervaciju"));
        jp.add(btn2);
	    jp.add(btn1);
	    jp.add(label);
	    btn4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DodajRezervaciju r = new DodajRezervaciju();
				r.show();
			}
		});
	
	btn3.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			DodajLet d = new DodajLet();
			
			d.show();
		}
	});
	btn2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ListaRezervacija l2 = new ListaRezervacija();
			l2.show();
		}
	});

		btn1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		

				LetLista l1 = new
						LetLista();
				l1.show();
			
			
				
				
			}
		});
		
		
		
	}
	public static void main(String args[]) {
		Let l = new Let();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.show();
	}
	 
	 
 }

