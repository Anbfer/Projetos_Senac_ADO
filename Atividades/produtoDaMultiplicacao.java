import java.util.Scanner;

public class produtoDaMultiplicacao {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
				
		System.out.println("Digite o valor de N1: " );
		float n1 = input.nextFloat();
		System.out.println("Digite o valor de N2: ");
		float n2 = input.nextFloat();
		System.out.println("Digite o valor de N3: ");
		float n3 = input.nextFloat();
		
		float soma = n1 * n2 * n3;
		
		System.out.println("O produto da soma dos valores é: " + soma);
		
	}
}
