/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Pannelli.Popup;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import listeners.AdminListener;
import static costanti.CostantiAdmin.*;
import java.awt.Container;

/**
 *
 * @author kingu
 */

public class PopUp {
    private AdminListener list;

    public PopUp(ActionListener list) {
        this.list = (AdminListener) list;
    }
    
    
    // POP-UP PER IL FORM DI INSERIMENTO DI DISCIPLINA - ADMINPANNELLI
    
     public JFrame Popdisci(){
            JFrame pop = new JFrame();
            Container c = pop.getContentPane();
            JLabel disciplina = new JLabel ("Inserisci la nuova disciplina");
            JTextField fdisciplina = new JTextField(8);
            JLabel area = new JLabel ("Scegli l'area di competenza");
            JComboBox combo = new JComboBox(AREE);
            JButton conferma = new JButton("Conferma");
            
            //Action listener
            conferma.addActionListener(list);
            conferma.setActionCommand(ADD_DISCIPLINE);
            
            // Setto il layout.
            pop.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            // Gestione grafica.
        
            gbc.insets.bottom=10;
            gbc.insets.left=10;
            gbc.insets.right=10;
            gbc.insets.top=10;
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.fill= GridBagConstraints.NONE;
		
            gbc.gridx=0;
            gbc.gridy=0;
            c.add(disciplina, gbc);
            gbc.gridx++;
            c.add(fdisciplina, gbc);
            gbc.gridy++;
            gbc.gridx=0;
            c.add(area, gbc);
            gbc.gridx++;
            c.add(combo, gbc);
            gbc.gridy++;
            gbc.gridx=0;
            c.add(conferma, gbc);
            gbc.gridx++;
            
        
        pop.setVisible(true);
        pop.pack();
        return pop;
                
    }
    
    // POP-UP PER L'INSERIMENTO DI NUOVI LIVELLI - ADMINPANNELLI
     
      public JFrame Poplvl(){
            JFrame pop = new JFrame();
            Container c = pop.getContentPane();
            JLabel disciplina = new JLabel ("Inserisci il nuovo livello");
            JTextField fdisciplina = new JTextField(8);
            JButton conferma = new JButton("Conferma");
            //Action listener
            conferma.addActionListener(list);
            conferma.setActionCommand(ADD_LEVEL);
            // Setto il layout.
            pop.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            // Gestione grafica.
        
            gbc.insets.bottom=10;
            gbc.insets.left=10;
            gbc.insets.right=10;
            gbc.insets.top=10;
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.fill= GridBagConstraints.NONE;
		
            gbc.gridx=0;
            gbc.gridy=0;
            c.add(disciplina, gbc);
            gbc.gridx++;
            c.add(fdisciplina, gbc);
            gbc.gridy++;
            gbc.gridx=0;
            gbc.gridy++;
            gbc.gridx=0;
            c.add(conferma, gbc);
            gbc.gridx++;
            
        
        pop.setVisible(true);
        pop.pack();
        return pop;
                
    }
    
}
