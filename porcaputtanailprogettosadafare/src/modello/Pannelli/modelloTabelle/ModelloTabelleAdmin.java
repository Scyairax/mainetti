/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Pannelli.modelloTabelle;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kingu
 */
public class ModelloTabelleAdmin {
    
    // MODELLO PER LA TABELLA CHE MOSTRA IL CALENDARIO
    public  DefaultTableModel calmodel(){
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
    
    
    // MODELLO PER LA CONFERMA DI NUOVI ISCRITTI - ADMINPANNELLI
    
     public DefaultTableModel iscrmodel(){
		 DefaultTableModel model;
                model = new DefaultTableModel(){
             /**
              *
              */
             
             
              @Override
             public Class getColumnClass(int column) {
                switch (column) {
                    case 0: 
                        return String.class;
                    case 1: 
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5 :
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
          
		
             
             @Override
             public boolean isCellEditable(int row, int column) {
                 if (column == 5)
                     return true;
                 else
                    return false;
             }
         };
         
           
		String colonne[] = new String[] {"Nome", "Cognome", "Nik", "Corso", "Difficotà", "Accept"};
		Object v[] = new Object[] {"Giacomo", "Rossi", "GioR", "Piscina", "3",  false};
		Object u[] = new Object[] {"Giuseppe", "Verdi", "Joseph ", "Nuoto", "2",  false};
		Object w[] = new Object[] {"Simone", "Cosimini", "Cos..", "Danza(?)", "8", false};
		//String p[] = new String[] {"Cane", "Gatto", "Finestra", "Cuscino", "Quadro", "Porta", "Libro"};
		int i=0;
		Object righe[][] = new Object[][] {u,v,w};
		model.setColumnIdentifiers(colonne);
                Object[] o =  new Object[6];
			for (i=0; i<righe.length; i++){
				System.arraycopy(righe[i], 0, o, 0, 6);
				model.addRow(o);
                        }       
			
	return model;
                
        
    }
     
     //PANNELLO PER LA CONFERMA DEI PAGAMENTI -ADMINPANNELLI
     
      public DefaultTableModel paymodel(){
		final DefaultTableModel model;
                model = new DefaultTableModel(){
             /**
              *
              */
             
             
              @Override
             public Class getColumnClass(int column) {
                switch (column) {
                    case 0: 
                        return String.class;
                    case 1: 
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5 :
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
          
		
             
             @Override
             public boolean isCellEditable(int row, int column) {
                 if (column == 5)
                     return true;
                 else
                    return false;
             }
         };
         
           
		String colonne[] = new String[] {"Nome", "Cognome", "Nik", "Corso", "Prezzo", "Accept"};
		Object v[] = new Object[] {"Giacomo", "Rossi", "GioR", "Piscina", "3",  false};
		Object u[] = new Object[] {"Giuseppe", "Verdi", "Joseph ", "Nuoto", "2",  false};
		Object w[] = new Object[] {"Simone", "Cosimini", "Cos..", "Danza(?)", "8", false};
		//String p[] = new String[] {"Cane", "Gatto", "Finestra", "Cuscino", "Quadro", "Porta", "Libro"};
		int i=0;
		Object righe[][] = new Object[][] {u,v,w};
		model.setColumnIdentifiers(colonne);
                Object[] o =  new Object[6];
			for (i=0; i<righe.length; i++){
				System.arraycopy(righe[i], 0, o, 0, 6);
				model.addRow(o);
                        }       
			
	return model;
                
        
    }
      
      // MODELLO PER LA TABELLA CHE CONTIENE LE DISCIPLINE -ADMINPANNELLI
      
        public DefaultTableModel mymodelDisci(){
		final DefaultTableModel model =  new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String cosu[] =new String[] {"Disciplina", "area"};
		String colonne[] = new String[cosu.length];
                System.arraycopy(cosu, 0, colonne, 0, cosu.length);
                model.setColumnIdentifiers(colonne);
                
        return model;
    }
        
        // MODELLO PER LA TABELLA CHE CONTIENE L'INSERIMENTO DI NUOVI LIVELLI
        
        public DefaultTableModel mymodelvl(){
		final DefaultTableModel model =  new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String cosu[] =new String[] {"Livelli"};
		String colonne[] = new String[cosu.length];
                System.arraycopy(cosu, 0, colonne, 0, cosu.length);
                model.setColumnIdentifiers(colonne);
                
        return model;
    }
     
	
    
}
