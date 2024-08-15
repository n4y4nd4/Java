// 2-)Escreva um programa que dado um valor numérico digitado pelo usuário (armazenado em  uma variável inteira), imprima cada um dos seus dígitos por extenso.  

// Exemplo:  Entre o número: 4571  Resultado: quatro, cinco, sete, um 

// Crie uma Classe Utilitaria para ter o método que retorna essa String.

import java.util.Scanner;

public class DigitosExtenso {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite um valor numérico: ");
        int numero = scanner.nextInt();

        System.out.println("Resultado: " + ClasseUtilitaria.numeroPorExtenso(numero) );
        scanner.close();

        
}
}