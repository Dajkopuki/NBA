package com.example.NBAapp;

import com.example.NBAapp.domain.Couch;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class DBInsertTest {

    final String insertPlayer = "INSERT INTO player(name, surname, teamid, score) values (?,?,?,?)";
    final String insertTeam = "INSERT INTO team(teamname) values (?)";

    final String insertCouch = "INSERT INTO couch(name,surname,teamid) values (?,?,?)";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void createPlayer() {
        Player player = new Player();
        player.setName("David");
        player.setSurname("Nguyen");
        player.setTeamId(1);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertPlayer);
                ps.setString(1, player.getName());
                ps.setString(2, player.getSurname());
                if (player.getTeamId() != null) {
                    ps.setInt(3, player.getTeamId());
                } else {
                    ps.setNull(3, Types.INTEGER);
                }
                if (player.getScore() != null) {
                    ps.setInt(4, player.getScore());
                } else {
                    ps.setNull(4, Types.INTEGER);
                }
                return ps;
            }
        });
    }

    @Test
    public void createTeam() {
        Team team = new Team();
        team.setTeamName("Bees");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertTeam);
                ps.setString(1, team.getTeamName());
                return ps;
            }
        });
    }

    @Test
    public void createCouch() {
        Couch couch = new Couch();
        couch.setName("Milan");
        couch.setSurname("Vasko");
        couch.setTeamId(1);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertCouch);
                ps.setString(1,couch.getName());
                ps.setString(2,couch.getSurname());
                ps.setInt(3,couch.getTeamId());
                return ps;
            }
        });
    }
}