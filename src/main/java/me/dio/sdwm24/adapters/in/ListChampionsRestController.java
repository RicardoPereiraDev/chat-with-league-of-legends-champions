package me.dio.sdwm24.adapters.in;

import me.dio.sdwm24.application.ListChampionsUseCase;
import me.dio.sdwm24.domain.model.Champion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name= "Campeões", description = "Endpoints do dominio de Campeões do LOL")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @GetMapping
    public List<Champion> findAllChampions(){

        return useCase.findAll();
    }
}



//Notas Finais

/*Precisamos de useCase dentro do nosso controller para poder chamar a camada de negócios e devolver o dado que o usuario está pedindo.

Agora vamos criar um metodo para expor esses dados que o nosso useCase se propoe a buscar. Lembra que o ListChampionsUseCase tem um metodo findAll
 */