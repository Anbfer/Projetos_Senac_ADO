import java.util.*;

public class multiplaEscolha {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Quais são os processos que definem um computador?");
        System.out.println("\nEscolha uma das opções abaixo:\n");
        System.out.println("<A> Processamento, Saida e Algoritimo ");
        System.out.println("<B> Algoritimo, Java e Eclipse");
        System.out.println("<C> Entrada, Processamento e Saída");
        System.out.println("<D> Começo, meio e fim");
        System.out.println("<E> Início, decisão e Fim");
        System.out.println("Qual é sua resposta:");
        String resposta = input.next();
        
        switch (resposta) {
            case "C":
            case "c":
                System.out.println("Resposta Correta!");
                break;
            default:
                System.out.println("\nSua resposta foi " + resposta + " e não é valida, tente novamente\n");
                main(args);
        }
    }
}
