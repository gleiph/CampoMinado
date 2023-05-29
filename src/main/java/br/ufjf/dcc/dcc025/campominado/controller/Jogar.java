/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.dcc025.campominado.controller;

import br.ufjf.dcc.dcc025.campominado.Casa;
import br.ufjf.dcc.dcc025.campominado.Tabuleiro;
import br.ufjf.dcc.dcc025.campominado.model.CampoMinado;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author gleip
 */
public class Jogar implements MouseListener {

    private final CampoMinado campo;
    private final Tabuleiro tabuleiro;


    public Jogar(CampoMinado campo, Tabuleiro tabuleiro) {
        this.campo = campo;
        this.tabuleiro = tabuleiro;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Casa casa = (Casa) me.getSource();

        if (SwingUtilities.isRightMouseButton(me)) {

            if (casa.getText().equals("")) {
                casa.setText("F");
                casa.setForeground(Color.BLUE);
                casa.setIcon(null);
            } else if (casa.getText().equals("F")) {
                casa.setText("");
                casa.setForeground(Color.RED);
            }

        } else if (!casa.getText().equals("F")) {
            if (campo.isBomba(casa.getLinha(), casa.getColuna())) {
                ImageIcon bomb = new ImageIcon("images"+File.separator+"bomb.png");
                Image resizedImage = getScaledImage(bomb.getImage(), casa.getWidth() - 1, casa.getHeight() - 1);
                bomb.setImage(resizedImage);
                casa.setText("");
                tabuleiro.mostrarBombas(bomb);
                
                casa.setForeground(Color.RED);

                JOptionPane.showMessageDialog(tabuleiro, "Você perdeu!");
            } else {
                casa.setText("" + campo.bombasRedor(casa.getLinha(), casa.getColuna()));
                casa.setForeground(Color.BLACK);
                try {
                    campo.marcarPosicao(casa.getLinha(), casa.getColuna());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(tabuleiro, "Você perdeu!");
                }

                if(campo.venceu())
                    JOptionPane.showMessageDialog(tabuleiro, "Você venceu!");

            }
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
