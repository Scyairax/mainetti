
package modello.Pannelli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import static costanti.CostantiIstruttore.*;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import listeners.IstruttoreListener;
import viste.IstruttoreViste;


public class IstruttorePannelli {
 
    IstruttoreViste v;
    private IstruttoreListener listener;
    
    public IstruttorePannelli(IstruttoreViste v){
        this.v=v;
        listener = new IstruttoreListener(v);
    }
    
    
    // Creazione pannello menu
    private JPanel PannelloGuida() {
        
            Font myfont = new Font("arial", Font.PLAIN ,12);
            JPanel guida = new JPanel();
            JButton calendar = new JButton("Creazione calendario");
            JButton evento = new JButton("Crea un evento");
            JButton some = new JButton("altre azioni");
            JButton same = new JButton("altre azioni");
            JButton seme = new JButton("altre azioni");
            
            // Action Listener
            calendar.addActionListener(listener);
            calendar.setActionCommand(ISTRUCT_CALENDAR);
            evento.addActionListener(listener);
            evento.setActionCommand(ISTRUCT_ACT);
            
            
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
            guida.add(calendar, gbc);
            gbc.gridy++;
            guida.add(evento, gbc);
            gbc.gridy++;
            guida.add(some, gbc);
            gbc.gridy++;
            guida.add(same, gbc);
            gbc.gridy++;
            guida.add(seme, gbc);
            gbc.gridy++;
            guida.setPreferredSize(new Dimension(180 ,400));
            guida.setBackground(Color.DARK_GRAY);   
            guida.setVisible(true);
		
            same.setFont(myfont);
            seme.setFont(myfont);
            some.setFont(myfont);
            calendar.setFont(myfont);
            evento.setFont(myfont);           
        return guida;
    }
    
    
    private  JPanel PannelloBuildCalendar() {
        JPanel p = new JPanel();
        JComboBox giorni = new JComboBox(GIORNI_SETTIMANA);  // NB. SI POTREBBE PENSARE DI CREARE NELLE COSTANTI UN VETTOE DI GIORNI DELLA SETTIMANA
        JComboBox attività = new JComboBox(); // Qui servono le attività di competenza dell'istruttore
        JComboBox orari = new JComboBox(ORARI); // ALTRE COSTANTI CON GLI ORARI GIÀ PREFISSATI.
        JButton add = new JButton("Aggiungi");
        JButton delete = new JButton("Cancella");
        JLabel g = new JLabel("Scegli il giorno");
        JLabel a = new JLabel("Scegli l'attività");
        JLabel o = new JLabel("Scegli l'orario");
        JTable t = new JTable(this.mymodelCalendar());
       
        for (int i =0; i<t.getColumnCount(); i++)                // Colonne grandi
           t.getColumnModel().getColumn(i).setMinWidth(90);
        
        JScrollPane scroll = new JScrollPane(t);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t.getTableHeader().setReorderingAllowed(false);
        GridBagLayout lay = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        p.setLayout(lay);
            
        // Divido la schermata in due, alla sinistra lable + combo, alla destra la tabella
        // Sinistra in baso i pulsanti
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx=0;
            gbc.gridy=0;
            p.add(g, gbc);
            gbc.gridx++;
            p.add(giorni, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(o, gbc);
            gbc.gridx++;
            p.add(orari, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(a, gbc);
            gbc.gridx++;
            p.add(attività, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(add, gbc);
            gbc.gridx++;
            p.add(delete, gbc);
            //Aggiunta della tabella
            gbc.gridy=0;
            gbc.gridx=2;
            gbc.weightx=55;
            gbc.gridheight=4;
            gbc.fill= GridBagConstraints.BOTH;
            p.add(scroll, gbc); 
            
        return p;
    }

   
    private DefaultTableModel mymodelCalendar(){
		final DefaultTableModel model =  new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String colonne[] = new String[GIORNI_SETTIMANA.length +1 ];
                colonne[0] = "Orario";
                System.arraycopy(GIORNI_SETTIMANA, 0, colonne, 1, GIORNI_SETTIMANA.length);
                model.setColumnIdentifiers(colonne);
                //Object[] o =  new Object[8];
                //o[0]=ORARI[1];
                //String u[] = new String[] {"Qualcosa", "Magari..", " ", "Assolutamnte", "Forse", " ", " ", "Boh"};
                //System.arraycopy(u, 0, o, 1, 7);
                //model.addRow(o);
                
        return model;
        
    }
    
    
    private JPanel PannelloActivityCreator(){
        JPanel p = new JPanel();
        JComboBox difficult = new JComboBox(DIFFICOLTÀ);  // NB. SI POTREBBE PENSARE DI CREARE NELLE COSTANTI UN VETTOE DI GIORNI DELLA SETTIMANA
        JComboBox aree = new JComboBox(AREE);
        final JComboBox attivi = new JComboBox(new Object[] {"corso1", "corso2", "corso3"});
        final JTextField act = new JTextField(3); 
        JButton add = new JButton("Aggiungi");
        JButton delete = new JButton("Cancella");
        JComboBox isg = new JComboBox(new Object[] {"corso", "gara"});
        JLabel diff = new JLabel("Scegli la difficoltà");
        JLabel natt = new JLabel("Inserisci la nuova attività");
        JLabel att = new JLabel("Inserisci una attività del corso");
        JLabel ar = new JLabel("Scegli l' area di competenza");
        JLabel tipo = new JLabel("Scegli il tipo di evento");
        JTable t = new JTable(this.mymodelArea());
        act.setEditable(false);
        act.setEnabled(false);
        aree.setEnabled(true);
        difficult.setEnabled(true);
        
        /*
        * N.B Questo action listener è interno alla classe vista, in quanto evita 
        * di fare chiamare e creare metodi appositi per la gestione dello switch tra gare
        * e corsi. Dovrebbe anche favorire l'ottimizzazione del codice
        * ACTION LISTENER JCOMBOBOX ISG (IS GARE) 
        */
        
        isg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                String get = (String) source.getSelectedItem();
                switch (get) {
                    case "gara" :{
                        attivi.setEnabled(false);
                        act.setEditable(true);
                        act.setEnabled(true);
                     break;
                    }
                    case "corso" : {
                        attivi.setEnabled(true);
                        act.setEditable(false);
                        act.setEnabled(false);
                        
                    }
                        
                }
            }
        });
        
        // Action listenrbottoni
        
        add.addActionListener(listener);
        add.setActionCommand(ISTRUCT_ADD);
        delete.addActionListener(listener);
        delete.setActionCommand(ISTRUCT_DEL);
        
        for (int i =0; i<t.getColumnCount(); i++)                // Colonne grandi
           t.getColumnModel().getColumn(i).setMinWidth(120);
        
        
        JScrollPane scroll = new JScrollPane(t);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t.getTableHeader().setReorderingAllowed(false);
        GridBagLayout lay = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        p.setLayout(lay);
            
        // Divido la schermata in due, alla sinistra lable + combo, alla destra la tabella
        // Sinistra in baso i pulsanti
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx=0;
            gbc.gridy=0;
            p.add(natt, gbc);
            gbc.gridx++;
            p.add(act, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(att,gbc);
            gbc.gridx++;
            p.add(attivi, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(tipo, gbc);
            gbc.gridx++;
            p.add(isg, gbc);
            gbc.gridy++;
            gbc.gridx=0;
            p.add(ar, gbc);
            gbc.gridx++;
            p.add(aree, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(diff, gbc);
            gbc.gridx++;
            p.add(difficult, gbc);
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridx = 0;
            gbc.gridy++;
            p.add(add, gbc);
            gbc.gridx++;
            p.add(delete, gbc);
            //Aggiunta della tabella
            gbc.gridy=0;
            gbc.gridx=2;
            gbc.weightx=55;
            gbc.gridheight=4;
            gbc.fill= GridBagConstraints.BOTH;
            p.add(scroll, gbc); 
            
        return p;

           
        
    
    }
    
     private DefaultTableModel mymodelArea(){
		final DefaultTableModel model =  new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String cosu[] =new String[] {"attività", "tipo",  "area", "livello"};
		String colonne[] = new String[cosu.length];
                System.arraycopy(cosu, 0, colonne, 0, cosu.length);
                
                model.setColumnIdentifiers(colonne);
                
        return model;
    }
     
     
     public JPanel GetPanelloCalendario(){
		return this.PannelloBuildCalendar();
	}
     
     public JPanel GetPanelloActivity(){
		return this.PannelloActivityCreator();
	}
     
     public JPanel GetPanelloGuida(){
		return this.PannelloGuida();
	}
     
}