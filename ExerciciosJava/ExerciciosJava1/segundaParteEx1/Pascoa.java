public class Pascoa extends CartaoWEB implements CartaoInterface {
    public Pascoa(String email, String nome) {
        super(email, nome);
    }

    @Override
    public String showMessage() {
        return "mensagem para: " + getEmail() + "\nFeliz Páscoa, " + getNome() + "!";
    }
}