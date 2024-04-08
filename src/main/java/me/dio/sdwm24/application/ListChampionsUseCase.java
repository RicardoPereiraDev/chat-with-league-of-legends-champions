package me.dio.sdwm24.application;

import me.dio.sdwm24.domain.model.Champion;
import me.dio.sdwm24.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {


    public List<Champion> findAll(){

        return repository.findAll();
    }
}






