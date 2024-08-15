public class Aniversario extends CartaoWEB implements CartaoInterface {
    public Aniversario(String email, String nome) {
        super(email, nome);
    }

    @Override
    public String showMessage() {
        return "mensagem para: " + getEmail() + "\nFeliz Aniversário, " + getNome() + "!";
    }
}