public class CartaoWEB {
    private String email;
    private String nome;

    public CartaoWEB(String email, String nome) {
        if (isValidEmail(email)) {
            this.email = email;
            this.nome = nome;
        } else {
            this.email = "email invalido";
            this.nome = nome;
        }
    }

    private boolean isValidEmail(String email) {
        // Lógica para validar o email aqui (pode usar regex).
        return email.contains("@") && email.indexOf("@") > 0 && email.indexOf("@") < email.length() - 1;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}