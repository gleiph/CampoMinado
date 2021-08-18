package br.ufjf.dcc.dcc025.campominado.model;

/**
 *
 * @author gleip
 */
public class CampoMinado {

    private final int[][] campo;
    private final int ordem;
    private final int bombas;

    public CampoMinado(int ordem, int bombas) {
        this.campo = new int[ordem][ordem];
        this.ordem = ordem;
        this.bombas = bombas;
    }

    public void inicia() {
        int contadorBombas = 0;

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                campo[i][j] = 0;
            }
        }

        int x, y;

        while (contadorBombas < this.bombas) {

            x = (int) (Math.random() * this.ordem);
            y = (int) (Math.random() * this.ordem);

            if (campo[x][y] == 0) {
                campo[x][y] = 1;
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
            return this.campo[x][y];
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

    public static void main(String[] args) {
        CampoMinado c = new CampoMinado(10, 50);
        System.out.println("Campo inicial");
        c.imprimeCampo();
        System.out.println("Sorteio");
        c.inicia();
        System.out.println("Campo final");
        c.imprimeCampo();
        System.out.println("Campo final(Contador bombas)");
        c.imprimeCampoBombas();
    }
    
}
