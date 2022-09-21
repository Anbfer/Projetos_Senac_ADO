import java.util.Scanner;

public class Atividade2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Dê um valor a N: ");
		int n = input.nextInt();
		
		int primeiroMultiplo = n * 1;
		int segundoMultiplo = n * 2;
		int terceiroMultiplo = n * 3;
		
		System.out.println("O primeiro multiplo de " + n + " é: " + primeiroMultiplo);
		System.out.println("O segundo multiplo de " + n + " é: " + segundoMultiplo);
		System.out.println("O terceito multiplo de " + n + " é: " + terceiroMultiplo);
	}

}
