// Classe Main para execução do programa principal
public class Main {
    public static void main(String[] args) {
        // Instanciar a interface de usuário para aluguel de bicicletas
        IssueBikeUI ui = new IssueBikeUI();

        // Mostrar detalhes de uma bicicleta
        ui.showBikeDetails(100);

        // Calcular o custo do aluguel
        ui.calculateCost(5);

        // Criar um cliente
        ui.createCustomer("Nayanda Robers", "PW2 6TR", 1462501339, "nayanda.robers@gmail.com");

        // Calcular o pagamento total
        ui.calculateTotalPayment();
    }
}
