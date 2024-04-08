package me.dio.sdwm24;

import me.dio.sdwm24.application.AskChampionsUseCase;
import me.dio.sdwm24.application.ListChampionsUseCase;
import me.dio.sdwm24.domain.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean //apartir dessa difinição de Bean, estou dizendo para o Spring cuidar dessa instancia do  UseCase para mim, lembra que o Spring já sabe como criar essa interface galera, porque esse projecto é um projecto Spring e a unica implementação dessa interface é ChampionsJdbcRepository, por isso em qquer lugar que essa interface estiver sendo utilizada e que esteja sendo gerida pelo Spring, com um Bean por exemplo, o Spring irá injectar, ele por exemplo aqui neste caso diz que conhece o repository e injecta e depois passa para criar outra instancia.
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}

	@Bean //apartir dessa difinição de Bean, estou dizendo para o Spring cuidar dessa instancia do  UseCase para mim, lembra que o Spring já sabe como criar essa interface galera, porque esse projecto é um projecto Spring e a unica implementação dessa interface é ChampionsJdbcRepository, por isso em qquer lugar que essa interface estiver sendo utilizada e que esteja sendo gerida pelo Spring, com um Bean por exemplo, o Spring irá injectar, ele por exemplo aqui neste caso diz que conhece o repository e injecta e depois passa para criar outra instancia.
	public AskChampionsUseCase provideAskChampionsUseCase(ChampionsRepository repository){
		return new AskChampionsUseCase(repository);
	}
}


/*Vamos criar um Bean para executar e configurar a aplicaçao de elementos de framework,
* basicamente o que estamos fazendo é criar uma definição para o Spring entender como é que ele tem de criar o nosso useCase */