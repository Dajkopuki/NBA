package com.example.NBAapp;

import com.example.NBAapp.db.repository.MatchRepository;
import com.example.NBAapp.db.service.api.CouchService;
import com.example.NBAapp.db.service.api.GameService;
import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.db.service.api.TeamService;
import com.example.NBAapp.domain.Couch;
import com.example.NBAapp.domain.Match;
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

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private GameService gameService;
    @Autowired
    private MatchRepository matchRepository;

    private Team team1;

    private Team team2;

    private Team team3;

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
        if (team3 == null) {
            team3 = new Team("Wasps");
            Integer id = teamService.add(team3);
            assert id != null;
            team3.setId(id);
        }
    }

//    @Test
//    public void team(){
//        Player player1 = new Player("Ferko","Kopal",team1.getId());
//        Integer player1Id = playerService.add(player1);
//        Player player2 = new Player("Milan","Vasko", team1.getId());
//        Integer player2Id = playerService.add(player2);
//        Player player3 = new Player("Jano","Bezak",team2.getId());
//        Integer player3Id = playerService.add(player3);
//        Player player4 = new Player("Filip","Horvath",team2.getId());
//        Integer player4Id = playerService.add(player4);
//        Couch couch1 = new Couch("Tibor","Bajza", team1.getId());
//        Integer couch1Id = couchService.add(couch1);
//        Couch couch2 = new Couch("Rastislav","Masaryk", team2.getId());
//        Integer couch2Id = couchService.add(couch2);
//
//        List<Team> teams = teamService.getTeamsWithList();
//        Assert.assertEquals(teams.get(0).getPlayers().get(0).getName(),player1.getName());
//        Assert.assertEquals(3,teams.size());
//        Assert.assertEquals(couch1.getSurname(),teams.get(0).getCouch().getSurname());
//        List<Team> teams2 = teamService.getTeams();
//        Assert.assertEquals(teams.size(),teams2.size());
//        teamService.delete(1);
//        List<Team> teams3 = teamService.getTeams();
//        Assert.assertEquals(2,teams3.size());
//        teamService.updateScore(2,2);
//        Team teamFromDb = teamService.get(2);
//        Assert.assertEquals(2, teamFromDb.getScore().intValue());
//        Assert.assertEquals(2,teamFromDb.getId().intValue());
//    }

//    @Test
//    public void player(){
//        Player player1 = new Player("Milan","Vasko", team1.getId());
//        Integer playerId = playerService.add(player1);
//        Player playerFromDB = playerService.get(1);
//        Assert.assertEquals(player1,playerFromDB);
//        List<Player> players = playerService.getPlayers();
//        Assert.assertEquals(playerFromDB.getName(),players.get(0).getName());
//
//    }

//    @Test
//    public void couch(){
//        Couch couch = new Couch("Milan","Vasko", team1.getId());
//        Integer couchId = couchService.add(couch);
//        Couch couchFromDB = couchService.get(1);
//        Assert.assertEquals(couch,couchFromDB);
//        List<Couch> couches = couchService.getCouches();
//        Assert.assertEquals(couchFromDB.getName(),couches.get(0).getName());
//
//    }

    @Test
    public void playGame() {
        Player player1 = new Player("Ferko","Kopal",team1.getId());
        Integer player1Id = playerService.add(player1);
        Player player2 = new Player("Milan","Vasko", team1.getId());
        Integer player2Id = playerService.add(player2);
        Player player3 = new Player("Jano","Bezak",team1.getId());
        Integer player3Id = playerService.add(player3);
        Player player4 = new Player("Filip","Horvath",team1.getId());
        Integer player4Id = playerService.add(player4);
        Player player5 = new Player("Dusan","Mravcak",team1.getId());
        Integer player5Id = playerService.add(player5);
        Couch couch1 = new Couch("Tibor","Bajza", team1.getId());
        Integer couch1Id = couchService.add(couch1);
        Player player7 = new Player("Ferko","Kopal",team2.getId());
        Integer player7Id = playerService.add(player7);
        Player player8 = new Player("Milan","Vasko", team2.getId());
        Integer player8Id = playerService.add(player8);
        Player player9 = new Player("Jano","Bezak",team2.getId());
        Integer player9Id = playerService.add(player9);
        Player player10 = new Player("Filip","Horvath",team2.getId());
        Integer player10Id = playerService.add(player10);
        Player player11 = new Player("Dusan","Mravcak",team2.getId());
        Integer player11Id = playerService.add(player11);
        Couch couch2 = new Couch("Rastislav","Masaryk", team2.getId());
        Integer couch2Id = couchService.add(couch2);
        Player player13 = new Player("Ferko","Kopal",team3.getId());
        Integer player13Id = playerService.add(player13);
        Player player14 = new Player("Milan","Vasko", team3.getId());
        Integer player14Id = playerService.add(player14);
        Player player15 = new Player("Jano","Bezak",team3.getId());
        Integer player15Id = playerService.add(player15);
        Player player16 = new Player("Filip","Horvath",team3.getId());
        Integer player16Id = playerService.add(player16);
        Player player17 = new Player("Dusan","Mravcak",team3.getId());
        Integer player17Id = playerService.add(player17);
        Couch couch3 = new Couch("Milan","Hrudka", team3.getId());
        Integer couch3Id = couchService.add(couch3);


        gameService.game(teamService.getTeamsWithList());
        Match match1 =matchRepository.get(1);
        Match match2 =matchRepository.get(2);
        Match match3 =matchRepository.get(3);
        System.out.println(match1.getTeam2Score()+match1.getTeam1Score()+match2.getTeam1Score()+match2.getTeam2Score()+
                match3.getTeam1Score()+match3.getTeam2Score());
        System.out.println(playerService.getPlayers().get(0).getScore()+playerService.getPlayers().get(2).getScore()+playerService.getPlayers().get(3).getScore()
        +playerService.getPlayers().get(4).getScore()+playerService.getPlayers().get(5).getScore()+playerService.getPlayers().get(6).getScore()+playerService.getPlayers().get(7).getScore()
        +playerService.getPlayers().get(8).getScore()+playerService.getPlayers().get(9).getScore()
        +playerService.getPlayers().get(10).getScore()+playerService.getPlayers().get(11).getScore() +playerService.getPlayers().get(12).getScore()
        +playerService.getPlayers().get(13).getScore()+playerService.getPlayers().get(14).getScore()+playerService.getPlayers().get(1).getScore());
        playerService.getPlayers().forEach(player -> System.out.println(player.getScore()));
    }
}
