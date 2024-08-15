import java.util.Random;

import java.util.Random;

class AlgoritmosGeneticos {
    public static String[] recombinacao(String s1, String s2) {
        Random random = new Random();
        int tamanho = s1.length();

      
        int pontoDeCorte = random.nextInt(tamanho - 1) + 1;

       
        String filho1 = s1.substring(0, pontoDeCorte) + s2.substring(pontoDeCorte);
        String filho2 = s2.substring(0, pontoDeCorte) + s1.substring(pontoDeCorte);

        String[] filhos = { filho1, filho2 };
        return filhos;
    }

    public static String mutacao(String cadeia) {
        Random random = new Random();
        int tamanho = cadeia.length();

        
        int posicaoMutacao = random.nextInt(tamanho);

      
        String bases = "ACGT";
        char novaBase = bases.charAt(random.nextInt(bases.length()));

      
        StringBuilder novaCadeia = new StringBuilder(cadeia);
        novaCadeia.setCharAt(posicaoMutacao, novaBase);

        return novaCadeia.toString();
    }
}