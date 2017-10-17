 package viste;

import javax.swing.UIManager;

import static costanti.CostantiLogin.*;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import listeners.LoginListener;

public class LoginVista extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginVista v;
    private LoginListener listen;
    
    
    
	
	//Creazione dei bottoni 
	private JButton login = new JButton("ACCEDI");//Creazione del pulsante accedi al sistema.
	private JButton pwforgotten = new JButton("PASSWORD DIMENTICATA"); //Creazione del pulsante pw domenticata.
	
	//Creazione dei campi di inersimento.
	private JPasswordField pass= new JPasswordField(14);
	private JTextField usr= new JTextField(14);
	
	//Creazione delle etichette.
	private	JLabel pw = new JLabel("PASSWORD");
	private	JLabel user = new JLabel("USERNAME");
	
	
	//Getters & Setters
	

	public char[] getPass() {
		return pass.getPassword();
	}

	public String getUsr() {
		return usr.getText();
	}
	
	
	//Costruttore.
	
	public LoginVista() {
	
		super("Finestra di Login");
		//associazione action listener

    	this.v = this;
    	listen = new LoginListener(v);
		
		login.addActionListener(listen);
		login.setActionCommand(XXXXXX);
	
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                  break;
                }
           }
        } catch (Exception e) {
    
          }
	
    //Creazione del contenitore.
	Container c = getContentPane();
	GridBagLayout layout= new GridBagLayout();
	c.setLayout(layout); // Setto il layout del contenitore come un gridbag


	//Creazione dei pannelli.
	
	GridBagConstraints gb = new GridBagConstraints();
	gb.weighty=1;
	gb.weightx=1;
	gb.fill= GridBagConstraints.BOTH;
	gb.insets.top=10;
	gb.insets.bottom=10;
	gb.insets.right=10;
	gb.insets.left=10;
	
	
	
	//Aggiunta dei bottoni ai pannelli
	
	gb.gridx=0;
	gb.gridy=0;	
	c.add(user, gb);
	
	
	gb.gridx=1;
	c.add(usr, gb);
	
	
	gb.gridx=0;
	gb.gridy=1;
	c.add(pw, gb);
	
	
	gb.gridx=1;
	c.add(pass, gb);
	
	
	gb.gridx=0;
	gb.gridy=2;
	c.add(login, gb);
	
	
	gb.gridx=1;
	c.add(pwforgotten, gb);

	gb.gridx=0;
	gb.gridy=3;
	gb.gridwidth=2;	
	
	
	setVisible(true);
	//setLocation(500, 220);
	setResizable(false);
	setBounds(500, 200, 400, 220);
	//pack();
	//setSize(400,220);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
	}
}	
