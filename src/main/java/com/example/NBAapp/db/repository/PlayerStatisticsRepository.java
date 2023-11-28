package com.example.NBAapp.db.repository;

import com.example.NBAapp.db.mapper.PlayerStatisticsRowMapper;
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

@Component
public class PlayerStatisticsRepository {
    private final JdbcTemplate jdbcTemplate;
    private final PlayerStatisticsRowMapper playerStatisticsRowMapper = new PlayerStatisticsRowMapper();

    public PlayerStatisticsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlayerStatisticsPerMatch get (int id) {
        final String sql = "SELECT * FROM player_statistics WHERE id = "+ id;
        try {
            return jdbcTemplate.queryForObject(sql,playerStatisticsRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add (PlayerStatisticsPerMatch playerStatisticsPerMatch) {
        final String sql = "INSERT INTO player_statistics(player_id, match_id) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, playerStatisticsPerMatch.getPlayerId());
                ps.setInt(2, playerStatisticsPerMatch.getMatchIdl());
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
        final String sql = "TRUNCATE player_statistics";
        jdbcTemplate.update(sql);
    }
}
