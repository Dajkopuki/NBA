package com.example.NBAapp.db.repository;

import com.example.NBAapp.db.mapper.MatchRowMapper;
import com.example.NBAapp.domain.Match;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MatchRepository {
    private final JdbcTemplate jdbcTemplate;

    MatchRowMapper matchRowMapper = new MatchRowMapper();

    public MatchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Match get (int id) {
        final String sql = "SELECT * FROM player_statistics WHERE id = "+ id;
        try {
            return jdbcTemplate.queryForObject(sql,matchRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add (Match Match) {
        final String sql = "INSERT INTO player_statistics(team1_id, team1_score, team2_id, team2_score) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, Match.getTeam1Id());
                ps.setInt(2, Match.getTeam1Score());
                ps.setInt(3, Match.getTeam2Id());
                ps.setInt(4, Match.getTeam2Score());
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
