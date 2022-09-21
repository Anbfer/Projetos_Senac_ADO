import java.util.Scanner;

public class aplicaDesconto {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o valor da compra para receber seu desconto: ");

        double compra = input.nextDouble();

        if (compra >= 300) {

            double valorDescontoDe20 = compra * 0.2;
            double aplicaDescontoDeVinte = compra - valorDescontoDe20;

            System.out.println("Você ganhou 20% de desconto! O valor final da compra" + " é de R$"
                    + aplicaDescontoDeVinte + " e você economizou R$" + valorDescontoDe20);
            System.exit(0);
        } else {

            double valorDescontoDe15 = compra * 0.15;
            double aplicaDescontoDeQuinze = compra - valorDescontoDe15;

            System.out.println("Você ganhou 15% de desconto! O valor final da compra" + " é de R$"
                    + aplicaDescontoDeQuinze + " e você economizou R$" + valorDescontoDe15);
            System.exit(0);
        }

    }
}
