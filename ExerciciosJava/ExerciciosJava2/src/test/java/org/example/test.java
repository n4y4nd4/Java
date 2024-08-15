package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PessoaService;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    @DisplayName("Não pode retornar valor null")
    public void testaNull(){
        PessoaService pessoaService = new PessoaService();
        assertNotNull(pessoaService);


    }
}







