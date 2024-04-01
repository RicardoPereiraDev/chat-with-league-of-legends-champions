package me.dio.sdwm24.adapters.out;

import me.dio.sdwm24.domain.model.Champions;
import me.dio.sdwm24.domain.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionsJdbcRepository  implements ChampionsRepository {

    //vamos ter que colocar aqui uma propriedade do JdbcTemplate
    private final JdbcTemplate jdbcTemplate;

    //ver notas finais
    private final RowMapper<Champions> rowMapper;

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper= (rs, rowNum)-> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champions> findAll() {

        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?"; //Aqui é para indicar que este ? é um parametro da minha query
        Champions champion= jdbcTemplate.queryForObject(sql,rowMapper,id);//Aqui o que estamos a dizer é que quero recuperar um champions do meu banco de dados e para isso vou usar jdbcTemplate e para isso vou usar uma query passando o comando sql e passando um rowMapper para fazer essa conversão e o id que precisa de ser inserido;
        return Optional.ofNullable(champion); //se retornar null, nós garantimos que vai estar voltando aqui um optional vazio
    }
}

//Notas finais
/* Esta implementação do ChampionsRepository obriga-nos a implementar os metodos/funções que estão lá definidas

* Nesta camada de adapters ela já pode conhecer o spring por isso já posso colocar a anotation

Nesta camada de adapters, o proprio jdbc trás aqui uma implementação que funciona para fazer essa adaptação de dados que é esse rowMapper

Então eu posso fazer um rowMapper para a classe Champions, o rowMapper vai ser responsavel por fazer a conversão de um resultSt, ou seja,
  de uma consulta nativa, do jdbc no banco de dados para o meu record ou seja a minha classe. */


/* iNVERSÃO DE CONTROLE - O spring lida melhor com as instacias de Repositorio do que eu. */