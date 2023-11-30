package com.example.NBAapp.db.mapper;

import com.example.NBAapp.domain.Match;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchRowMapper implements RowMapper<Match> {
    @Override
    public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
        Match match = new Match();
        match.setId(rs.getInt("id"));
        match.setTeam1Id(rs.getInt("team1_id"));
        match.setTeam1Score(rs.getInt("team1_score"));
        match.setTeam2Id(rs.getInt("team2_id"));
        match.setTeam2Score(rs.getInt("team2_score"));
        return match;
    }
}
