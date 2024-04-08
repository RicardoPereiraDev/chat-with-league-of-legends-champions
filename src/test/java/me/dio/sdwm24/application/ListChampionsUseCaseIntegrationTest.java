package me.dio.sdwm24.application;

import me.dio.sdwm24.domain.model.Champion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions(){
        List<Champion> champions= listChampionsUseCase.findAll();

        Assertions.assertEquals(12,champions.size());
    }
}


/*Porquê Integration test? Porque eu quero comunicar me com o banco de dados, vai ser um teste de integração, que o nosso dado seja buscado lá no nosso banco de dados.

No caso de SpringBootTetst ele vai subir minha API, eu preciso para o Spring injectar tudo e fazer a busca.

   Vou precisar do ListChampionsUseCase e vou ter que injectar.

   Precisámos de fazer o asserts e esse Asserts precisa de ser do Junit, ou seja, precisamos de saber se essa lista de campeoes é diferente de vazia e se o tamanho dela é 12
   . E porquê 12 porque é a quantidade de itens que nós inserimos aqui. */