import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<CartaoInterface> cartoes = new LinkedList<>();

        // Crie os cartões de diferentes tipos e adicione-os à lista
        cartoes.add(new DiaDosNamorados("email1@example.com", "Lucas"));
        cartoes.add(new Natal("email2@example.com", "Nayanda"));
        cartoes.add(new Aniversario("email3@example.com", "Louis"));
        cartoes.add(new Pascoa("email4@example.com", "Taylor"));
        cartoes.add(new Aniversario("email5@example.com", "Harry"));

        // Utilize Java 8 Streams para percorrer a lista e imprimir as mensagens
        cartoes.stream().forEach(cartao -> {
            System.out.println(cartao.showMessage());
        });
    }
}