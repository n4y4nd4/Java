
// Classe Bike para representar as bicicletas
public class Bike {
    // Lista estática de bicicletas
    protected static Bike[] bikeList = new Bike[5];

    // Atributos de uma bicicleta
    protected int deposit = 0;
    protected int rate = 0;
    protected int bikeNumber = 0;

    // Bloco estático para inicializar a lista de bicicletas
    static {
        int j = 0;
        for (int i = 10; i < 15; i++) {
            Bike b = new Bike(i, i, (j * 100));
            bikeList[j] = b;
            j++;
        }
    }

    // Construtor da classe Bike
    public Bike(int dep, int rat, int num) {
        deposit = dep;
        rate = rat;
        bikeNumber = num;
    }

    // Métodos getter para obter informações da bicicleta
    public int getDeposit() {
        return deposit;
    }

    public int getRate() {
        return rate;
    }

    public int getBikeNumber() {
        return bikeNumber;
    }

    // Método estático para encontrar uma bicicleta pelo número
    public static Bike findBikeByNumber(int bikeNum) {
        int numberOfBikes = bikeList.length;

        for (int i = 0; i < numberOfBikes; i++) {
            if (bikeList[i].getBikeNumber() == bikeNum) {
                System.out.println("Bike with number ´" + bikeNum + "´ found" + "\n");
                return bikeList[i];
            }
        }
        System.out.println("Bike with number´" + bikeNum + "´not found" + "\n");
        return null;
    }

    // Método para mostrar detalhes da bicicleta
    public void showDetails() {
        System.out.println("Details for bike number ´" + bikeNumber + "´");
        System.out.println("DEPOSIT:" + deposit);
        System.out.println("RATE: " + rate + "\n");
    }

    // Método para calcular o custo do aluguel
    public int calculateCost(int numberOfDays) {
        return deposit + (rate * numberOfDays);
    }
}
