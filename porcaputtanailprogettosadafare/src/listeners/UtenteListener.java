 package listeners;
import static costanti.CostantiUtente.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import viste.UserVista;

public class UtenteListener implements ActionListener{

	 UserVista user;
         static  JPanel iscritti;
	 public  UtenteListener(UserVista user) {
		this.user=user;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String get = e.getActionCommand();
		BorderLayout b = (BorderLayout) user.content.getLayout();    // Mi da errore nullpointerexeption
		switch (get) {
		
			case UTENTE_ATTIVITY : {
					user.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
					user.content.add(user.getpActivita(), BorderLayout.CENTER);
					user.repaint();
					user.revalidate();
					break;
				                                                                                                                        
			}
			
			case UTENTE_CALENDARIO : {
				user.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
				user.content.add(user.getpCalendar(), BorderLayout.CENTER);
				user.repaint();
				user.revalidate();
				break;
			}
			
			case UTENTE_COMMENTI : {
				user.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
				user.content.add(user.getpComment(), BorderLayout.CENTER);
				user.repaint();
				user.revalidate();
				break;
			}
			
			case UTENTE_MYCORSI : {
				user.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
				user.content.add(user.getpCorsi(), BorderLayout.CENTER);
				user.repaint();
				user.revalidate();
				break;
			}
                        
                        case UTENTE_ISCRIZIONE : {
                                JButton butt = (JButton) e.getSource();
                                JPanel p = (JPanel) butt.getParent();
                                JLabel l = (JLabel) p.getComponent(0);
                                System.out.println(l.getText());
                                user.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
                                iscritti = user.getPan().GetPanelloIscritti(l.getText());
                                user.content.add(iscritti, BorderLayout.CENTER);
                                user.repaint();
				user.revalidate();
				break;


                        }
		}
		
	}

}
