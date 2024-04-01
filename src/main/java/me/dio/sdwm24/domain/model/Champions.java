package me.dio.sdwm24.domain.model;

public record Champions(

        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {

}


// Notas Finais

/* Utilizaremos o record porquê?

- Porque a ideia é fazer com que essas informações sejam atribuidas sempre na totalidade
 para que eu possa devolver para o front end e tambem
 quando eu for buscar, ter essas informações na mão para pode trabalhar
  com elas, nesse caso não vou ter uma anotation, porque a minha camada de modelo não poder conhecer a framework(spring).

  Ela vai ficar com os dados de negocio, dados de dominio e com as funções de dominio que nós quisermos dar para ela*/

// Nosso modelo neste momento está feito