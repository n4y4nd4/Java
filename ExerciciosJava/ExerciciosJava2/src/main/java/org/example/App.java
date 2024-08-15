package org.example;
import model.Pessoa;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import service.PessoaService;



/*
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        LOGGER.debug( "oi" );
        PessoaService pessoaService = new PessoaService();
        Pessoa pessoa = pessoaService.criarPessoa();

        LOGGER.info("Dados da pessoa:");
        LOGGER.info("Nome: " + pessoa.getNome());
        LOGGER.info("Idade: " + pessoa.getIdade());
        LOGGER.info("Email: " + pessoa.getEmail());
    }
}
