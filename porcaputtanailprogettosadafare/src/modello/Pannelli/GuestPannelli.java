package modello.Pannelli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import viste.GuestVista;
import listeners.GuestListener;
import static costanti.CostantiGuest.*;


public class GuestPannelli {
	   GuestVista g;
           private GuestListener listen;
	
	
	 public GuestPannelli(GuestVista g) {
                this.g = g;
                listen = new GuestListener(g);
		}

		
	private JPanel PannelloGuida(){
		Font myfont = new Font("arial", Font.PLAIN ,12);
		JPanel guida = new JPanel();
		JButton area = new JButton("Le nostre aree!");
		JButton calendario = new JButton("Visita il calendario!");
		JButton attività = new JButton("I nostri corsi!");
		JButton register = new JButton("REGISTRATI!");
                        
                
                        calendario.addActionListener(listen);
                        calendario.setActionCommand(Guest_Cal);
                        attività.addActionListener(listen);
                        attività.setActionCommand(Guest_Act);
                        register.addActionListener(listen);
                        register.setActionCommand(Guest_Reg);
                
			GridBagLayout lay = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			guida.setLayout(lay);
		
			gbc.insets.bottom=10;
			gbc.insets.left=10;
			gbc.insets.right=10;
			gbc.insets.top=10;
			gbc.weightx=1;
			gbc.weighty=1;
			gbc.fill= GridBagConstraints.NONE;
		
			gbc.gridx=0;
			gbc.gridy=0;
			guida.add(register, gbc);
			gbc.gridy++;
			guida.add(attività, gbc);
			gbc.gridy++;
			guida.add(calendario, gbc);
			gbc.gridy++;
			guida.add(area, gbc);
			guida.setPreferredSize(new Dimension(180 ,400));
			guida.setBackground(Color.YELLOW);
			guida.setVisible(true);
		
			area.setFont(myfont);
			calendario.setFont(myfont);
			attività.setFont(myfont);
			
	
		return guida;
	}	
	
	private JPanel PannelloRegister(){
		JPanel p = new JPanel();
		JLabel l = new JLabel("Compila i campi e registrati subito!");
		JButton reg = new JButton("Registrati");
		JLabel usr = new JLabel("USERNAME");
		JTextField usrf = new JTextField();
		JLabel pw = new JLabel("PASSWORD");
		JPasswordField pwf = new JPasswordField();
		JLabel email = new JLabel("INDIRIZZO EMAIL");
		JTextField emf = new JTextField();
		JLabel nome = new JLabel("NOME");
		JTextField namef = new JTextField();
		JLabel cognome = new JLabel("COGNOME");		
		JTextField cognf = new JTextField();
		
			GridBagLayout la = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			p.setLayout(la);
			gbc.weightx = 1;
			gbc.weighty = 1;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(10, 10, 10, 10);
			gbc.gridx= 0;
			gbc.gridy=0;
			gbc.gridwidth=2;
			p.add(l, gbc);
			gbc.gridwidth=1;
			gbc.gridx=0;
			gbc.gridy++;
			p.add(nome, gbc);
			gbc.gridx++;
			p.add(namef, gbc);
			gbc.gridx=0;
			gbc.gridy++;
			p.add(cognome, gbc);
			gbc.gridx++;
			p.add(cognf, gbc);
			gbc.gridy++;
			gbc.gridx=0;
			p.add(usr, gbc);
			gbc.gridx++;
			p.add(usrf, gbc);
			gbc.gridx=0;
			gbc.gridy++;
			p.add(pw, gbc);
			gbc.gridx++;
			p.add(pwf, gbc);
			gbc.gridy++;
			gbc.gridx=0;
			p.add(email, gbc);
			gbc.gridx++;
			p.add(emf, gbc);
			gbc.gridy++;
			p.add(reg, gbc);
			
			p.setVisible(true);
			

		
		
	return p;
	}
        
        
        
        private JPanel Pannelloactivity(){
		JPanel p = new JPanel();
		JPanel up = new JPanel();
		JPanel cen = new JPanel();
		JButton b1 = new JButton("FITNESS");
		JButton b2 = new JButton("NUOTO");
		JButton b3 = new JButton("KARATE");
		JButton b4 = new JButton("PALESTRA");
		JLabel l1 = new JLabel("I NOSTRI CORSI !!");
		
		
			p.setLayout(new BorderLayout());
			cen.setLayout(new FlowLayout());
			up.setPreferredSize(new Dimension(800, 150));
			l1.setFont(new Font ("arialblack", Font.BOLD, 20));
			Dimension d = new Dimension(250, 50);
			b1.setPreferredSize(d);
			b2.setPreferredSize(d);
			b3.setPreferredSize(d);
			b4.setPreferredSize(d);
			cen.add(b1);
			cen.add(b2);
			cen.add(b3);
			cen.add(b4);
			up.add(l1);
			p.add(cen, BorderLayout.CENTER);
			p.add(up, BorderLayout.NORTH);
	return p;
        }  
        
        
        private JPanel PannelloCalendario(){
		JPanel p = new JPanel();
		JLabel la = new JLabel("Gare");
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		JTable t =new JTable(this.mymodel());
		t.setRowHeight(35);
		JScrollPane scroll = new JScrollPane(t);
		gbc.gridy=0;
		gbc.gridwidth=3;
		gbc.gridheight=3;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		p.add(scroll, gbc);
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.gridy=4;
		p.add(la, gbc);
		return p;
	}
	
	
	
	
	private DefaultTableModel mymodel(){
		final DefaultTableModel model =  new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String colonne[] = new String[] {"Orario", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
		String v[] = new String[] {"Nulla", "Qualcosa", "Nulla", "Qualcosa", "Nulla", "Qualcosa", "Magari.."};
		String u[] = new String[] {"Qualcosa", "Magari..", " ", "Assolutamnte", "Forse", " ", " ", "Boh"};
		String w[] = new String[] {" ", " ", " ", "Magari..", "Boh", "Forse", " ", "Assolutamnte"};
		String p[] = new String[] {"Cane", "Gatto", "Finestra", "Cuscino", "Quadro", "Porta", "Libro"};
		String ora[]= new String[] {"8.30-9.30", "9.30-10.30", "10.30-11.30", "11.30-12.30"};
		int i=0;
		String righe[][] = new String[][] {u,v,p,w};
		model.setColumnIdentifiers(colonne);
		Object[] o =  new Object[8];
			for (i=0; i<righe.length; i++){
				o[0]=ora[i];
				System.arraycopy(righe[i], 0, o, 1, 7);
				model.addRow(o);
			}
	return model;
	} 
	
	
	//Getters dei metodi privati. 
	//Getters Generalizzati. (?)
	public JPanel GetPanelloCalendario(){
		return this.PannelloCalendario();
	}
        
        public JPanel GetPanelloActivity(){
		return this.Pannelloactivity();
	}
        
        public JPanel GetPanelloGuida(){
		return this.PannelloGuida();
	}
        
         public JPanel GetPanelloRegister(){
		return this.PannelloRegister();
	}
	
        
        
        
        
        
        
}
