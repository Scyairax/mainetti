/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * N.B VA AGGIUNTO UN NUOVO PANNELLO PER LE ACCETTAZIONE DEI PAGAMENTI, COPIARE IL PANNELLO DI ACCETTAZIONI ISCRIZIONI.
 */
package modello.Pannelli;

import static costanti.CostantiAdmin.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import viste.AdminVista;
import listeners.AdminListener;
import modello.Pannelli.Popup.PopUp;
import modello.Pannelli.modelloTabelle.ModelloTabelleAdmin;
/**
 *
 * @author kingu
 */
public class AdminPannelli {
    
    AdminVista v;
    private AdminListener list;
    ModelloTabelleAdmin tab = new ModelloTabelleAdmin();
    static  JFrame fr;

    public AdminPannelli(AdminVista v) {
        this.v = v;
        list = new AdminListener(v);
       
    }
    
    
    
    
    private JPanel PannelloGuida() {  // PANNELLO DELLE OPZIONI
		Font myfont = new Font("arial", Font.PLAIN ,12);
		JPanel guida = new JPanel();
		JButton accept = new JButton("Gestione iscritti");
		JButton calendario = new JButton("Visita il calendario");
		JButton corsi = new JButton("Gestione corsi");
                JButton pay = new JButton("Gestione Pagamenti");
		
		// Assegnazione degli action Listener
                        accept.addActionListener(list);
                        accept.setActionCommand(REGISTER);
                        calendario.addActionListener(list);
                        calendario.setActionCommand(CALENDARIO);
                        corsi.addActionListener(list);
                        corsi.setActionCommand(NEW_COSE);
                        pay.addActionListener(list);
                        pay.setActionCommand(PAYMENT);
                
                
		
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
			guida.add(accept, gbc);
			gbc.gridy++;
			guida.add(corsi, gbc);
			gbc.gridy++;
                        guida.add(pay, gbc);
                        gbc.gridy++;
			guida.add(calendario, gbc);
			guida.setPreferredSize(new Dimension(180 ,400));
			guida.setBackground(Color.DARK_GRAY);
			guida.setVisible(true);
		
			accept.setFont(myfont);
			calendario.setFont(myfont);
			corsi.setFont(myfont);
	
		return guida;
		}
    
    // Pannello di visualizzazione del calendario
    
