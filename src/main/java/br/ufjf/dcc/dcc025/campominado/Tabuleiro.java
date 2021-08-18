/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.dcc025.campominado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gleip
 */
public class Tabuleiro extends JFrame{
    
    JPanel painel;
    public static final int ORDEM = 10;

    public Tabuleiro() {
        this.painel = new JPanel();
    }
    
    
    
    public void desenha(){
        
        painel.setLayout(new GridLayout(ORDEM, ORDEM));
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                Casa casa = new Casa(true);
                casa.setPreferredSize(new Dimension(50, 50));
                casa.setBorder(BorderFactory.createLineBorder(Color.black));
                painel.add(casa);
            }
        }
        
        this.add(painel);
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.pack();
    }
    
    
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.desenha();
    }
    
}