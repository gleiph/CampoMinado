/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.dcc025.campominado;

import javax.swing.JButton;

/**
 *
 * @author gleip
 */
public class Casa extends JButton{

    private boolean bomba;
    
    public Casa(boolean bomba) {
        this.bomba = bomba;
    }

    public boolean isBomba() {
        return bomba;
    }

    public void setBomba(boolean bomba) {
        this.bomba = bomba;
    }
    
}