    private JPanel PannelloCalendario(){
		JPanel p = new JPanel();
		JLabel la = new JLabel("Gare");
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		JTable t =new JTable(tab.calmodel());
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
	
	
	
	
	
    // Pannello per la gestione di nuovi iscritti
    
    private JPanel PannelloIscritti(){
		JPanel p = new JPanel();
		JLabel la = new JLabel("Gestione iscritti");   
                JButton ok = new JButton("Accettazione");
                JButton no = new JButton("Rifiuta");
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		JTable t =new JTable(tab.iscrmodel());
                
                 for (int i =0; i<t.getColumnCount(); i++)                // Colonne grandi
                         t.getColumnModel().getColumn(i).setMinWidth(120);
                         
                 
                JScrollPane scroll = new JScrollPane(t);
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                t.getTableHeader().setReorderingAllowed(false);
		t.setRowHeight(35);
                t.getTableHeader().setReorderingAllowed(false);
                
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.gridy=0;
                gbc.gridx=0;
                gbc.gridwidth = 2;
                p.add(la, gbc);
                gbc.weighty = 10;
                gbc.gridy++;
		gbc.gridheight=3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		p.add(scroll, gbc);
                gbc.weighty = 1;
                gbc.gridwidth =1;
                gbc.gridy = 4;
                gbc.gridx = 0;
                p.add(ok, gbc);
                gbc.gridx = 1;
                p.add(no, gbc);
		
                
		return p;
	}
    
        
    // Pannello per la gestione dei pagamenti
         
         private JPanel PannelloPay(){
		JPanel p = new JPanel();
		JLabel la = new JLabel("Gestione Pagamenti");   
                JButton ok = new JButton("Accettazione");
                JButton no = new JButton("Rifiuta");
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		JTable t =new JTable(tab.paymodel());
                
                 for (int i =0; i<t.getColumnCount(); i++)                // Colonne grandi
                         t.getColumnModel().getColumn(i).setMinWidth(120);
                         
                 
                JScrollPane scroll = new JScrollPane(t);
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                t.getTableHeader().setReorderingAllowed(false);
		t.setRowHeight(35);
                t.getTableHeader().setReorderingAllowed(false);
                
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.gridy=0;
                gbc.gridx=0;
                gbc.gridwidth = 2;
                p.add(la, gbc);
                gbc.weighty = 10;
                gbc.gridy++;
		gbc.gridheight=3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		p.add(scroll, gbc);
                gbc.weighty = 1;
                gbc.gridwidth =1;
                gbc.gridy = 4;
                gbc.gridx = 0;
                p.add(ok, gbc);
                gbc.gridx = 1;
                p.add(no, gbc);
		
                
		return p;
	}
    
        
    
    // Pannello per la gestione dei corsi
    
    
    private JPanel PannelloActivityManagement(){
                JPanel p = new JPanel(new GridBagLayout());
                JButton add = new JButton("Aggiungi");
                JButton delete = new JButton("Cancella");
                JButton neu = new JButton("New");
                JLabel scelta = new JLabel(" Scegli se aggiungere una nuova disciplina  o un nuovo livello  ");
                final JComboBox comb = new JComboBox(new Object[] {"livello", "disciplina"});
                JTable tdisci = new JTable(tab.mymodelDisci());
                JTable tlvl = new JTable(tab.mymodelvl());
                GridBagConstraints gbc = new GridBagConstraints();
              // Sono i pannelli che andranno a posizionarsi in alto, al centro ed in basso  
               
                    for (int i =0; i<tdisci.getColumnCount(); i++)               // Colonne grandi
                        tdisci.getColumnModel().getColumn(i).setMinWidth(120);
                    
                    for (int i =0; i<tlvl.getColumnCount(); i++)               // Colonne grandi
                        tdisci.getColumnModel().getColumn(i).setMinWidth(120);
                    
        
                JScrollPane dscroll = new JScrollPane(tdisci);
                dscroll.setName("DISCIPLINA");
                
                JScrollPane lscroll = new JScrollPane(tlvl);
                lscroll.setName("LIVELLO");

                dscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                tdisci.getTableHeader().setReorderingAllowed(false);
                
                lscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                tlvl.getTableHeader().setReorderingAllowed(false);     
                
                delete.addActionListener(list);
                delete.setActionCommand(DELETE);
                
            
       /*
        * DIVIDO LA SCHERMATA IN DUE, CON LE DUE TABELLE CONTENENTI LE DISCIPLINE ED 
        * I LIVELLI. UN PULSANTE CHE APRE UN POP-UP CON UN FRAME PER L'INSERIMENTO.   
        */      gbc.insets = new Insets(10, 10, 10, 10);
                gbc.weightx=1;
		gbc.weighty=1;
		gbc.gridy=0;
                gbc.gridx=0;
                gbc.gridwidth = 2;
                p.add(scelta, gbc);
                gbc.gridwidth = 1;
                gbc.gridx =2;
                p.add(comb, gbc);
                gbc.gridx++;
                p.add(neu, gbc);
                
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridx=0;
                gbc.gridy++;
                gbc.gridwidth = 2;
                gbc.weighty=15;
                p.add(dscroll, gbc);
                gbc.gridx=2;
                p.add(lscroll,gbc);
                
                gbc.weighty=1;
                gbc.gridy++;
                gbc.gridx=0;
                p.add(add, gbc);
                gbc.gridx=2;
                p.add(delete, gbc);

                
       
           /* INSERISCO QUI L'ACTION LISTENER DELL'APPARIZIONE DEL FORM DI INSERIMENTO,
            * IN QUANTO PORTA AD UNA OTTIMIZAZIONE DEL CODICE, NON PORTANDO ALLA    
            * CREAZIONE DI CHIAMATE, O DI METODI PARTICOLARI CREATI AD HOC   
            */
                
                neu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String get = (String) comb.getSelectedItem();
                        switch (get) {
                        
                            case "disciplina" :{
                               fr = new PopUp(list).Popdisci();
                               break;
                            }
                            
                            case "livello" : {
                                fr =new PopUp(list).Poplvl();
                                break;
                            }
                        }
                    }
                });
           
                
        return p;
        
    
    }
    
    
   
    
    
     
     
     
     
     
     
     
     
     
     
     // GETTERS & SETTERS GENERALIZZATI (?)
        
        public JPanel GetPanelloCalendario(){
		return this.PannelloCalendario();
	}
    
      public JPanel GetPanelloGuida(){
		return this.PannelloGuida();
	}
      public JPanel GetPanelloIscritti(){
		return this.PannelloIscritti();
	}
      
       public JPanel GetPanelloActivity(){
		return this.PannelloActivityManagement();
	}
       
        public JPanel GetPanelloPay(){
		return this.PannelloPay();
	}
        
       // GETTER DELLA POPUP LISTENER. MI SERVE QUELLA ISTANZA

    public JFrame getFr() {
        return fr;
    }
        

    
        

} 
    
         
    
    

