/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Pannelli.modelloTabelle;

import static costanti.CostantiIstruttore.GIORNI_SETTIMANA;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kingu
 */
public class ModelloTabelleUser {
    
     public DefaultTableModel modelcalendar(){
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
        
    
}
