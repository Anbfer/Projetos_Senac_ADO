import java.util.*;

public class CaminhoMinado {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Random random = new Random();

        int tamanhoCaminho, qtdBombas, escolhaCasa, controle, pontos = 0;

        System.out.printf("Informe o tamanho do caminho: ");
        tamanhoCaminho = src.nextInt();
        while (tamanhoCaminho <= 0) {
            System.out.printf("Informe o tamanho do caminho: ");
            tamanhoCaminho = src.nextInt();
        }

        int caminho[] = new int[tamanhoCaminho];

        String[] caminhoMascara = new String[caminho.length];

        String[] caminhoMascaraControle = new String[caminho.length];

        System.out.printf("Informe a quantidade de bombas: ");
        qtdBombas = src.nextInt();

        int controlePontos = caminho.length - qtdBombas;

        while (qtdBombas < 0 || qtdBombas >= tamanhoCaminho) {
            if ((qtdBombas - tamanhoCaminho) == 0) {
                System.out.printf(
                        "O numero de bombas é o mesmo numero de casas, jogo impossível.%nInforme um novo número: ");
                qtdBombas = src.nextInt();
            } else {
                System.out.printf("Informe a quantidade de bombas: ");
                qtdBombas = src.nextInt();
            }
        }

        controle = 0;

        for (int i = 0; i < caminho.length; i++) {
            caminho[i] = 0;
        }
        for (int i = 0; i < caminhoMascara.length; i++) {
            caminhoMascara[i] = "_";
        }
        for (int i = 0; i < caminhoMascaraControle.length; i++) {
            caminhoMascaraControle[i] = "_";
        }

        while (controle != qtdBombas) {
            int indxRdn = random.nextInt(caminho.length);
            if (caminho[indxRdn] == 0) {
                caminho[indxRdn] = -1;
                controle++;
                caminhoMascara[indxRdn] = "B";
            }
        }

        System.out.println("Caminho: " + Arrays.toString(caminhoMascaraControle));

        do {
            System.out.println("Escolha uma casa entre 0 e " + (caminho.length - 1));
            escolhaCasa = src.nextInt();
            if (caminho[escolhaCasa] == 0) {

                pontos++;

                System.out.println("Você ganhou 1 ponto");

                caminho[escolhaCasa] = 1;
                caminhoMascara[escolhaCasa] = "X";
                caminhoMascaraControle[escolhaCasa] = "X";

                System.out.println("Caminho: " + Arrays.asList(caminhoMascaraControle));

                try {
                    if (caminhoMascara[escolhaCasa - 1].equalsIgnoreCase("B")
                            || caminhoMascara[escolhaCasa + 1].equalsIgnoreCase("B")) {
                        System.out.println("BOMBA PRÓXIMA");
                    }
                } catch (Exception e) {
                    escolhaCasa -= 2;
                }

            } else {
                System.out.println("Você pisou numa mina, fim de jogo");
                caminhoMascaraControle[escolhaCasa] = "B";
                break;
            }
        } while (pontos != controlePontos);

        if (pontos == controlePontos) {
            System.out.println("Você atingiu a pontuação máxima de: " + controlePontos);
            System.out.println("Caminho: " + Arrays.asList(caminhoMascara));
        } else {
            System.out.println("Sua pontuação: " + pontos);
            System.out.println("Caminho: " + Arrays.asList(caminhoMascara));
        }
    }
}