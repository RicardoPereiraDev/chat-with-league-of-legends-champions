package me.dio.sdwm24.application;

import me.dio.sdwm24.domain.exception.ChampionNotFoundException;
import me.dio.sdwm24.domain.model.Champion;
import me.dio.sdwm24.domain.ports.ChampionsRepository;

import java.util.List;

public record AskChampionsUseCase(ChampionsRepository repository) {


  public String askChampion(Long championId, String question){

     Champion champion= repository.findById(championId).orElseThrow(() -> new ChampionNotFoundException(championId)); //busquei este carinha no banco

     String championContext =  champion.generateContextByQuestion(question); //Aqui gerei o contexto a apartir dos dados que já estão encapsulados dentro dessa carinha Champion linha 14 e depois retornei ele par ao nosso metodo askChampion ....  este é cntexto daquele campeao especifico que busquei no banco de dados

      // TODO: EVOULUIR A LOGICA DE NEGOCIO PARA CONSIDERAR A INTEGRAÇÃO COM IAS GENERATIVAS

    return championContext;
  }
}






/* No metodo da linha12 askChampion o que estamos fazendo? estamos buscando por id no nosso repositorio o cmapeao e caso ele nao exista nós estamos lançando

a excepção championNotFoundException */



