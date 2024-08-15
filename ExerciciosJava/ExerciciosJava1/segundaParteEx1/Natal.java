public class Natal extends CartaoWEB implements CartaoInterface {
    public Natal(String email, String nome) {
        super(email, nome);
    }

    @Override
    public String showMessage() {
        return "mensagem para: " + getEmail() + "\nFeliz Natal, " + getNome()+"!";
    }
}