import java.util.Scanner;

public class Sudoku {
    public static char matriz[][] = new char[3][3];

    public static void main(String[] args) {
        int numeroDeJogadas = 0;
        char resultado = ' ';
        inicializaMatriz();
        do {
            imprimeMatriz();
            jogadaDoUsuario(1, 'X');
            numeroDeJogadas++;
            resultado = verificaVencedor();
            // Verifica se o jogador 1 venceu ou se já foram 9 jogadas
            if (resultado == 'X' || numeroDeJogadas == 9)
                break;
            imprimeMatriz();
            jogadaDoUsuario(2, 'O');
            numeroDeJogadas++;
            resultado = verificaVencedor();
            // Verifica se o jogador 2 venceu
            if (resultado == 'O')
                break;
        } while ((resultado == ' ') && (numeroDeJogadas != 9));
        imprimeMatriz();
        if (resultado == 'X')
            System.out.println("Jogador 1 ganhou!");
        else if (resultado == 'O')
            System.out.println("Jogador 2 ganhou!");
        else
            System.out.println("O jogo empatou!!!");
    }

    public static void inicializaMatriz() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matriz[i][j] = ' ';
    }

    public static void imprimeMatriz() {
        for (int i = 0; i < 3; i++) {
            System.out.printf(" %c | %c | %c ",
                    matriz[i][0], matriz[i][1], matriz[i][2]);
            if (i != 2)
                System.out.printf("\n---|---|---\n");
        }
        System.out.printf("\n");
    }

    public static void jogadaDoUsuario(int usuario, char simbolo) {
        Scanner input = new Scanner(System.in);
        boolean verificaJogada = false;
        int jogadaLinha;
        int jogadaColuna;

        do {
            System.out.printf("\nEscolha a linha sua jogada ENTRE 0 e 2:");
            jogadaLinha = input.nextInt();

            System.out.printf("\nEscolha a coluna da sua jogada ENTRE 0 e 2:");
            jogadaColuna = input.nextInt();

            if (jogadaColuna < 0 || jogadaLinha > 2) {
                System.out.println("Informe uma posição válida");
            } else if (matriz[jogadaLinha][jogadaColuna] == ' ') {
                matriz[jogadaLinha][jogadaColuna] = simbolo;
                verificaJogada = true;
            } else {
                System.out.println("\nPosição inválida. Tente novamente!");
            }
        } while (!verificaJogada == true);

    }

    public static char verificaVencedor() {
        // Verifica as linhas
        for (int i = 0; i < 3; i++)
            if (matriz[i][0] == matriz[i][1] && matriz[i][0] == matriz[i][2])
                return matriz[i][0];
        // Verifica as colunas
        for (int i = 0; i < 3; i++)
            if (matriz[0][i] == matriz[1][i] && matriz[0][i] == matriz[2][i])
                return matriz[0][i];
        // Verifica diagonais
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2])
            return matriz[0][0];
        if (matriz[2][0] == matriz[1][1] && matriz[1][1] == matriz[0][2])
            return matriz[0][2];
        // Se não encontrou vencedor, retorna "espaço"
        return ' ';
    }
}