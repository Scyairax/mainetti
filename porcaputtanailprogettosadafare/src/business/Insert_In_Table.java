/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kingu
 */
public class Insert_In_Table {
    
    public static void In (JTable t, Object ... par) {
        DefaultTableModel mod =   (DefaultTableModel) t.getModel();
        mod.addRow(par);
        //mod.fireTableDataChanged();
       
      
        
    }
    
    public static Object[] PrepareRow (Object ... s){
        ArrayList<String> list = new ArrayList();
        int i;
        for (i=0; i<s.length; i++) {
            String e = s[i].getClass().toString();
            System.out.println(e);
            if (((s[i] instanceof JTextField)) || ((s[i] instanceof JComboBox)))  {
                switch(e){
                
                     case "class javax.swing.JTextField" : { 
                        JTextField f = (JTextField) s[i];
                        if (f.isEnabled())
                            list.add((String) f.getText());
                             
                        
                        break;
                    }
                
                     case "class javax.swing.JComboBox" : {
                         JComboBox c = (JComboBox) s[i];
                         if (c.isEnabled())
                            list.add((String)c.getSelectedItem());
                         
                         break;
                    } 
                    
                     default : {
                         break;
                     }
                 }
            }
        }
    return list.toArray();
    }
    
    public static JTable FoundTable(Object ... q){
      JTable t = null;
      JScrollPane pane;
      
      for (int i = 0; i < q.length; ++i) {
            if ((q[i] instanceof JScrollPane)) {
                 pane = (JScrollPane) q[i];               
                 Object[] d = pane.getComponents();        
                 JViewport v = (JViewport) d[0];                   
                 Object[] r = v.getComponents();          
                 t = (JTable) r[0];
                 break;    
          }
        }
        return t;
    }
    
     public static JTable[] FoundTables(Object ... q){
      ArrayList<JTable> t = new ArrayList<>();
      JScrollPane pane;
      JTable[] tab = new JTable[1];
      
      for (int i = 0; i < q.length; ++i) {
            if ((q[i] instanceof JScrollPane)) {
                 pane = (JScrollPane) q[i];               
                 Object[] d = pane.getComponents();        
                 JViewport v = (JViewport) d[0];                   
                 Object[] r = v.getComponents();          
                 t.add((JTable) r[0]) ;
                     
          }
        }
        return (JTable[]) t.toArray(tab);
    }
    
    
    public static JTable FoundTable(String name, Object ... q ){
      JTable t = null;
      JScrollPane pane;
      
      for (int i = 0; i < q.length; ++i) {
            if ((q[i] instanceof JScrollPane)){
                 pane = (JScrollPane) q[i]; 
                 System.out.println(pane.getName());
                 if (pane.getName().equals(name)) {
                 Object[] d = pane.getComponents();        
                 JViewport v = (JViewport) d[0];                   
                 Object[] r = v.getComponents();          
                 t = (JTable) r[0];
                 
                 break;  
             }
          }
        }
        return t;
    }
    
    // SI RINGRAZIA L'UTENTE ALEJANDRO PER IL METODO, TROVATO SULLA PIATTAFORMA STACKOVERFLOW
    public static void removeSelectedRows(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int[] rows = table.getSelectedRows();
        for(int i=0;i<rows.length;i++){
        model.removeRow(rows[i]-i);
   }
}
}
