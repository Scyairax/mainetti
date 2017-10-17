/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author kingu
 * Si ringrazia l'utente Zilarion della piattaforma stacckoverlow dal quale si è copiato,
 * per filo e per segno, il codice di questa classe.
 * Grazie.
 */


public class OpenWebPage {
    
    
 
   
   public static void openPage(String url){
   try {         
     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
   }
   catch (java.io.IOException e) {
       System.out.println(e.getMessage());
   }
}
    
}
