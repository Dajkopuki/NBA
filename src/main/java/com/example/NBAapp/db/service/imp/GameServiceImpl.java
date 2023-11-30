package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.MatchRepository;
import com.example.NBAapp.db.repository.PlayerStatisticsRepository;
import com.example.NBAapp.db.service.api.GameService;
import com.example.NBAapp.domain.Match;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import com.example.NBAapp.domain.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private final TeamServiceImpl teamService;
    private final MatchRepository matchRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;



    public GameServiceImpl(TeamServiceImpl teamService, MatchRepository matchRepository, PlayerStatisticsRepository playerStatisticsRepository) {
        this.teamService = teamService;
        this.matchRepository = matchRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    @Override
    public void game(List<Team> teams) {
        for (int i = 0; i < teams.size()-1; i++) {
            for (int j = i+1; j < teams.size(); j++) {
                match(teams.get(i), teams.get(j));
            }
        }
    }

    @Override
    public void restartGame() {

    }

    @Override
    public void listResults() {

    }

    private void match(Team team1, Team team2) {
        int i, j, scoreGen1 =0, scoreGen2 = 0, totalScore1 =0, totalScore2=0;
        int[] arrayOfScores1 = new int[team1.getPlayers().size()];
        int[] arrayOfScores2 = new int[team2.getPlayers().size()];;
        for (j = 0; j < 17; j++) {
            for (i = 0; i < 5; i++) {
                scoreGen1= scoreGenerator();
                scoreGen2=scoreGenerator();
                arrayOfScores1[i] += scoreGen1;
                arrayOfScores2[i] += scoreGen2;
                team1.getPlayers().get(i).setScore((team1.getPlayers().get(i).getScore()==null ? 0:team1.getPlayers().get(i).getScore())+scoreGen1);
                team2.getPlayers().get(i).setScore((team2.getPlayers().get(i).getScore()==null ? 0:team2.getPlayers().get(i).getScore())+scoreGen2);
                totalScore1 = totalScore1+scoreGen1;
                totalScore2 = totalScore2+scoreGen2;
            }
        }

        if (totalScore1 > totalScore2) {
            team1.setScore(2);
            team2.setScore(0);
        } else if (totalScore1 < totalScore2) {
            team1.setScore(0);
            team2.setScore(2);
        } else {
            team1.setScore(1);
            team2.setScore(1);
        }

        Match match= new Match(team1.getId(),totalScore1,team2.getId(), totalScore2);
        Integer idMatch =matchRepository.add(match);
        team1.getPlayers().forEach(player ->{ int k =0;
                PlayerStatisticsPerMatch playerStatisticsPerMatch = new PlayerStatisticsPerMatch(player.getId(),idMatch,arrayOfScores1[k]);
                playerStatisticsRepository.add(playerStatisticsPerMatch);
                k++; });
        team2.getPlayers().forEach(player ->{ int k =0;
            PlayerStatisticsPerMatch playerStatisticsPerMatch = new PlayerStatisticsPerMatch(player.getId(),idMatch,arrayOfScores2[k]);
            playerStatisticsRepository.add(playerStatisticsPerMatch);
            k++; });
        teamService.updateScore(team1.getId(),team1.getScore());
        teamService.updateScore(team2.getId(),team2.getScore());
        teamService.updateScoreEachPlayer(team1);
        teamService.updateScoreEachPlayer(team2);
    }

    private int scoreGenerator() {
        Random rand = new Random();
        int i = rand.nextInt(6);
        if (i == 2) {
            i = 2;
        } else if (i == 3) {
            i = 3;
        } else {
            i = 0;
        }
        return i;
    }

}
