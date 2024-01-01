package com.example.NBAapp.db.mapper;

import com.example.NBAapp.domain.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper  implements RowMapper<Team> {
    @Override
    public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setTeamName(rs.getString("teamname"));
        team.setScore(rs.getObject("score")==null ? null :rs.getInt("score"));
        return team;
    }
}
