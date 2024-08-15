package service;

import model.Pessoa;
import org.example.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
public class PessoaService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(App.class);
    public Pessoa criarPessoa() {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();


        LOGGER.info("Digite o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        LOGGER.info("Digite a idade da pessoa: ");
        pessoa.setIdade(Integer.parseInt(scanner.nextLine()));

        while (true) {
            LOGGER.info("Digite o email da pessoa: ");
            String email = scanner.nextLine();
            if (validarEmail(email)) {
                pessoa.setEmail(email);
                break;
            } else {
                LOGGER.error("Email inválido. Tente novamente.");
            }
        }

        return pessoa;
    }

    private boolean validarEmail(String email) {

        return email.contains("@") && email.contains(".");
    }


}