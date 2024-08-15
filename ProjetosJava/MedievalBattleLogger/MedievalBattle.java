import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


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


abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int forca;
    protected int defesa;
    protected int agilidade;
    protected int fatorDano;

    
    public Personagem(String nome, int vida, int forca, int defesa, int agilidade, int fatorDano) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.fatorDano = fatorDano;
    }

    
    public int calcularFatorAtaque() {
        return new Random().nextInt(10) + agilidade + forca;
    }

    public int calcularFatorDefesa() {
        return new Random().nextInt(10) + agilidade + defesa;
    }

    public int calcularDano() {
        return new Random().nextInt(fatorDano) + forca; 
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() {
        return nome;
    }
}


class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 12, 4, 3, 3, (int)Math.round(Math.random() * 4) + (int)Math.round(Math.random() * 4));
    }
}

class Barbaro extends Personagem {
    public Barbaro(String nome) {
        super(nome, 13, 6, 1, 3, (int)Math.round(Math.random() * 6) + (int)Math.round(Math.random() * 6));
    }
}

class Paladino extends Personagem {
    public Paladino(String nome) {
        super(nome, 15, 2, 5, 1, (int)Math.round(Math.random() * 4) + (int)Math.round(Math.random() * 4));
    }
}


class MortoVivo extends Personagem {
    public MortoVivo(String nome) {
        super(nome, 25, 4, 0, 1, (int)Math.round(Math.random() * 4) + (int)Math.round(Math.random() * 4));
    }
}

class Orc extends Personagem {
    public Orc(String nome) {
        super(nome, 20, 6, 2, 2, (int)Math.round(Math.random() * 8));
    }
}

class Kobold extends Personagem {
    public Kobold(String nome) {
        super(nome, 20, 4, 2, 4, (int)Math.round(Math.random() * 2) + (int)Math.round(Math.random() * 2) + (int)Math.round(Math.random() * 2));
    }
}

public class MedievalBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nickname do jogador: ");
        String nickname = scanner.nextLine();

        System.out.println("Escolha a classe de herói: ");
        System.out.println("1. Guerreiro");
        System.out.println("2. Bárbaro");
        System.out.println("3. Paladino");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Personagem heroi = criarHeroi(choice, nickname);

        Personagem monstro = gerarMonstroAleatorio();

        int rounds = 0;
        while (heroi.estaVivo() && monstro.estaVivo()) {
            rounds++;
            rodadaDeBatalha(heroi, monstro);
        }

       
        salvarRegistroDeBatalha(nickname, heroi, monstro.getNome(), rounds);

        scanner.close();
    }

    private static Personagem criarHeroi(int choice, String nickname) {
        switch (choice) {
            case 1:
                return new Guerreiro(nickname);
            case 2:
                return new Barbaro(nickname);
            case 3:
                return new Paladino(nickname);
            default:
                throw new IllegalArgumentException("Escolha de classe inválida.");
        }
    }

    private static Personagem gerarMonstroAleatorio() {
        Random random = new Random();
        int monsterChoice = random.nextInt(3);
        switch (monsterChoice) {
            case 0:
                return new MortoVivo("Morto Vivo");
            case 1:
                return new Orc("Orc");
            case 2:
                return new Kobold("Kobold");
            default:
                throw new IllegalArgumentException("Escolha de monstro inválida.");
        }
    }

    private static void rodadaDeBatalha(Personagem heroi, Personagem monstro) {
        int heroiInitiative = heroi.calcularFatorAtaque() + new Random().nextInt(10);
        int monstroInitiative = monstro.calcularFatorAtaque() + new Random().nextInt(10);

        while (heroiInitiative == monstroInitiative) {
            heroiInitiative = heroi.calcularFatorAtaque() + new Random().nextInt(10);
            monstroInitiative = monstro.calcularFatorAtaque() + new Random().nextInt(10);
        }

        Personagem atacante, defensor;
        if (heroiInitiative > monstroInitiative) {
            atacante = heroi;
            defensor = monstro;
        } else {
            atacante = monstro;
            defensor = heroi;
        }

        int ataque = atacante.calcularFatorAtaque();
        int defesa = defensor.calcularFatorDefesa();

        if (ataque > defesa) {
            int dano = atacante.calcularDano();
            defensor.receberDano(dano);
            System.out.println(atacante.getNome() + " causou " + dano + " de dano em " + defensor.getNome());
        } else {
            System.out.println(atacante.getNome() + " nao conseguiu atacar " + defensor.getNome());
        }
    }

    private static void salvarRegistroDeBatalha(String nickname, Personagem heroi, String monstroNome, int rounds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(new Date());

        
        File tempDir = new File("temp");
        if (!tempDir.exists()) {
            tempDir.mkdir();
        }


        String logFileName = "temp/" + nickname + ".csv";

        try (FileWriter writer = new FileWriter(logFileName, true)) {
            String resultado = heroi.estaVivo() ? "GANHOU" : "PERDEU";
            writer.write(data + ";" + heroi.getNome() + ";" + resultado + ";" + monstroNome + ";" + rounds + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
