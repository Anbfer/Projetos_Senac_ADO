import java.util.Scanner;

public class exercicioTresAdoTres {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira um ano qualquer para descobrir se é bissexto ou não: ");
		
		int ano = input.nextInt();
		if(String.valueOf(ano).length() < 4) {
			System.out.println("Insira um ano com pelo menos 4 digitos, reinicie o programa");
		}
		if(ano % 400 == 0 || ano % 4 == 0) {
			System.out.println(ano + " É bissexto");
		} else {
			System.out.println(ano + " Não é bissexto");
		}
	}
}
