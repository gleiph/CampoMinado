/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.dcc025.campominado.controller;

import br.ufjf.dcc.dcc025.campominado.Casa;
import br.ufjf.dcc.dcc025.campominado.model.CampoMinado;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author gleip
 */
public class Jogar implements MouseListener {

    private final CampoMinado campo;

    public Jogar(CampoMinado campo) {
        this.campo = campo;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Casa casa = (Casa) me.getSource();

        if (SwingUtilities.isRightMouseButton(me)) {
            casa.setText("F");
        } else if (campo.isBomba(casa.getLinha(), casa.getColuna())) {
            casa.setText("B");
            JOptionPane.showMessageDialog(null, "Você perdeu!");
        } else {
            casa.setText("" + campo.bombasRedor(casa.getLinha(), casa.getColuna()));
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
