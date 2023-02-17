import java.util.Scanner;

public class Sudoku {
    public static int vetorDeSudokus[][][] = { { { 1, 2, 3, 4 },
            { 4, 3, 2, 1 },
            { 3, 4, 1, 2 },
            { 2, 1, 4, 3 } },

            { { 2, 1, 4, 3 },
                    { 3, 4, 1, 2 },
                    { 1, 2, 3, 4 },
                    { 4, 3, 2, 1 } },

            { { 3, 4, 1, 2 },
                    { 2, 1, 4, 3 },
                    { 4, 3, 2, 1 },
                    { 1, 2, 3, 4 } },

            { { 4, 3, 1, 2 },
                    { 1, 2, 4, 3 },
                    { 3, 4, 2, 1 },
                    { 2, 1, 3, 4 } } };

    public static void main(String[] args) {
        int matrizDoSudoku[][] = new int[4][4];
        jogarSudoku(matrizDoSudoku);
    }

    public static void sorteiaSudoku(int matriz[][], int vetorDeMatrizes[][][]) {
        int t = (int) Math.random() * vetorDeMatrizes.length;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = vetorDeMatrizes[t][i][j];
            }
        }
    }

    public static void imprimeSudoku(int matriz[][]) {
        System.out.println("|---|---|---|---|");
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] == 0) {
                    System.out.print("   |");
                } else
                    System.out.print(" " + matriz[i][j] + " |");
            }
            System.out.println("\n|---|---|---|---|");
        }
    }

    public static void setaNivelDoSukoku(int n, int matriz[][]) {
        int i, j, contador = 0;
        switch (n) {
            case 1: // Nível fácil
                do {
                    i = (int) (Math.random() * 4);
                    j = (int) (Math.random() * 4);
                    if (matriz[i][j] != 0) {
                        matriz[i][j] = 0;
                        contador++;
                    }
                } while (contador < 4);
                break;
            case 2: // Nível médio
                do {
                    i = (int) (Math.random() * 4);
                    j = (int) (Math.random() * 4);
                    if (matriz[i][j] != 0) {
                        matriz[i][j] = 0;
                        contador++;
                    }
                } while (contador < 8);
                break;
            case 3: // Nível difícil
                do {
                    i = (int) (Math.random() * 4);
                    j = (int) (Math.random() * 4);
                    if (matriz[i][j] != 0) {
                        matriz[i][j] = 0;
                        contador++;
                    }
                } while (contador < 12);
                break;
            default:
                System.out.println("Opções válidas: 1 (fácil), 2 (médio) e 3 (difícil)");
        }
    }

    public static boolean verificaSudoku(int matriz[][]) {
        // Verifica linhas
        for (int i = 0; i < 4; i++)
            if ((matriz[i][0] + matriz[i][1] + matriz[i][2] + matriz[i][3]) != 10)
                return false;
        // Verifica colunas
        for (int j = 0; j < 4; j++)
            if ((matriz[0][j] + matriz[1][j] + matriz[2][j] + matriz[3][j]) != 10)
                return false;
        // Verifica submatriz
        if ((matriz[0][0] + matriz[0][1] + matriz[1][0] + matriz[1][1]) != 10)
            return false;
        // Verifica submatriz
        if ((matriz[0][2] + matriz[0][3] + matriz[1][2] + matriz[1][3]) != 10)
            return false;
        // Verifica submatriz
        if ((matriz[2][0] + matriz[2][1] + matriz[3][0] + matriz[3][1]) != 10)
            return false;
        // Verifica submatriz
        if ((matriz[2][2] + matriz[2][3] + matriz[3][2] + matriz[3][3]) != 10)
            return false;
        return true;
    }

    public static void jogarSudoku(int matriz[][]) {
        Scanner input = new Scanner(System.in);
        int dificuldade;
        int contador = 0;
        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1 - fácil\n2 - médio\n3 - difícil");
        dificuldade = input.nextInt();
        if (dificuldade == 3) {
            contador = 12;
        } else if (dificuldade == 2){
            contador = 8;
        } else {
            contador = 4;
        }
        sorteiaSudoku(matriz, vetorDeSudokus);
        setaNivelDoSukoku(dificuldade, matriz);
        imprimeSudoku(matriz);
        
        do {
            System.out.printf("Escolha a coluna entre 0 e 3:\n");
            int escolha_coluna = input.nextInt();
            System.out.printf("Ecolha a linha da jogada entre 0 e 3:\n");
            int escolha_linha = input.nextInt();
            if (matriz[escolha_linha][escolha_coluna] != 0) {
                System.out.println("\nLinha ocupada\n");
            } else {
                System.out.printf("\nInforme o número de 0-4 a ser colocado na coluna %d linha %d:\n", escolha_coluna, escolha_linha);
                int numero_casa = input.nextInt();
                while (numero_casa == 0) {
                    System.out.println("Você não pode escolher o número 0, escolha um número válido");
                    numero_casa = input.nextInt();
                }
                contador--;
                matriz[escolha_linha][escolha_coluna] = numero_casa;
                imprimeSudoku(matriz);
            }

        } while (contador != 0);
        if (!verificaSudoku(matriz)) {
            System.out.println("A solução está incorreta");
        } else {
            System.out.println("Parabéns, a solução do Sudoku está correta!");
        }
    }
}