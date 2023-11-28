package com.example.NBAapp.db.mapper;

import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerStatisticsRowMapper implements RowMapper<PlayerStatisticsPerMatch> {
    @Override
    public PlayerStatisticsPerMatch mapRow(ResultSet rs, int rowNum) throws SQLException {
        PlayerStatisticsPerMatch playerStatisticsPerMatch = new PlayerStatisticsPerMatch();
        playerStatisticsPerMatch.setId(rs.getInt("id"));
        playerStatisticsPerMatch.setPlayerId(rs.getInt("player_id"));
        playerStatisticsPerMatch.setMatchIdl(rs.getInt("match_id"));
        return playerStatisticsPerMatch;
    }
}
