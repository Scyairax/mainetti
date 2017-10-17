/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viste;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import modello.Pannelli.IstruttorePannelli;

/**
 *
 * @author kingu
 */
public class IstruttoreViste extends Finestra {
    
    private final IstruttorePannelli pan = new IstruttorePannelli(this);
    private  JPanel pannelloattività = pan.GetPanelloActivity();        // Necessito di un puntatore ai
    private JPanel pannellocalendario = pan.GetPanelloCalendario();     // Vari pannelli, sennò un cazzo funziona!

    public JPanel getPannellocalendario() {
        return pannellocalendario;
    }

   
    
    public IstruttoreViste(String Nome){
       
        content.add(pan.GetPanelloGuida(), BorderLayout.WEST);
        content.add(pannelloattività, BorderLayout.CENTER);
        this.setUtente(Nome);
        repaint();
        revalidate();
        
    }

    
    public IstruttorePannelli getPan() {
		return pan;
	}
    
     public JPanel getPannelloAttivita() {
        return pannelloattività;
    }

}
