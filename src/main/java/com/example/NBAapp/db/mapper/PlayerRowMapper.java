package com.example.NBAapp.db.mapper;

import com.example.NBAapp.domain.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setName(rs.getString("name"));
        player.setSurname(rs.getString("surname"));
        player.setTeamId(rs.getObject("teamid")==null ? null :rs.getInt("teamid"));
        player.setScore(rs.getObject("score")==null ? null :rs.getInt("score"));
        return player;
    }
}
