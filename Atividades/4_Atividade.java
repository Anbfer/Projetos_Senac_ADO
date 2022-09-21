import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Qual é o seu nome: ");
		String nome = input.next();
		
		System.out.println("Seu nome é: " + nome + " e tem " + nome.length() + " caracteres");
	}
}
