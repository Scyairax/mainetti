/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;
import business.Insert_In_Table;
import static costanti.CostantiAdmin.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTable;
import viste.AdminVista;

/**
 *
 * @author kingu
 */
public class AdminListener implements ActionListener {
    
    AdminVista admin;

    public AdminListener(AdminVista admin) {
        this.admin = admin;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    String get = e.getActionCommand();   // crea un stringa di comparazione con le costanti salvate
    BorderLayout b = (BorderLayout) admin.content.getLayout();
    
    switch (get) {
        case CALENDARIO : {
            admin.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
            admin.content.add(admin.getpCalendario(), BorderLayout.CENTER);
            admin.repaint();
            admin.revalidate();
            break;
        
        }
        
        case REGISTER : {
            admin.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
            admin.content.add(admin.getpGestIsc(), BorderLayout.CENTER);
            admin.repaint();
            admin.revalidate();
            break;
        }   
        
        case NEW_COSE : {
            admin.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
            admin.content.add(admin.getpAttivita(), BorderLayout.CENTER);
            admin.repaint();
            admin.revalidate();
            break;
        }
        
        case PAYMENT : {
            admin.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
            admin.content.add(admin.getpGestPay(), BorderLayout.CENTER);
            admin.repaint();
            admin.revalidate();
            break;
        }
        
        case ADD_LEVEL :{
             Object[] c =admin.getpAttivita().getComponents(); // Mi serve per trovare la tabella dove inserire
             JFrame p = admin.getPan().getFr(); // Mi serve per trova cosa inserire
             Container cont = p.getContentPane();
             Object[] a = cont.getComponents();
             
             Object[] row = Insert_In_Table.PrepareRow(a);
             JTable t = Insert_In_Table.FoundTable("LIVELLO" , c); // LIVELLO E' UN NAME. VEDI RIGA 257  DI ADMINPNNELLI
             Insert_In_Table.In(t, row);
             
             p.dispose();
             break;
                                                             
        }
        
        case ADD_DISCIPLINE : {
             Object[] c =admin.getpAttivita().getComponents(); // Mi serve per trovare la tabella dove inserire
             JFrame p = admin.getPan().getFr(); // Mi serve per trova cosa inserire
             Container cont = p.getContentPane();
             Object[] a = cont.getComponents();
             Object[] row = Insert_In_Table.PrepareRow(a);
             JTable t = Insert_In_Table.FoundTable("DISCIPLINA" , c); // LIVELLO E' UN NAME. VEDI RIGA 257  DI ADMINPNNELLI
             Insert_In_Table.In(t, row);
             p.dispose();
             break;
        
        }
        
        case DELETE : {
            Object[] c =admin.getpAttivita().getComponents(); // Mi serve per trovare la tabella dove inserire
            JTable[] t = Insert_In_Table.FoundTables(c);
            for (int i=0; i<t.length; i++)   
                Insert_In_Table.removeSelectedRows(t[i]);
        
        }
        
        
        
    
    }
    }
    
}
    
    

