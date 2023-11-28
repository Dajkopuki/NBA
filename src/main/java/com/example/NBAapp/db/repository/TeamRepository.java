package com.example.NBAapp.db.repository;

import com.example.NBAapp.db.mapper.TeamRowMapper;
import com.example.NBAapp.domain.Team;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Component
public class TeamRepository {
    private final JdbcTemplate jdbcTemplate;

    public TeamRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final TeamRowMapper teamRowMapper = new TeamRowMapper();

    public Team get(int id) {
        final String sql ="SELECT * from team WHERE id ="+id;
        try {
            return jdbcTemplate.queryForObject(sql, teamRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add(Team team) {
        final String sql ="INSERT INTO team (teamname) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,team.getTeamName());
                return ps;
            }
        },keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Team> getTeams() {
        final String sql ="SELECT * FROM team";
        return jdbcTemplate.query(sql,teamRowMapper);
    }

    public void delete(int id) {
        final String sql = "DELETE from team WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    public void updateScore(int id, int score) {
        final String sql = "UPDATE team SET score = ? WHERE id = ?";
        jdbcTemplate.update(sql,score,id);
    }

}
