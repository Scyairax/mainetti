package modello.Pannelli;
import static costanti.CostantiUtente.*;
import listeners.UtenteListener;
import viste.UserVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import modello.Pannelli.modelloTabelle.ModelloTabelleUser;

public class UPannelli1 {
	
UserVista v;
private UtenteListener listen;
ModelloTabelleUser tab = new ModelloTabelleUser();
	
public UPannelli1 (UserVista v) {
this.v = v;
listen = new UtenteListener(v);

}


//public void prepareGui(){
//	JFrame f = new JFrame("PROVA");
//	f.setMinimumSize(new Dimension(800, 400));
//	f.setVisible(true);
//	BorderLayout bord = new BorderLayout();
//	f.setLayout(bord);
//	f.add(PannelloGuida(), BorderLayout.WEST);
//	f.add(Pannellocommento(), BorderLayout.CENTER);
//	
//	
//
//}
	// In questa classe si istanzieranno i pannelli dell'utente generico.
	// NB. TUTTI I METODI SONO STATICI, CON DEGLI ATTRIBUTI CREATI NELLA CALSSE
        // PROBABILMENTE SI POTREBBERO RICHIAMARE 
	// CON DEI PARAMETRI ARRAYLIST FORNITI DALLA QWERY.
	// GRAZIE PER L'ATTENIONE, SALUTI ED ARRIVEDERCI.
	
	

	private JPanel PannelloGuida() {  // PANNELLO DELLE OPZIONI
		Font myfont = new Font("arial", Font.PLAIN ,12);
		JPanel guida = new JPanel();
		JButton area = new JButton("Le nostre aree");
		JButton calendario = new JButton("Visita il calendario");
		JButton mycorsi = new JButton("I miei corsi");
		JButton attività = new JButton("I nostri corsi");
		JButton commenti = new JButton("Lascia un commento");
		
		// Assegnazione degli action Listener
//			area.addActionListener(Listen);    DA VEDERE SE AGGIUNGERE
//			area.setActionCommand(UTENTE_AREA);
			calendario.addActionListener(listen);
			calendario.setActionCommand(UTENTE_CALENDARIO);
			mycorsi.addActionListener(listen);
			mycorsi.setActionCommand(UTENTE_MYCORSI);
			attività.addActionListener(listen);
			attività.setActionCommand(UTENTE_ATTIVITY);
			commenti.addActionListener(listen);
			commenti.setActionCommand(UTENTE_COMMENTI);
//			
//			
		
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
			guida.add(attività, gbc);
			gbc.gridy++;
			guida.add(mycorsi, gbc);
			gbc.gridy++;
			guida.add(calendario, gbc);
			gbc.gridy++;
			guida.add(area, gbc);
			gbc.gridy++;
			guida.add(commenti, gbc);
			guida.setPreferredSize(new Dimension(180 ,400));
			guida.setBackground(Color.DARK_GRAY);
			guida.setVisible(true);
		
			area.setFont(myfont);
			calendario.setFont(myfont);
			mycorsi.setFont(myfont);
			attività.setFont(myfont);
			commenti.setFont(myfont);
	
		return guida;
		}
	
