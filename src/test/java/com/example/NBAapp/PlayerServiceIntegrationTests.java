package com.example.NBAapp;

import com.example.NBAapp.db.service.api.*;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class PlayerServiceIntegrationTests {

    // implement integration tests for rest api aka controllers rather then for service

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerStatisticsRepository playerStatisticsRepository;

    @Autowired
    private TeamRepository teamRepository;

    private Team team1;

    private Team team2;

    private Team team3;

    @Before
    public void createTeam() {
        if (team1 == null) {
            team1 = new Team("Hornets");
            Integer id = teamRepository.add(team1);
            assert id != null;
            team1.setId(id);
        }
        if (team2 == null) {
            team2 = new Team("Bees");
            Integer id = teamRepository.add(team2);
            assert id != null;
            team2.setId(id);
        }
        if (team3 == null) {
            team3 = new Team("Wasps");
            Integer id = teamRepository.add(team3);
            assert id != null;
            team3.setId(id);
        }
    }

    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
    @Test
    public void addPlayer(){
        Player player1 = new Player("Milan","Vasko", team1.getId());
        Integer playerId = playerService.add(player1);

        Player selectedPlayer = playerService.get(playerId);

        // add assertions https://www.baeldung.com/junit-assertions
        // assert name
        assertEquals(player1.getName(), selectedPlayer.getName());
        // assert surname
    }
}
