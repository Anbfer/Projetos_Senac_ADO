import java.util.*;

public class ExercicioUmAdo4 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um valor de 1 a 7");
        int diaDaSemana = input.nextInt();
        
        switch (diaDaSemana){
            case 1: 
                System.out.println("O valor equivale a Domingo");
            break;
            
            case 2:
                System.out.println("O valor equivale a Segunda");
            break;
            
            case 3:
                System.out.println("O valor equivale a Terça");
            break;
            
            case 4:
                System.out.println("O valor equivale a Quarta");
            break;
            
            case 5:
                System.out.println("O valor equivale a Quinta");
            break;
            
            case 6:
                System.out.println("O valor equivale a Sexta");
            break;
            
            case 7:
                System.out.println("O valor equivale a Sábado");
            break;
            
            default:
                System.out.println("O valor digitado foi " + diaDaSemana +  " e não equivale a nenhum dia da semana!");
        }
    }
}