	private JPanel Pannelloactivity(){
		JPanel p = new JPanel(); // Pannello principale, che verrà visualizzato
		JPanel[] contenitore = new JPanel[4];  // Pannello contenitore da moltiplicare
                JPanel pannello = new JPanel(new GridBagLayout()); // Pannello che conterrà i corsi
                GridBagConstraints gbc = new GridBagConstraints(); // Costrains di p
                GridBagConstraints y = new GridBagConstraints(); // costrains di contenitore
                GridBagConstraints u = new GridBagConstraints(); // costrains di pannello


                
		JScrollPane scrollp = new JScrollPane(pannello);
		JButton[] b = new JButton[4];
		JLabel[] corso = new JLabel[4] ;
                JButton[] prova = new JButton[4];
		JTextArea[] descrizione = new JTextArea[4];
		JScrollPane[] scrollt = new JScrollPane[4];
		JLabel l2 = new JLabel("I NOSTRI CORSI !!");
                p.setBackground(Color.red);
		
		
                    p.setLayout(new GridBagLayout());
                    
                    gbc.insets = new Insets(10, 10, 10, 10);
                    gbc.gridx=0;
                    gbc.gridy=0;
                    gbc.weightx=1;
                    gbc.weighty=1;
                    p.add(l2, gbc);
                    
                    pannello.setBackground(Color.YELLOW);
                    
                    for (int i =0; i<4; i++){
                        contenitore[i] = new JPanel(new GridBagLayout());
                        y.insets = new Insets(1, 1, 1, 1);
                        y.gridx=0;
                        y.gridy=0;
                        y.weightx=1;
                        y.weighty=1;
                        y.fill = GridBagConstraints.BOTH;
                        corso[i] = new JLabel("CORSO" + " " + (i+1));
                        contenitore[i].add(corso[i], y);
                        y.gridy++;
                        y.weighty=9;
                        prova[i] = new JButton("IMMAGINE");
                        contenitore[i].add(prova[i], y);
                        
                        
                        
                        
                        y.gridx = 1;
                        y.gridy = 0;
                        y.weighty = 1;
                        b[i] = new JButton("Clicca per iscriverti e leggere i commenti!");
                        b[i].addActionListener(listen);
                        b[i].setActionCommand(UTENTE_ISCRIZIONE);
                        contenitore[i].add(b[i], y);
                        y.gridy++;
                        y.weighty=9;
                        
                        descrizione[i] = new JTextArea("descrizione del corso");
                        descrizione[i].setEditable(false);
                        scrollt[i] = new JScrollPane(descrizione[i]);
                        contenitore[i].add(scrollt[i], y);
                       
                        
                        
                        u.insets = new Insets(3, 0, 3, 0);
                        u.gridx=0;
                        u.gridy=i;
                        u.weightx=1;
                        u.weighty=1;
                        u.fill = GridBagConstraints.BOTH;
                        contenitore[i].setPreferredSize(new Dimension(150,200));
                        pannello.add(contenitore[i],u);
            //
                    }
                    gbc.weighty = 10;
                    gbc.gridy++;
                    gbc.fill = GridBagConstraints.BOTH;
                    scrollp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scrollp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    p.add(scrollp, gbc);
                        
                        
                    
                   
                    
                     
		return p;
		
	}

	private JPanel Pannellocorsi(){
		JPanel p = new JPanel();
		JButton b1 = new JButton("MODIFICA");
		JLabel l1 = new JLabel("CORSI ALLA QUALE SEI ISCRITTO");
		ArrayList<String> list = new ArrayList<>();
		int i=0;
		Font f = new Font("arialblack", Font.BOLD, 25);
		
			list.add("Corso1");
			list.add("Corso2");
			list.add("Corso3");
			list.add("Corso4");
			list.add("Corso5");
			list.add("Corso6");
			//Iterator<String> myIt = list.iterator();
			GridBagLayout l = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			p.setLayout(l);
			l1.setFont(f);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.insets = new Insets(5, 5, 5, 5);
			gbc.weightx=1;
			gbc.weighty=1;
			gbc.gridx=0;
			gbc.gridy=0;
			gbc.gridwidth=2;
			p.add(l1, gbc);
			gbc.gridwidth=1;
			gbc.gridx=2;
			p.add(b1, gbc);
			gbc.gridy++;
			gbc.gridx=0;
                        
			for (String s : list){
				if ((i % 3)==0) {   // 3 clonne per riga.
					gbc.gridy++;
					gbc.gridx=0;
				}
				Label lo = new Label(s);
				lo.setFont(f);
				p.add(lo, gbc);
				gbc.gridx++;
					i++;
			}
		
		return p;
	
	
	}
	
	
	private JPanel Pannellocommento(){
		JPanel p = new JPanel();
		JPanel up= new JPanel();
		JPanel cen = new JPanel();
		JButton b = new JButton("Invia");
		JComboBox<String> comboaree = new JComboBox<String>();
		JTextArea area = new JTextArea();
		
		JLabel l = new JLabel("SCEGLI IL CORSO PER IL QUALE VUOI LASCIARE IL COMMENTO.");
		
		
			p.setLayout(new BorderLayout());
			cen.setLayout(new FlowLayout());
			up.setLayout(new FlowLayout());
			comboaree.addItem("Test1");
			comboaree.addItem("Test2");
			comboaree.addItem("Test3");
			

			area.setEditable(true);
			area.setPreferredSize(new Dimension(200, 150));		
			cen.add(b);
			cen.add(area);
			up.add(l);
			up.add(comboaree);
			
			
			p.add(up, BorderLayout.NORTH);
			p.add(cen, BorderLayout.CENTER);
			p.setPreferredSize(new Dimension(620 ,600 ));
			cen.setBackground(Color.darkGray);
			
		return p;
	}
	
