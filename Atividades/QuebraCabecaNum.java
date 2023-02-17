import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuebraCabecaNum {

    public static int[][] cria_matrix() {
        int controle = 0;
        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = controle++;
            }
        }

        return matrix;
    }

    public static void mascara(int[][] matrix) {
        String[][] matrix_de_controle = new String[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix_de_controle.length; i++) {
            for (int j = 0; j < matrix_de_controle.length; j++) {
                if (matrix[i][j] == 1) {
                    matrix_de_controle[i][j] = "1";
                } else if (matrix[i][j] == 2) {
                    matrix_de_controle[i][j] = "2";
                } else if (matrix[i][j] == 3) {
                    matrix_de_controle[i][j] = "3";
                } else if (matrix[i][j] == 4) {
                    matrix_de_controle[i][j] = "4";
                } else if (matrix[i][j] == 5) {
                    matrix_de_controle[i][j] = "5";
                } else if (matrix[i][j] == 6) {
                    matrix_de_controle[i][j] = "6";
                } else if (matrix[i][j] == 7) {
                    matrix_de_controle[i][j] = "7";
                } else if (matrix[i][j] == 8) {
                    matrix_de_controle[i][j] = "8";
                } else {
                    matrix_de_controle[i][j] = " ";
                }
            }
        }

        for (String[] linha : matrix_de_controle) {
            System.out.println(Arrays.toString(linha));
        }
    }

    public static int[][] embaralhaMatrix(int[][] matrix) {
        Random aleatorio = new Random();

        // fisher-yates algorithm
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                int controle_l = aleatorio.nextInt(i + 1);
                int controle_a = aleatorio.nextInt(j + 1);

                int temp = matrix[i][j];
                matrix[i][j] = matrix[controle_l][controle_a];
                matrix[controle_l][controle_a] = temp;
            }
        }
        return matrix;
    }

    public static boolean matrizOrdenada(int[][] matrix) {
        boolean organizado = false;
        int[][] matrix_de_referencia = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };

        for (int i = 0; i < matrix_de_referencia.length; i++) {
            for (int j = 0; j < matrix_de_referencia[0].length; j++) {
                if (matrix[i][j] != matrix_de_referencia[i][j]) {
                    organizado = false;
                } else {
                    organizado = false;
                }
            }
        }

        return organizado;
    }

    public static int[][] movimenta_peca(int[][] matrix) {
        Scanner entrada = new Scanner(System.in);

        int[][] posicao_do_zero = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    posicao_do_zero[i][j] = 0;
                }
            }
        }

        do {
            System.out.printf("Escolha a peça que deseha mover a linha 0 e 2: ");
            int linha_saida = entrada.nextInt();
            System.out.printf("Escolha a peça que deseha mover entre a coluna 0 e 2: ");
            int coluna_saida = entrada.nextInt();

            while (linha_saida > 2 || coluna_saida > 2 || linha_saida < 0 || coluna_saida < 0) {
                System.out.printf("Escolha a peça que deseha mover a linha 0 e 2: ");
                linha_saida = entrada.nextInt();
                System.out.printf("Escolha a peça que deseha mover entre a coluna 0 e 2: ");
                coluna_saida = entrada.nextInt();
            }

            if (matrix[linha_saida][coluna_saida] == 0) {
                while (matrix[linha_saida][coluna_saida] == 0) {
                    System.out.println("você não pode escolher o espaço vazio");
                    System.out.printf("Escolha a peça que deseha mover a linha 0 e 2: ");
                    linha_saida = entrada.nextInt();
                    System.out.printf("Escolha a peça que deseha mover entre a coluna 0 e 2: ");
                    coluna_saida = entrada.nextInt();
                }
            }

            if (linha_saida > 0) {
                if (matrix[linha_saida - 1][coluna_saida] == 0) {
                    matrix[linha_saida - 1][coluna_saida] = matrix[linha_saida][coluna_saida];
                    matrix[linha_saida][coluna_saida] = 0;
                } else if (linha_saida < 2) {
                    if (matrix[linha_saida + 1][coluna_saida] == 0) {
                        matrix[linha_saida + 1][coluna_saida] = matrix[linha_saida][coluna_saida];
                        matrix[linha_saida][coluna_saida] = 0;
                    }
                }
            }
            if (coluna_saida > 0) {
                if (matrix[linha_saida][coluna_saida - 1] == 0) {
                    matrix[linha_saida][coluna_saida - 1] = matrix[linha_saida][coluna_saida];
                    matrix[linha_saida][coluna_saida] = 0;

                } else if (coluna_saida < 2) {
                    if (matrix[linha_saida][coluna_saida + 1] == 0) {
                        matrix[linha_saida][coluna_saida + 1] = matrix[linha_saida][coluna_saida];
                        matrix[linha_saida][coluna_saida] = 0;
                    }
                }
            }
            if (linha_saida == 0 && coluna_saida != 0) {
                if (matrix[linha_saida + 1][coluna_saida] == 0) {
                    matrix[linha_saida + 1][coluna_saida] = matrix[linha_saida][coluna_saida];
                } else if (coluna_saida < 2) {
                    if (matrix[linha_saida][coluna_saida + 1] == 0) {
                        matrix[linha_saida][coluna_saida + 1] = matrix[linha_saida][coluna_saida];
                        matrix[linha_saida][coluna_saida] = 0;
                    }
                }
            }
            if (coluna_saida == 0 && linha_saida != 0) {
                if (matrix[linha_saida][coluna_saida + 1] == 0) {
                    matrix[linha_saida][coluna_saida + 1] = matrix[linha_saida][coluna_saida];
                    matrix[linha_saida][coluna_saida] = 0;
                } else if (linha_saida < 2) {
                    if (matrix[linha_saida + 1][coluna_saida] == 0) {
                        matrix[linha_saida + 1][coluna_saida] = matrix[linha_saida][coluna_saida];
                        matrix[linha_saida][coluna_saida] = 0;
                    }
                }
            }

            if (linha_saida == 0 && coluna_saida == 0) {
                if (matrix[linha_saida + 1][coluna_saida] == 0) {
                    matrix[linha_saida + 1][coluna_saida] = matrix[linha_saida][coluna_saida];
                    matrix[linha_saida][coluna_saida] = 0;
                } else if (matrix[linha_saida][coluna_saida + 1] == 0) {
                    matrix[linha_saida][coluna_saida + 1] = matrix[linha_saida][coluna_saida];
                    matrix[linha_saida][coluna_saida] = 0;
                }
            }

            mascara(matrix);

        } while (matrizOrdenada(matrix) == false);

        return matrix;
    }

    public static void main(String[] args) {

        int[][] matrix = cria_matrix();
        int[][] matrix_embaralhada = embaralhaMatrix(matrix);
        mascara(matrix_embaralhada);
        movimenta_peca(matrix_embaralhada);
    }
}
