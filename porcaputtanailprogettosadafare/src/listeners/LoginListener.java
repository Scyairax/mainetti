package listeners;
import static costanti.CostantiLogin.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.ControllLogin;

import viste.LoginVista;


public class LoginListener implements ActionListener{

	 LoginVista login;
	 
	 //init
	 public  LoginListener(LoginVista login) {
		this.login=login;
	}
	//
	 
	 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nick = login.getUsr();
		char[] pass = login.getPass();
		
		
		String get = e.getActionCommand();
		
		switch (get) {
		
			
			case XXXXXX : {
				ControllLogin.openvista(nick, String.valueOf(pass));
							}
			}
	

}
}