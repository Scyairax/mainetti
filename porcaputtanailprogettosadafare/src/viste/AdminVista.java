/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viste;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import modello.Pannelli.AdminPannelli;

/**
 *
 * @author kingu
 */
public class AdminVista extends Finestra{
    
    private final AdminPannelli pan = new AdminPannelli(this);
    private final JPanel pCalendario = pan.GetPanelloCalendario();
    private final JPanel pGestIsc = pan.GetPanelloIscritti();
    private final JPanel pGestPay = pan.GetPanelloPay();
    private final JPanel pAttivita = pan.GetPanelloActivity();

    public AdminVista(String Nome) {
                content.add(pan.GetPanelloGuida(), BorderLayout.WEST);
		content.add(pGestPay, BorderLayout.CENTER);
		this.setUtente(Nome);
                repaint();
                revalidate();
	}
        
     public AdminPannelli getPan() {
		return pan;
    }
     
     public JPanel getpCalendario() {
        return pCalendario;
    }

    public JPanel getpGestIsc() {
        return pGestIsc;
    }

    public JPanel getpGestPay() {
        return pGestPay;
    }

    public JPanel getpAttivita() {
        return pAttivita;
    }
    }
    
    
    

