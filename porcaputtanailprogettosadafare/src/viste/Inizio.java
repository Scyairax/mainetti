package viste;
import dbConnection.Connessione;
import javax.swing.JOptionPane;

public class Inizio {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new LoginVista();
		
			    
		
		if (Connessione.getInstance().isConnesso()){ //Perché non vai *Bestemmie*
							//new UserVista();
			JOptionPane.showMessageDialog(null, "Siamo connessi. ");
			}
		else
			JOptionPane.showMessageDialog(null, "Non sei connesso.");
	        }  
		  
        
}

