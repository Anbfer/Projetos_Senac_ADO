import java.util.*;

public class AdivinheNumero {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Random aleatorio = new Random();

        int chute, resto, chutes = 5, numeroDaSorte = aleatorio.nextInt(100) + 1;

        boolean acertou = false;

        String enunciado = "Informe seu chute: ";

        while (chutes > 0) {
            System.out.println(enunciado);
            chute = input.nextInt();
            chutes--;
            resto = chute % numeroDaSorte;
            String chances = "Você tem mais: " + chutes + " chance(s)";

            if (chute == numeroDaSorte) {
                System.out.printf("PARABÉNS, VOCÊ GANHOU O JOGO!");
                acertou = true;
                break;
            }
            if (chute > numeroDaSorte && resto == 1) {
                System.out.printf("Tá quente, seu chute foi maior que o número sorteado.%n%s%n", chances);
            } else if (chute > numeroDaSorte) {
                System.out.printf("Seu chute foi maior que o número sorteado.%n%s%n", chances);
            }
            if (resto != 1) {
                resto = chute % (numeroDaSorte - 2);
                if (chute < numeroDaSorte && resto == 1) {
                    System.out.printf("Tá quente, seu chute foi menor que o número sorteado.%n%s%n", chances);
                } else if (chute < numeroDaSorte) {
                    System.out.printf("Seu chute foi menor que o número sorteado.%n%s%n", chances);
                }
            }
        }
        if (chutes == 0 && acertou == false) {
            System.out.printf("Suas chances acabaram%nGAME OVER!");
            System.out.printf("O número sorteado era: %d", numeroDaSorte);
        }
    }
}
