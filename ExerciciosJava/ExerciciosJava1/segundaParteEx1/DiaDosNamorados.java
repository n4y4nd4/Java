public class DiaDosNamorados extends CartaoWEB implements CartaoInterface {
    public DiaDosNamorados(String email, String nome) {
        super(email, nome);
    }

    @Override
    public String showMessage() {
        return "mensagem para: " + getEmail() + "\nParabéns, " + getNome() + " pelo Dia dos Namorados.";
    }
}