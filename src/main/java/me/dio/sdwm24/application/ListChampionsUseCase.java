package me.dio.sdwm24.application;

import me.dio.sdwm24.domain.model.Champions;
import me.dio.sdwm24.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {

    //vai ter uma funcionalidade que vai ser buscar all, porque basicamente , vai retornar o que o nosso repositorio passar para ele.
    public List<Champions> findAll(){
        return repository.findAll();
    }
}


//Aqui eu não quero deixar a minha camada de aplicação conhecer que eu estou usando o Spring


//Aqui teremos as regras de negocio mais voltadas à camada de aplicação tambem podem estar nas entidades

//Entao podemos ter regras de dominio e regras de aplicação(pode ser alguma regra de negocio especifica)

// Regras de dominio - é mais alguma regra relacionada a persistencia daquele de dado ou de manipulação daquele informação
/*Na linha 8 qual o repositorio tem como dependecia, é o repositorio de dominio, o facto do meu useCase reconhecer só a interface d repositorio faz com que ela não conheça directamente o framework de persistencia que nós estamos usando para persistencia.

 */




