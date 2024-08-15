import java.util.Random;


class CadeiaDeDna {
    public static String gerarCadeiaDeDna(int tamanho) {
         Random random = new Random();
        StringBuilder cadeia = new StringBuilder();

        String bases = "ACGT";

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(bases.length());
            char base = bases.charAt(indice);
            cadeia.append(base);
        }

        return cadeia.toString();
    
    }
}