package viste;


	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import listeners.FooterListener;
import static costanti.CostantiFooter.*;
import java.awt.Toolkit;

	public abstract class Finestra extends JFrame {
		// La finestra si dividerà in 3 pannelli principali, l'header di intestazione, il content, 
		//il pannello centrale, ed infine il footer, in basso.
		
		/**
		 * 
		 */
                private final FooterListener foo = new FooterListener(); // Action listener
		private static final long serialVersionUID = 1L;  // Non so a cosa serva, ma se lo ometto mi da warning
		public JPanel header = new JPanel();
		public JPanel content = new JPanel();   
		public JPanel footer = new JPanel();
		// Ora creo le varie etichette da appiccicare all'header.
		
		private JLabel intestazione = new JLabel("Sei connesso come ");
		private JLabel utente = new JLabel("");
		private JLabel logo;
    // Quelle del footer.
		
		private JButton facebook;
		private JButton twitter;
		private JButton instagram;
		private JLabel follow = new JLabel("Follow Us! ");
                private Font fox = new Font("Neon 80s", Font.BOLD, 20);
                public Container c;
                ClassLoader cl = this.getClass().getClassLoader();
		
		//Pannelli del content.
		
		
		// COSTRUTTORE :
		
		public Finestra() {
			super("PALESTRA");
                                // SI RINGRAZIA MOHAMMOD HOSSAIN DI STACKOVERFLOW
        			this.facebook = new JButton((Icon) new ImageIcon(cl.getResource("Imagini/fb.png")));
                                this.twitter = new JButton((Icon) new ImageIcon(cl.getResource("Imagini/tw.png")));
                                this.instagram = new JButton((Icon) new ImageIcon(cl.getResource("Imagini/ins.png")));
                                this.logo = new JLabel((Icon) new ImageIcon(cl.getResource("Imagini/LOGO1.png")));
                                this.utente.setFont(fox);
                                this.follow.setFont(fox);
                                this.intestazione.setFont(fox);
                                this.facebook.addActionListener(foo);
                                this.facebook.setActionCommand(FACEBOOK);
                                this.twitter.addActionListener(foo);
                                this.twitter.setActionCommand(TWITTER);
                                this.instagram.addActionListener(foo);
                                this.instagram.setActionCommand(INSTAGRAM);
                        
                        try {
                             for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                 if ("Nimbus".equals(info.getName())) {
                                 UIManager.setLookAndFeel(info.getClassName());
                             break;
                                 }
                               }
                         } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
    
                                         }
			
                        c = this.getContentPane();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			int larghezza = 800; // Poi dovrà diventare una costante globale
			setMinimumSize(new Dimension(larghezza, 600));
			
			BorderLayout lay = new BorderLayout();
			c.setLayout(lay);
			header.setPreferredSize(new Dimension(larghezza,100)); // Creo i pannelli fissi
			footer.setPreferredSize(new Dimension(larghezza, 100));

			c.add(header, BorderLayout.NORTH);
			c.add(content, BorderLayout.CENTER);
			//c.add(footer, BorderLayout.SOUTH);
			header.setBackground(Color.white);
			footer.setBackground(Color.LIGHT_GRAY);


			
			// Creazione del layout per i pannelli.
			GridBagLayout l = new GridBagLayout();
			GridBagConstraints j = new GridBagConstraints();
			GridBagConstraints q = new GridBagConstraints();
			footer.setLayout(l);
			header.setLayout(l);
			
			// CREAZIONE DEL CONTENT
			BorderLayout bord = new BorderLayout();
			content.setLayout(bord);

			// Setto i componenti del footer.
			
			q.insets.top=10;
			q.insets.bottom=10;
			q.insets.right=10;
			q.insets.left=10;
			q.weightx=1;
			q.weighty=1;
			q.fill= GridBagConstraints.NONE;
			footer.add(follow, q);
			footer.add(facebook, q);
			footer.add(twitter, q);
			footer.add(instagram, q);
			
			// Setto i componenti dell'header.
			
			
			j.weightx=1;
			j.weighty=1;
			j.fill = GridBagConstraints.NONE;
			header.add(logo, j);
                        j.insets.top=10;
			j.insets.bottom=10;
			j.insets.right=10;
			j.insets.left=10;
			header.add(intestazione, j);
			header.add(utente, j);
			
			
	}
                
            public void setUtente(String name) {
                    this.utente.setText(name);
                 }   


	}