	private JPanel PannelloCalendario(){
		JPanel p = new JPanel();
		JLabel la = new JLabel("Gare");
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		JTable t =new JTable(tab.modelcalendar());
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
        
        private JPanel PannelloIscritti(String corso){
            // In base al corso si fanno le qwery per capire difficoltà et cazzy
            JPanel p = new JPanel(new GridBagLayout());
            JLabel commenti = new JLabel("Commenti" + corso);
            JScrollPane scroll = new JScrollPane(commenti);
            
            JLabel prezzo = new JLabel("Il prezzo è di :");
            // Qualcosa per la variazione di prezzo in base alla difficoltà
            JComboBox lvl = new JComboBox(new Object[] {"1", "2", "3"});
            JLabel diffi = new JLabel("Scocchia a difficoltà");
            JLabel ora = new JLabel("Scegli il turno che più la aggrada");
            JComboBox combora = new JComboBox(new Object[] {"8-9", "5-6"});
            JButton img = new JButton("IMMAGIN(A)E, PUOI."); // Uso un JButton perchè si espande, simula meglio l'immgine.
            
            GridBagConstraints gbc = new GridBagConstraints();
            
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            p.add(diffi,gbc);
            gbc.gridx++;
            p.add(lvl, gbc);
            gbc.gridx=0;
            gbc.gridy++;
            p.add(ora, gbc);
            gbc.gridx++;
            p.add(combora, gbc);
            gbc.gridx=0;
            gbc.gridy++;
            p.add(prezzo, gbc);
            gbc.gridx++;
            p.add(new JLabel("un rene"), gbc);
            
            gbc.gridheight=3;
            gbc.gridwidth=2;
            gbc.gridy=0;
            gbc.gridx=2;
            gbc.fill = GridBagConstraints.BOTH;
            p.add(img, gbc);
            
            gbc.gridx=0;
            gbc.gridy=3;
            gbc.gridheight=2;
            gbc.gridwidth=4;
            p.add(scroll, gbc);
           
            return p;
        }
	
	
	
	
	
	
	
	//Getters dei metodi privati. 
	//Getters Generalizzati. (?)
        /*data la privatizzazione dei pannelli(elemnti grafici) , non possono essere richiamati
        da altre classi, se non, tramite metodi qui sotto scritti, richiamando questi posso dialogare
        con gli elementi privati di cui non ho visibilità.
        */
	public JPanel GetPanelloCalendario(){ 
		return this.PannelloCalendario();
	}
	
	public JPanel GetPanelloGuida(){
		return this.PannelloGuida();
	}
	
	public JPanel GetPanelloCommento(){
		return this.Pannellocommento();
	}
	
	public JPanel GetPanelloCorsi(){
		return this.Pannellocorsi();
	}
	
	public JPanel GetPanelloActivity(){
		return this.Pannelloactivity();
	}
        
        public JPanel GetPanelloIscritti(String corso){
		return this.PannelloIscritti(corso);
	}
}



		
		
		
	

