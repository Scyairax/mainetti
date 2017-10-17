/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viste.IstruttoreViste;
import static costanti.CostantiIstruttore.*;
import business.Insert_In_Table;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

/**
 *
 * @author kingu
 */
public class IstruttoreListener implements ActionListener {
    
    IstruttoreViste istr;

    public IstruttoreListener(IstruttoreViste istr) {
        this.istr =istr;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    String get = e.getActionCommand();   // crea un stringa di comparazione con le costanti salvate
    BorderLayout b = (BorderLayout) istr.content.getLayout();
    
    switch (get) {
        
        /*
        * Casi per cambiare il pannello principale. 
        * Action listeners messi sui bottoni del pannello guida.
        */
        
        case  ISTRUCT_ACT : {
            istr.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
            istr.content.add(istr.getPannelloAttivita(), BorderLayout.CENTER);
            istr.repaint();
            istr.revalidate();
            break;
        }
        
        case ISTRUCT_CALENDAR : {
            istr.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
            istr.content.add(istr.getPan().GetPanelloCalendario(), BorderLayout.CENTER);
            istr.repaint();
            istr.revalidate();
            break;
        }
        
        /*
        * Casi per il pannello di inserimento attività
        */
        
         case ISTRUCT_ADD : {
            Object[] c = istr.getPannelloAttivita().getComponents();
            Object[] row = Insert_In_Table.PrepareRow(c);
            
            for (int i=0; i<row.length; i++){    // Only for prove
                    System.out.println(row[i]);
                    //System.out.println(c[i]);
            }    
            
            JTable t = Insert_In_Table.FoundTable(c);
            Insert_In_Table.In(t, row);
          
        }
         
         case ISTRUCT_DEL : {
            Object[] c = istr.getPannelloAttivita().getComponents();
            
            JTable t = Insert_In_Table.FoundTable(c);
            Insert_In_Table.removeSelectedRows(t);
         }
    }
            
            
             
        
    }
}
  
    
    
    
    
    

