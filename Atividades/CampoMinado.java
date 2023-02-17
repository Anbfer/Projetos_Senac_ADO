import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class CampoMinado {
    // obrigatóriamente um método para imprimir o campo/matriz com máscaras
    /*
     * obrigatóriamente um método para receber as cordenadas e retornar true se
     * tiver uma ou mais bombas ao redor false caso contrário
     */

    public static int entradaUser() {
        // entrada usuário;
        Scanner src = new Scanner(System.in);
        int entrada = src.nextInt();
        return entrada;
    }

    public static int[][] criaMatriz(int largura, int altura) {
        // função que cria o vetor e preenche com O's
        // altura representa o número de linhas, largura representa o número de colunas
        int[][] campo = new int[altura][largura];

        for (int i = 0; i < campo.length; i++) {// => preenche o array com 0's
            for (int j = 0; j < campo[0].length; j++) {
                campo[i][j] = 0;
            }
        }

        return campo;
    }

    public static int[][] posicionaBombas(int[][] campo, int qtdBombas) {

        // => posiciona as bombas dentro do vetor
        Random random = new Random();
        Scanner src = new Scanner(System.in);

        int controle = 0;

        while (qtdBombas != controle) {
            int aleatorioL = random.nextInt(campo.length);
            int aleatorioA = random.nextInt(campo[0].length);
            if (campo[aleatorioL][aleatorioA] == 0) {
                campo[aleatorioL][aleatorioA] = -1;
                controle++;
            }
        }

        return campo;
    }

    public static String[][] mascaraCampoMinado(int[][] campo) {

        // => Cria um array identico para ser a máscara

        String[][] mascaraCampo = new String[campo.length][campo[0].length];

        for (int i = 0; i < mascaraCampo.length; i++) {// => preenche a mascara com "_"
            for (int j = 0; j < mascaraCampo[0].length; j++) {
                mascaraCampo[i][j] = "_";
                if (campo[i][j] == -1) {
                    mascaraCampo[i][j] = "B";
                }
            }
        }

        return mascaraCampo;
    }

    public static String[][] mascaraCampoControle(int[][] campo) {
        // => máscara que se modifica a cada interação com o usuário;

        String[][] mascaraCampoControle = new String[campo.length][campo[0].length];

        for (int i = 0; i < mascaraCampoControle.length; i++) {
            for (int j = 0; j < mascaraCampoControle[0].length; j++) {
                mascaraCampoControle[i][j] = "_";
            }
        }
        return mascaraCampoControle;
    }

    public static void imprimeArray(String[][] campo) {

        for (String[] linhas : campo) {
            System.out.println(Arrays.toString(linhas));
        }
    }

    public static void explosao() {
        System.out.println("       --_--        ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("    (  -_    _).    ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("  ( ~       )   )   ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("(( )  (    )  ()  ) ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(" (.   )) (       )  ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("   ``..     ..``    ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("        | |         ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("      (=| |=)       ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("        | |         ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("    (...( )...)     ");
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static boolean detecta_mina(int[][] campo, int coordenadaL, int coordenadaA) {

        boolean tembomba = false;

        int largura_total = (campo.length - 1);
        int altura_total = (campo[0].length - 1);


        return tembomba;

    }



    public static void jogo() {
        // => passa o conjunto de regras do jogo, as entradas e as principais Matrizes

        boolean pisou_na_mina = false;
        int largura, altura, bombas;

        System.out.printf("Informe a largura do Campo Minado: ");
        largura = entradaUser();
        while (largura <= 1) {
            System.out.println("A largura do campo precisa ser maior ou igual a 2");
            largura = entradaUser();
        }

        System.out.printf("Informe a Altura do Campo Minado: ");
        altura = entradaUser();
        while (altura <= 1) {
            System.out.println("A altura do campo precisa ser maior ou igual a 2");
            altura = entradaUser();
        }

        int[][] campoMinado = criaMatriz(largura, altura);

        System.out.printf("Informe a quantidade de Bombas: ");
        bombas = entradaUser();
        while (bombas <= 0 || bombas >= (campoMinado.length * campoMinado[0].length)) {
            System.out.println(
                    "O numero de bombas precisa ser maior ou igual a 1 e menor que o número de casas do campo");
            bombas = entradaUser();
        }
        int[][] posicionaBombas = posicionaBombas(campoMinado, bombas);
        String[][] mascaraCampo = mascaraCampoMinado(posicionaBombas);
        String[][] mascaraControle = mascaraCampoControle(posicionaBombas);

        int pontos = 0, controleBombas = (posicionaBombas.length * posicionaBombas[0].length) - bombas;

       // imprimeArray(mascaraCampo);
        imprimeArray(mascaraControle);

        int entradaL, entradaA;

        do {
            System.out.printf("\nEscolha a Linha entre 0 e %d: ", (campoMinado.length - 1));
            entradaL = entradaUser();
            while (entradaL > (campoMinado.length - 1) || entradaL < 0) {
                System.out.println("A linha não pode ser menor que 0 ou maior que " + (campoMinado.length - 1));
                entradaL = entradaUser();
            }

            System.out.printf("\nEscolha a Coluna entre 0 e %d: ", (campoMinado[0].length - 1));
            entradaA = entradaUser();
            while (entradaA > (campoMinado[0].length - 1) || entradaA < 0) {
                System.out.println("A Coluna não pode ser menor que 0 ou maior que " + (campoMinado[0].length - 1));
                entradaL = entradaUser();
            }

            if (posicionaBombas[entradaL][entradaA] == 0) {
                pontos++;
                System.out.println("\nVocê ganhou um ponto!\n");
                if (detecta_mina(campoMinado, entradaL, entradaA) == true) {
                    System.out.println("Bomba Próxima");
                }
                posicionaBombas[entradaL][entradaA] = 1;
                mascaraCampo[entradaL][entradaA] = "X";
                mascaraControle[entradaL][entradaA] = "X";
                imprimeArray(mascaraControle);

            } else if (posicionaBombas[entradaL][entradaA] == 1) {
                System.out.println("Você ja escolheu essa casa, escolha outra casa\n");
                imprimeArray(mascaraControle);
            } else {
                System.out.println("Você pisou numa mina!");
                explosao();
                System.out.println("    _GAME OVER_\n");
                imprimeArray(mascaraCampo);
                System.out.printf("Pontuação: %d", pontos);
                pisou_na_mina = true;

                break;
            }

        } while (pontos != controleBombas);
        if (pisou_na_mina == false) {
            System.out.println("Você ganhou!");
            imprimeArray(mascaraCampo);
            System.out.printf("Pontuação: %d", pontos);
        }
    }

    public static void main(String[] args) {
        jogo();
    }
}
