package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import dbConnection.Connessione;
import javax.swing.JOptionPane;

public class ExecQuery {
         
	   public int excuteSQLQuery(String query)
	   {
		   
		   
		   //non serve perche richiamo il modo assoluto la classe connessione che è
		   // una statica  - gigi spiegazione camera variabile
		  // Connessione _ = Connessione.getInstance();
	       //la chiamo per sicurezza nel caso non sia stata creata l'istruzione
		   // l'underscore serve sia a generalizzare la tipizzazione che la gestione in memoria
		   		Statement st;
			   ResultSet rs;
		   
	       try {
	    	   
	           st = Connessione.ConnIstance().createStatement();
	           rs = st.executeQuery(query);	           
	           System.out.println("Result-set: " + rs);         
	           if((rs.next()))//ritorna true se non trova record, ! cambia il booleano di ritrono
	           {
	               JOptionPane.showMessageDialog(null, "data succefully");
	              int id_user = rs.getInt("id_user");
	              System.out.println("ID USER" + id_user); 
	              return id_user;
	           
	           }else
	            {
	                JOptionPane.showMessageDialog(null, "data not succefully");
	                return -1;
	            }
	           
	       }catch(java.sql.SQLException  ex)
	       {
	           ex.printStackTrace();
	           System.out.println(ex.getMessage());
	           JOptionPane.showMessageDialog(null, "errore");
	           
	           return -2;
	       } 
	       
	   }
	   

	   public int excuteSQLQueryLogin(int id_user)
	   {
		   
		  // Connessione _ = Connessione.getInstance();

		   String[] str = new String[4];//perchè il quarto non è usato		   
		   str[1] = "tesserato";
		   str[2] = "istruttore";
		   str[3] = "gestore";
		   
		   int i;
		   for(i=1;i<4;i++){
			  String query = "SELECT * FROM "+str[i]+" WHERE id_user_fk='"+id_user+"';";
			  System.out.println("ID USER" + id_user); 
			  Statement st2;
			   ResultSet rs2;
	       try {
	           st2 = Connessione.ConnIstance().createStatement();
	           rs2 = st2.executeQuery(query);

	           if(!(rs2.wasNull()))
	           {
	               JOptionPane.showMessageDialog(null, "data succefully from login");
	               System.out.println("valore indice for "+i);
	               
	           }else
	            {
	        	   
	                JOptionPane.showMessageDialog(null, "data not succefully from login");
	                return -1;
	                
	            }
	            
	       }catch(Exception ex)
	       {
	           ex.printStackTrace();
	           System.out.println(ex.getMessage());
	           return -2;
	       }
	
		  }
		return -3;//end for
	       
	   }
	
	
}
	

