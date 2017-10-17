package viste;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import modello.Pannelli.UPannelli1;


 // CLASSE DI VISTA DELL'UTENTE

public class UserVista extends Finestra{
	
	
	//Pannelli del content.
	private final UPannelli1 pan = new UPannelli1(this);
        private final JPanel pActivita = pan.GetPanelloActivity();
        private final JPanel pCorsi = pan.GetPanelloCorsi();
        private final JPanel pComment = pan.GetPanelloCommento();
        private final JPanel pCalendar = pan.GetPanelloCalendario();
	
	// COSTRUTTORE :
	
       
	public UserVista(String Nome) {
		content.add(pan.GetPanelloGuida(), BorderLayout.WEST);
		content.add(pan.GetPanelloCalendario(), BorderLayout.CENTER);
		this.setUtente(Nome);
                super.c.add(footer, BorderLayout.SOUTH);
                repaint();
                revalidate();
	}


	public UPannelli1 getPan() {
		return pan;
	}

        public JPanel getpActivita() {
                return pActivita;
        }

        public JPanel getpCorsi() {
                return pCorsi;
        }
         
        public JPanel getpComment() {
                return pComment;
        }

        public JPanel getpCalendar() {
                return pCalendar;
        }
        



}
