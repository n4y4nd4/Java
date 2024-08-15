// 1-) Faça um programa que a partir de uma String digitada pelo usuário imprima:

// a)O número de caracteres da string.  
// b) A string com todas suas letras em maiúsculo. 
// c) O número de vogais da string.  (Criar uma classe utilitária e um método pra isso.)
// d) Se a string digitada começa com "INF" (ignorando maiúsculas/minúsculas).  
// e) Se a string digitada termina com "NET" (ignorando maiúsculas/minúsculas).  
// f) O número de dígitos (0 a 9) da string. (Utilizar a classe utilitaria e criar um método para isso) 
// g) Os 2 primeiros digitos da String. 
// h) Se a string é um palíndromo ou não. (Utilizar a classe utilitaria e criar um método para isso) 

import java.util.Scanner;

public class ManipulacaoString{

    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite uma string: ");
    String input = scanner.nextLine();
    

    System.out.println("a)O número de caracteres da string: " + input.length());
    System.out.println("b) A string com todas suas letras em maiúsculo: " + input.toUpperCase());
    
    int numVogais = ClasseUtilitaria.contarVogais(input);
    System.out.println("c) O número de vogais da string: " + numVogais);

    if (input.toUpperCase().startsWith("INF")){
        System.out.println("d) A string digitada começa com \"INF\"");
    }else{
        System.out.println("d) A string digitada NÃO começa com \"INF\"");
    }

    
    if (input.toUpperCase().endsWith("INF")){
        System.out.println("e) A string digitada termina com \"NET\"");
    }else{
        System.out.println("e) A string digitada NÃO termina com \"NET\"");
    }

    int numDigitos = ClasseUtilitaria.contarDigitos(input);
    System.out.println("f) O número de dígitos (0 a 9) da string: " + numDigitos);

    System.out.println("g) Os 2 primeiros digitos da String: " + input.substring(0,2));


    if (ClasseUtilitaria.ehPalindromo(input)){
        System.out.println("h) A string digitada é um palíndromo");
    }else{
        System.out.println("h) A string digitada NÃO é um palíndromo");
    }
scanner.close();

    }

    }
