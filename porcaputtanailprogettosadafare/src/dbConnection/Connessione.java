package dbConnection;



/*
 * Classe dedicata alla gestione del Database.
 * Gestisce l'apertura e la chiusura della connessione col Database
 * Fornisce i metodi per l'esecuzione delle query sul Database
 */
import java.sql.*;
import java.util.ArrayList;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JOptionPane;

public class Connessione {

   private static Connection db;       // La connessione col Database
   private static boolean connesso;    // Flag che indica se la connessione è attiva o meno
   private static Connessione instance; //istanza statica della classe

   public static synchronized Connessione getInstance() {
	   if(instance == null)
		   instance = new Connessione();
	   if(connesso != true)
			connetti("centro_sportivo", "root", "asd123");
	   return instance;
   }
   
   // Apre la connessione con il Database
   private static boolean connetti(String nomeDB, String nomeUtente, String pwdUtente) {

	   if(connesso) return true;

      try {

         // Carico il driver JDBC per la connessione con il database MySQL
         Class.forName("com.mysql.jdbc.Driver");
         db = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + nomeDB + "?user=" + nomeUtente + "&password=" + pwdUtente);
         connesso=true;
         
      } catch (Exception e) {
    	  e.printStackTrace(); 
     }
      
      return connesso;
   }
   
	
	public static Connection ConnIstance()
	{
		
		return db;
	}
   
   
   private void disconnetti() {
	      try {
	         db.close();
	         connesso = false;
	      } catch (Exception e) { e.printStackTrace(); }
	   }

	   public boolean isConnesso() { return connesso; }   // Ritorna TRUE se la connessione con il Database è attiva

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	}


