package com.example.NBAapp.db.repository;

import com.example.NBAapp.db.mapper.MatchRowMapper;
import com.example.NBAapp.domain.Match;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
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
public class MatchRepository {
    private final JdbcTemplate jdbcTemplate;

    MatchRowMapper matchRowMapper = new MatchRowMapper();

    public MatchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Match get (int id) {
        final String sql = "SELECT * FROM match WHERE id = "+ id;
        try {
            return jdbcTemplate.queryForObject(sql,matchRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add (Match match) {
        final String sql = "INSERT INTO match (team1_id, team1_score, team2_id, team2_score) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, match.getTeam1Id());
                ps.setInt(2, match.getTeam1Score());
                ps.setInt(3, match.getTeam2Id());
                ps.setInt(4, match.getTeam2Score());
                return ps;

            }
        },keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public void deleteAll() {
        final String sql = "TRUNCATE match";
        jdbcTemplate.update(sql);
    }


}
