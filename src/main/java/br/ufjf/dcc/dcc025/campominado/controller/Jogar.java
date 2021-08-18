package br.ufjf.dcc.dcc025.campominado.controller;

import br.ufjf.dcc.dcc025.campominado.Casa;
import br.ufjf.dcc.dcc025.campominado.model.CampoMinado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gleip
 */
public class Jogar implements ActionListener {

    private final CampoMinado campo;

    public Jogar(CampoMinado campo) {
        this.campo = campo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Casa casa = (Casa) ae.getSource();

        if (campo.isBomba(casa.getLinha(), casa.getColuna())) {
            casa.setText("B");
        } else {
            casa.setText(""+campo.bombasRedor(casa.getLinha(), casa.getColuna()));
        }

    }

}
