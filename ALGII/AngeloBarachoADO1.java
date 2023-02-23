import java.util.Random;
import java.util.Scanner;

public class AngeloBarachoADO1 {

    public static void main(String[] args) {
        //Variaveis para soma dos valores pares e impares e para os menores e maiores valores
        int somaPar = 0, somaImpar = 0, maiorValorVetor = 0, menorValorVetor = 0;


        //Criação do vetor com 10 posições
        int[] meuVetor = new int[10];


        //vetor preenchido com os valores aleatórios
        meuVetor = inizializaVetor(meuVetor);


        //impressão do vetor em console
        imprimeValoresVetor(meuVetor);


        //variaveis com os resultados pesquisados dentro do vetor com o maior e o menor valor
        maiorValorVetor = maiorValorVetor(meuVetor);
        menorValorVetor = menorValorVetor(meuVetor, maiorValorVetor);


        //menor e maior valor impresso
        System.out.println("\nMenor valor: " + menorValorVetor);
        System.out.println("Maior valor: " + maiorValorVetor);


        //soma dos pares e impares
        somaPar = somaPar(meuVetor);
        somaImpar = somaImpar(meuVetor);


        //impressão dos pares e impares
        System.out.println("Soma pares: " + somaPar);
        System.out.println("Soma impares: " + somaImpar);


        //Escolha do numero a ser pesquisado dentro do bound dos números aleatórios
        System.out.printf("\nEscolha um numero de 0-20 para ser pesquisado no Vetor: ");


        //pega o imput do usuário para pesquisar o valor desejado
        int valorPesquisar = pegaInput();


        //pesquisa os valores e retorna se ele existem ou não e se existirem em qual indice do vetor é possivel encontrar o número inputado
        procuraNumeroNoVetor(meuVetor, valorPesquisar);


        //pede o valor a ser multiplicado
        System.out.printf("\nEscolha um valor para multiplicar os números do Vetor: ");

        
        //pega o valor escolhido
        int valorMultiplicador = pegaInput();


        //cria um novo vetor com os valores multiplicados pelo numero inputado
        int[] vetorMultiplicado = multiplicaValoresVetor(meuVetor, valorMultiplicador);


        //imprime o vetor com os valores do resultado da multiplicação
        imprimeValoresVetor(vetorMultiplicado);
    }


    //função que preenche o vetor com os números aleatórios
    private static int[] inizializaVetor(int[] vetor) {
        Random aleatorio = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = aleatorio.nextInt(20);
        }
        return vetor;
    }


    //imprime os os valores de um vetor
    private static void imprimeValoresVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf(vetor[i] + "\t");
        }
    }


    //encontra o maior valor do vetor
    private static int maiorValorVetor(int[] vetor) {
        int maior = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }


    //encontra o menor valor do vetor
    private static int menorValorVetor(int[] vetor, int maiorValorVetor) {
        int menor = maiorValorVetor;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
                if (vetor[i] < menor) {
                    menor = vetor[i];
                }
            }
        }
        return menor;
    }

    
    //soma os numeros pares
    private static int somaPar(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                soma += vetor[i];
            }
        }
        return soma;
    }


    //soma os numeros impares
    private static int somaImpar(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                soma += vetor[i];
            }
        }
        return soma;
    }


    //pega os valore inseridos pelo usuário
    private static int pegaInput() {
        Scanner input = new Scanner(System.in);
        int numeroEscolhido = input.nextInt();

        return numeroEscolhido;
    }


    //pesquisa dentro do vetor o valor imputado
    private static void procuraNumeroNoVetor(int[] vetor, int valorPesquisar) {
        boolean controlador = false;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorPesquisar) {
                System.out.println("Valor encontrado na posição " + i + " do vetor");
                controlador = true;
            }
        }
        if (controlador == false) {
            System.out.println("Valor não encontrado no Vetor");
        }
    }

    
    //faz a multiplicação dos valores no vetor e retorna um vetor com o resultado das multiplicações
    private static int[] multiplicaValoresVetor(int[] vetor, int valorMultiplicador) {
        int[] vetorMultiplicado = new int[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            vetorMultiplicado[i] = vetor[i] * valorMultiplicador; 
        }
        return vetorMultiplicado;
    }
}
