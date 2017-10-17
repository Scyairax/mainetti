/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viste.GuestVista;
import static costanti.CostantiGuest.*;

/**
 *
 * @author kingu
 */
public class GuestListener implements ActionListener{
    
    GuestVista g;
    public GuestListener(GuestVista g) {
        this.g = g;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String get = e.getActionCommand();
        BorderLayout b = (BorderLayout) g.content.getLayout();
        switch(get) {
        
            case Guest_Act : {
                g.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
                g.content.add(g.getpActivita(), BorderLayout.CENTER);
                g.repaint();
                g.revalidate();
                break;
            }
            
            case Guest_Cal : {
                g.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
                g.content.add(g.getpCalendar(), BorderLayout.CENTER);
                g.repaint();
                g.revalidate();
                break;
            }
            
            case Guest_Reg : {
                g.content.remove(b.getLayoutComponent(BorderLayout.CENTER));
                g.content.add(g.getpRegister(), BorderLayout.CENTER);
                g.repaint();
                g.revalidate();
                break;
            }
        
        }
        
    }
    
    
    
}
