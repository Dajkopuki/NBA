package com.example.NBAapp.db.repository;

import com.example.NBAapp.db.mapper.CouchRowMapper;
import com.example.NBAapp.domain.Couch;
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
import java.util.List;

@Component
public class CouchRepository {

    private final JdbcTemplate jdbcTemplate;

    public CouchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    CouchRowMapper couchRowMapper = new CouchRowMapper();

    public Couch get(int id) {
        final String sql = "SELECT * FROM couch WHERE id ="+id;
        try {
            return jdbcTemplate.queryForObject(sql, couchRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Couch getByTeam(int teamId) {
        final String sql = "SELECT * FROM couch WHERE id ="+teamId;
        try {
            return jdbcTemplate.queryForObject(sql, couchRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public Integer add(Couch couch) {
        final String sql = "INSERT INTO couch(name, surname, teamid) values (?,?,?) ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,couch.getName());
                ps.setString(2,couch.getSurname());
                ps.setInt(3, couch.getTeamId());
                return ps;
            }
        },keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Couch> getAll() {
        final String sql ="SELECT * from couch";
        return jdbcTemplate.query(sql, couchRowMapper);
    }

    public void updateTeam(int id, int teamId) {
        final String sql = "UPDATE couch SET teamid = ? WHERE id = ?";
        jdbcTemplate.update(sql,teamId,id);
    }

    public void delete(int id) {
        final String sql = "DELETE from couch WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

}
