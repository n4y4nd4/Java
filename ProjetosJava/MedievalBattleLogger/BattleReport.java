import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class RegistroBatalha {
    String data;
    String heroi;
    String resultado;
    String monstro;
    int rodadas;

    public RegistroBatalha(String data, String heroi, String resultado, String monstro, int rodadas) {
        this.data = data;
        this.heroi = heroi;
        this.resultado = resultado;
        this.monstro = monstro;
        this.rodadas = rodadas;
    }
}

public class BattleReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nickname do jogador para ver o relatório: ");
        String nickname = scanner.nextLine();
        scanner.close();

        
        List<RegistroBatalha> registros = lerLog(nickname + ".csv");

       
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro encontrado para o jogador " + nickname);
            return;
        }

    
        int totalPontos = 0;
        Map<String, Integer> heroisJogados = new HashMap<>();
        Map<String, Integer> monstrosEnfrentados = new HashMap<>();

      
        for (RegistroBatalha registro : registros) {
            String resultado = registro.resultado;
            String heroi = registro.heroi;
            String monstro = registro.monstro;
            int rodadas = registro.rodadas;

            
            int pontos = 100 - rodadas;
            totalPontos += pontos;

            
            heroisJogados.put(heroi, heroisJogados.getOrDefault(heroi, 0) + 1);
            monstrosEnfrentados.put(monstro, monstrosEnfrentados.getOrDefault(monstro, 0) + 1);
        }

        
        System.out.println("Relatório para o jogador " + nickname);
        System.out.println("Total de pontos: " + totalPontos);

        
        System.out.println("Herói mais jogado:");
        String heroiMaisJogado = Collections.max(heroisJogados.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(heroiMaisJogado);

        
        System.out.println("Monstro mais enfrentado:");
        String monstroMaisEnfrentado = Collections.max(monstrosEnfrentados.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(monstroMaisEnfrentado);
    }

    
    private static List<RegistroBatalha> lerLog(String nomeArquivo) {
        List<RegistroBatalha> registros = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader("temp/" + nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";");
                String data = partes[0];
                String heroi = partes[1];
                String resultado = partes[2];
                String monstro = partes[3];
                int rodadas = Integer.parseInt(partes[4]);

                RegistroBatalha registro = new RegistroBatalha(data, heroi, resultado, monstro, rodadas);
                registros.add(registro);
            }
        } catch (IOException e) {
            
        }

        return registros;
    }
}

