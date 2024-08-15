import java.util.Date;

// Classe Hire para representar as locações
public class Hire {
    // Atributos de uma locação
    private Date startDate = null;
    private Customer customer = null;
    private Bike bike = null;
    private int numberOfDays = 0;
    private int hireId = 0;

    // Contador de locações
    private static int hireCount = 1;

    // Construtor da classe Hire
    public Hire(Date sDate, int numDays, Bike bikeToHire, Customer cust) {
        startDate = sDate;
        numberOfDays = numDays;
        customer = cust;
        bike = bikeToHire;
        hireId = hireCount++;
    }

    // Métodos getter para obter informações da locação
    public Customer getCustomer() {
        return customer;
    }

    public Bike getBike() {
        return bike;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Date getStartDate() {
        return startDate;
    }
}
