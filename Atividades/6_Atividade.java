import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
         System.out.println("Insira o valor do lado A: ");
         int ladoA = input.nextInt();
         System.out.println("Insira o valor do lado B: ");
         int laboB = input.nextInt();
         System.out.println("Insira o valor do lado C: ");
         int ladoC = input.nextInt();

         if (ladoA + laboB > ladoC && ladoA + ladoC > laboB && ladoC + laboB > ladoA) {
            System.out.println("Você é um triângulo\n");
            if (ladoA == laboB && ladoA == ladoC) {
             System.out.println("Você é um triângulo equilatero\n");
             System.exit(0);
            } else if (ladoA == laboB && laboB != ladoC) {
             System.out.println("Você é um triângulo isóceles");
             System.exit(0);
            } else {
             System.out.println("Você é um triângulo escaleno!");
             System.exit(0);
            }
         } 
    }
}
