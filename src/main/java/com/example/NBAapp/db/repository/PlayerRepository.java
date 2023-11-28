package com.example.NBAapp.db.repository;

import com.example.NBAapp.db.mapper.PlayerRowMapper;
import com.example.NBAapp.domain.Player;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
public class PlayerRepository {
    private final JdbcTemplate jdbcTemplate;
    private final PlayerRowMapper playerRowMapper = new PlayerRowMapper();

    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Player get (int id) {
        final String sql = "SELECT * FROM player WHERE id = "+ id;
        try {
            return jdbcTemplate.queryForObject(sql,playerRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add (Player player ) {
        final String sql = "INSERT INTO player(name, surname, teamid) values (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,player.getName());
                ps.setString(2,player.getSurname());
                if (player.getTeamId() != null) {
                    ps.setInt(3, player.getTeamId());
                } else {
                    ps.setNull(3, Types.INTEGER);
                }
                return ps;

            }
        },keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Player> getPlayers() {
        final String sql ="SELECT * from player";
        return jdbcTemplate.query(sql, playerRowMapper);
    }

    public List<Player> getPlayersFromTeam(int teamId){
        final String sql = "SELECT * from player WHERE teamid="+teamId;
        return jdbcTemplate.query(sql,playerRowMapper);
    }

    public void delete(int id) {
        final String sql = "DELETE from player WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    public void updateScore(int id, int score) {
        final String sql = "UPDATE player SET score = ? WHERE id = ?";
        jdbcTemplate.update(sql,score,id);
    }

    public void updateTeam(int id, int teamId) {
        final String sql = "UPDATE player SET teamid = ? WHERE id = ?";
        jdbcTemplate.update(sql,teamId,id);
    }

}
