/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static costanti.CostantiFooter.*;
import business.OpenWebPage;

/**
 *
 * @author kingu
 */
public class FooterListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
     String get = e.getActionCommand();
     
     switch (get) {
     
         case FACEBOOK : {
             OpenWebPage.openPage("https://it-it.facebook.com/");
             break;
         }
         
         case TWITTER :  {
             OpenWebPage.openPage("https://twitter.com/login?lang=it");
             break;
         }
         
         
         case INSTAGRAM:  {
             OpenWebPage.openPage("https://www.instagram.com/?hl=it");
             break;     
         }    
     }
     
    }
    
}
