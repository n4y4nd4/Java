
// Classe Payment para lidar com pagamentos e envio de recibos
public class Payment {
    // Cliente associado ao pagamento
    private Customer customer = null;

    // Identificador único do pagamento
    private int paymentId = 0;

    // Contador de pagamentos
    private static int paymentCount = 1;

    // Construtor da classe Payment
    public Payment(Customer cust) {
        // Associando o cliente ao pagamento
        customer = cust;

        // Atribuindo um identificador único ao pagamento
        paymentId = paymentCount++;
    }

    // Método para calcular o pagamento total e realizar ações associadas
    public void calculateTotalPayment(Hire hire) {
        // Enviar recibo por e-mail
        sendReceiptByEmail(hire);
    }

    // Método privado para enviar recibo por e-mail
    private void sendReceiptByEmail(Hire hire) {
        // Obter o endereço de e-mail do cliente
        String to = customer.getEmail();

        // Definir assunto e corpo do e-mail
        String subject = "Recibo de Aluguel de Bicicleta";
        String body = generateReceiptBody(hire);

        // Chamar método para enviar e-mail
        EmailSender.sendEmail(to, subject, body);
    }

    // Método privado para gerar o corpo do recibo
    private String generateReceiptBody(Hire hire) {
        // Obter informações relevantes da locação
        String cust = hire.getCustomer().getName();
        String pCode = hire.getCustomer().getPostcode();
        String bikeNum = Integer.toString(hire.getBike().getBikeNumber());
        int numDays = hire.getNumberOfDays();
        int cost = hire.getBike().calculateCost(numDays);

        // Construir o corpo do e-mail
        return "Recibo para: " + cust + "\n"
                + "Código postal: " + pCode + "\n"
                + "Aluguel da bicicleta número " + bikeNum + " por " + numDays + " dias\n"
                + "Custo total: $" + cost + "\n";
    }
}
