package br.ufjf.dcc.dcc025.campominado.model;

/**
 *
 * @author gleip
 */
public class CampoMinado {

    private final int[][] campo;
    private final int ordem;
    private final int bombas;

    private final int BOMBA = 1;
    private final int VAZIO = 0;
    private final int MARCADO = 2;

    public CampoMinado(int ordem, int bombas) {
        this.campo = new int[ordem][ordem];
        this.ordem = ordem;
        this.bombas = bombas;
    }

    public void inicia() {
        int contadorBombas = 0;

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                campo[i][j] = VAZIO;
            }
        }

        int x, y;

        while (contadorBombas < this.bombas) {

            x = (int) (Math.random() * this.ordem);
            y = (int) (Math.random() * this.ordem);

            if (campo[x][y] == 0) {
                campo[x][y] = BOMBA;
                contadorBombas++;
            }
        }

    }

    public void imprimeCampo() {

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.print(campo[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void imprimeCampoBombas() {

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                if (campo[i][j] == 1) {
                    System.out.print("B ");
                } else {
                    System.out.print(bombasRedor(i, j) + " ");
                }
            }
            System.out.println("");
        }
    }

    private int valorCampo(int x, int y) {
        try {
            return this.campo[x][y]==1?1:0;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public int bombasRedor(int x, int y) {
        int contadorBombas = 0;

        contadorBombas += valorCampo(x - 1, y - 1);
        contadorBombas += valorCampo(x - 1, y);
        contadorBombas += valorCampo(x - 1, y + 1);

        contadorBombas += valorCampo(x, y - 1);
        contadorBombas += valorCampo(x, y + 1);

        contadorBombas += valorCampo(x + 1, y - 1);
        contadorBombas += valorCampo(x + 1, y);
        contadorBombas += valorCampo(x + 1, y + 1);

        return contadorBombas;
    }
    
    public boolean isBomba(int x, int y){
        if(campo[x][y] == 1)
            return true;
        else
            return false;
    }

    public boolean venceu(){
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                if(campo[i][j] == VAZIO)
                    return false;
            }
        }
        return true;
    }

    public void marcarPosicao(int x, int y) throws Exception {
        if(isBomba(x, y))
            throw  new Exception("Posição possui bomba!");

        campo[x][y] = MARCADO;

    }

    
}
