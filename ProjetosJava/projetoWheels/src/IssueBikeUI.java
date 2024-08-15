
import java.util.Date;

// Classe IssueBikeUI para representar a interface de usuário para aluguel de bicicletas
public class IssueBikeUI {
    // Atributos da interface
    private Bike chosenBike = null;
    private Customer customer = null;
    private Payment payment = null;
    private Hire hire = null;
    private int numberOfDays = 0;

    // Método para mostrar detalhes de uma bicicleta
    public void showBikeDetails(int bikeNum) {
        chosenBike = Bike.findBikeByNumber(bikeNum);
        if (chosenBike != null) {
            chosenBike.showDetails();
        }
    }

    // Método para calcular o custo do aluguel
    public void calculateCost(int numDays) {
        numberOfDays = numDays;
        System.out.println("COST would be $" + chosenBike.calculateCost(numDays) + "\n");
    }

    // Método para criar um cliente
    public void createCustomer(String name, String postcode, int telephone, String email) {
        customer = new Customer(name, postcode, telephone, email);
        payment = new Payment(customer);
        hire = new Hire(new Date(), numberOfDays, chosenBike, customer);
    }

    // Método para calcular o pagamento total
    public void calculateTotalPayment() {
        payment.calculateTotalPayment(hire);
    }
}
