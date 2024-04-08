package me.dio.sdwm24.adapters.in.exception;

import me.dio.sdwm24.domain.exception.ChampionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(ChampionNotFoundException.class)
    public ResponseEntity<ApiError> handleDomainException(ChampionNotFoundException domainError){
        return ResponseEntity.unprocessableEntity().body(new ApiError(domainError.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleDomainException(Exception unxpectedError){
        String message = "Ups! Ocorreu um erro inesperado!";
        logger.error(message, unxpectedError);
        return ResponseEntity.internalServerError().body(new ApiError(message)); //Dentro do meu ResponseEntity eu consigo retornar um responseEntity passando qual é o status que eu quero e depois quero passar como corpo da minha requesição o erro
    }


    public record ApiError(String message){ //Criar aqui uma classe e Aqui vai ter uma mensagem de erro

    }
}


//Notas finais:

/*Quando dá um erro inesperado podemos trabalhar com um logger para fazer o log no servidor no caso dos erros */