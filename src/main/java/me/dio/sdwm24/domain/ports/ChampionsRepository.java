package me.dio.sdwm24.domain.ports;

import me.dio.sdwm24.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll(); //Listar todos os campeões, função que vai retornar uma lista findAll;

    Optional<Champions> findById(Long id);
}
