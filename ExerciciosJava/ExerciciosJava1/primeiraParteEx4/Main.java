import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho das cadeias de DNA a serem geradas: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Fator de Corte da Combinação: ");
        int pontoDeCorte = scanner.nextInt();
        scanner.nextLine(); 

       
        String cadeia1 = CadeiaDeDna.gerarCadeiaDeDna(tamanho);
        String cadeia2 = CadeiaDeDna.gerarCadeiaDeDna(tamanho);

        
        String[] filhos = AlgoritmosGeneticos.recombinacao(cadeia1, cadeia2);

       
        String cadeiaMutada = AlgoritmosGeneticos.mutacao(cadeia1);

    
        System.out.println("Resultado da Combinação: ");
        System.out.println(Arrays.toString(filhos));

        System.out.println("Indice Aleatorio na Mutação: " + pontoDeCorte);
        System.out.println("Resultado da Mutação: " + cadeiaMutada);

        scanner.close();
    }
}