/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viste;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import modello.Pannelli.GuestPannelli;

/**
 *
 * @author kingu
 */
public class GuestVista extends Finestra {
    
    
    private final GuestPannelli pan  = new GuestPannelli(this);
    private final JPanel pRegister = pan.GetPanelloRegister();
    private final JPanel pActivita = pan.GetPanelloActivity();
    private final JPanel pCalendar = pan.GetPanelloCalendario();

    
    
    
    public GuestVista(String Nome) {
		content.add(pan.GetPanelloGuida(), BorderLayout.WEST);
		content.add(pan.GetPanelloCalendario(), BorderLayout.CENTER);
		this.setUtente(Nome);
                super.c.add(footer, BorderLayout.SOUTH);
                repaint();
                revalidate();
	}
    public GuestPannelli getPan() {
		return pan;
	}
    
    public JPanel getpRegister() {
        return pRegister;
    }

    public JPanel getpActivita() {
        return pActivita;
    }

    public JPanel getpCalendar() {
        return pCalendar;
    }
}
