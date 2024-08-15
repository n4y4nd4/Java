import java.util.Scanner;

public class Iniciais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um nome: ");
        String nome = scanner.nextLine();

        System.out.println("Iniciais: " + obterIniciais(nome));

        scanner.close();
    }

    public static String obterIniciais(String nome) {
        String[] palavras = nome.split(" ");
        StringBuilder iniciais = new StringBuilder();

        for (String palavra : palavras) {
        
            if (!ehConector(palavra)) {
                iniciais.append(Character.toUpperCase(palavra.charAt(0)));
            }
        }

        return iniciais.toString();
    }

    public static boolean ehConector(String palavra) {
        
        String[] conectores = {"e", "do", "da", "dos", "das", "de", "di", "du"};
        
        palavra = palavra.toLowerCase();

        for (String conector : conectores) {
            if (palavra.equals(conector)) {
                return true; 
            }
        }

        return false; 
    }
}