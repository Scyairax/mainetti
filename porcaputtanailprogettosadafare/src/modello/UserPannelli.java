package modello;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.jar.JarFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import viste.UserVista;

public class UserPannelli  {

	
public UserPannelli(){
	prepareGui();
}

public void prepareGui(){
	JFrame f = new JFrame("Alessandra puzza");
	f.setMinimumSize(new Dimension(800, 400));
	f.setVisible(true);
	GridBagLayout l = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	f.setLayout(l);
	gbc.weightx=1;
	gbc.weighty=1;
	gbc.fill=GridBagConstraints.BOTH;
	f.add(PannelloGuida(), gbc);
	
	//  QUESTA CLASSE NON SERVE E VA ELIMINATA

}
	// In questa classe si istanzieranno i pannelli dell'utente generico.
	
	

	public JPanel PannelloGuida() {
		JPanel guida = new JPanel();
		JButton area = new JButton("Le nostre aree!");
		JButton calendario = new JButton("Visita il calendario!");
		JButton mycorsi = new JButton("I miei corsi!");
		JButton attività = new JButton("I nostri corsi!");
		JButton commenti = new JButton("Lascia un commento!");
		
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
		guida.add(attività, gbc);
		gbc.gridy++;
		guida.add(mycorsi, gbc);
		gbc.gridy++;
		guida.add(calendario, gbc);
		gbc.gridy++;
		guida.add(area, gbc);
		gbc.gridy++;
		guida.add(commenti, gbc);
		guida.setPreferredSize(new Dimension(150 ,400));
		guida.setBackground(Color.BLACK);
	
		return guida;

		}
	
	public JScrollPane corsi(){
		JPanel p = new JPanel();
		JScrollPane corsi = new JScrollPane(p);
		
		
		String text1 ="Nel mezzo del cammin di nostra vita "
			+"mi ritrovai per una selva oscura,"
				+"ché la diritta via era smarrita."
			
			+"Ahi quanto a dir qual era è cosa dura"
				+"esta selva selvaggia e aspra e forte"
			+"che nel pensier rinova la paura!";			

		JTextArea descrizione = new JTextArea(text1);
		//descrizione.setText(text1);
		//descrizione.setFocusable(false);
		descrizione.setEditable(false);
		descrizione.setLineWrap(true);
		descrizione.setWrapStyleWord(true);
		p.add(descrizione);
		return corsi;
		
	}
                
       
}

