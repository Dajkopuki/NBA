package com.example.NBAapp;

import com.example.NBAapp.db.service.api.CouchService;
import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.db.service.api.TeamService;
import com.example.NBAapp.domain.Couch;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class DBServiceTests {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private CouchService couchService;
    @Autowired
    private TeamService teamService;

    private Team team1;

    private Team team2;

    @Before
    public void createTeam() {
        if (team1 == null) {
            team1 = new Team("Hornets");
            Integer id = teamService.add(team1);
            assert id != null;
            team1.setId(id);
        }
        if (team2 == null) {
            team2 = new Team("Bees");
            Integer id = teamService.add(team2);
            assert id != null;
            team2.setId(id);
        }
    }

    @Test
    public void team(){
        Player player1 = new Player("Ferko","Kopal",team1.getId());
        Integer player1Id = playerService.add(player1);
        Player player2 = new Player("Milan","Vasko", team1.getId());
        Integer player2Id = playerService.add(player2);
        Player player3 = new Player("Jano","Bezak",team2.getId());
        Integer player3Id = playerService.add(player3);
        Player player4 = new Player("Filip","Horvath",team2.getId());
        Integer player4Id = playerService.add(player4);
        Couch couch1 = new Couch("Tibor","Bajza", team1.getId());
        Integer couch1Id = couchService.add(couch1);
        Couch couch2 = new Couch("Rastislav","Masaryk", team2.getId());
        Integer couch2Id = couchService.add(couch2);

        List<Team> teams = teamService.getTeamsWithList();
        Assert.assertEquals(teams.get(0).getPlayers().get(0).getName(),player1.getName());
        Assert.assertEquals(2,teams.size());
        Assert.assertEquals(couch1.getSurname(),teams.get(0).getCouch().getSurname());
        List<Team> teams2 = teamService.getTeams();
        Assert.assertEquals(teams.size(),teams2.size());
        teamService.delete(1);
        List<Team> teams3 = teamService.getTeams();
        Assert.assertEquals(1,teams3.size());
        teamService.updateScore(2,2);
        Team teamFromDb = teamService.get(2);
        Assert.assertEquals(2, teamFromDb.getScore().intValue());
        Assert.assertEquals(2,teamFromDb.getId().intValue());
    }

    @Test
    public void player(){
        Player player1 = new Player("Milan","Vasko", team1.getId());
        Integer playerId = playerService.add(player1);
        Player playerFromDB = playerService.get(1);
        Assert.assertEquals(player1,playerFromDB);
        List<Player> players = playerService.getPlayers();
        Assert.assertEquals(playerFromDB.getName(),players.get(0).getName());

    }

    @Test
    public void couch(){
        Couch couch = new Couch("Milan","Vasko", team1.getId());
        Integer couchId = couchService.add(couch);
        Couch couchFromDB = couchService.get(1);
        Assert.assertEquals(couch,couchFromDB);
        List<Couch> couches = couchService.getCouches();
        Assert.assertEquals(couchFromDB.getName(),couches.get(0).getName());

    }
}
