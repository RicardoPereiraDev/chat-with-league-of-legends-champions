package me.dio.sdwm24.adapters.out;

import me.dio.sdwm24.domain.model.Champion;
import me.dio.sdwm24.domain.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionsJdbcRepository  implements ChampionsRepository {


    private final JdbcTemplate jdbcTemplate;


    private final RowMapper<Champion> rowMapper;

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper= (rs, rowNum)-> new Champion(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champion> findAll() {

        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);
    }

    @Override
    public Optional<Champion> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?"; //Aqui é para indicar que este ? é um parametro da minha query
        List<Champion> champions= jdbcTemplate.query(sql,rowMapper,id);//Aqui com o query vai retrnar uma lista de campeões, e o que estamos a dizer é que quero recuperar um champions do meu banco de dados e para isso vou usar jdbcTemplate e para isso vou usar uma query passando o comando sql e passando um rowMapper para fazer essa conversão e o id que precisa de ser inserido;
        return champions.stream().findFirst(); //vai retornar um optional de champion para nós
    }
}



