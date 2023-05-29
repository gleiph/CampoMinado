/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.dcc025.campominado;

import br.ufjf.dcc.dcc025.campominado.controller.Jogar;
import br.ufjf.dcc.dcc025.campominado.model.CampoMinado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gleip
 */
public class Tabuleiro extends JFrame{
    
    public static final int ORDEM = 3;
    public static final int BOMBAS = 2;
    
    private JPanel painel;
    private CampoMinado campo;
    
    

    public Tabuleiro() {
        this.painel = new JPanel();
        campo = new CampoMinado(ORDEM, BOMBAS);
        campo.inicia();
        campo.imprimeCampo();
    }
    
    
    
    public void desenha(){
        
        painel.setLayout(new GridLayout(ORDEM, ORDEM));
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                Casa casa = new Casa(campo.isBomba(i, j));
                casa.setLinha(i);
                casa.setColuna(j);
                
//                casa.addActionListener(new Jogar(campo));
                casa.addMouseListener(new Jogar(campo, this));
                
                casa.setPreferredSize(new Dimension(50, 50));
                casa.setBorder(BorderFactory.createLineBorder(Color.black));
                painel.add(casa);
            }
        }
        
        this.add(painel);
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.repaint();
        this.pack();
    }
    
    
    public void mostrarBombas(Icon icon){
        for (Component component : painel.getComponents()) {
            if(component instanceof Casa){
                Casa casa = (Casa) component;
                if(casa.isBomba()){
                    casa.setIcon(icon);
                    casa.setText("");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.desenha();
    }
    
}
