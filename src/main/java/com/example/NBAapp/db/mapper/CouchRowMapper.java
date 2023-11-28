package com.example.NBAapp.db.mapper;

import com.example.NBAapp.domain.Couch;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CouchRowMapper implements RowMapper<Couch> {
    @Override
    public Couch mapRow(ResultSet rs, int rowNum) throws SQLException {
        Couch couch = new Couch();
        couch.setId(rs.getInt("id"));
        couch.setName(rs.getString("name"));
        couch.setSurname(rs.getString("surname"));
        couch.setTeamId(rs.getInt("teamid"));
        return couch;

    }
}
