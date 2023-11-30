package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.CouchRepository;
import com.example.NBAapp.db.repository.PlayerRepository;
import com.example.NBAapp.db.repository.TeamRepository;
import com.example.NBAapp.db.service.api.TeamService;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final CouchRepository couchRepository;

    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository, CouchRepository couchRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.couchRepository = couchRepository;
    }

    @Override
    public Team get(int id) {
       return teamRepository.get(id);
    }

    @Override
    public Team getWithList(int id) {
        Team team = teamRepository.get(id);
        team.setPlayers(playerRepository.getPlayersFromTeam(id));
        team.setCouch(couchRepository.getByTeam(id));
        return team;
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    @Override
    public List<Team> getTeamsWithList() {
        List<Team> teams = teamRepository.getTeams();
        teams.forEach(team -> {team.setPlayers(playerRepository.getPlayersFromTeam(team.getId()));
                               team.setCouch(couchRepository.getByTeam(team.getId()));});
        return teams;
    }

    @Override
    public Integer add(Team team) {
         return teamRepository.add(team);
    }

    @Override
    public void delete(int id) {
     teamRepository.delete(id);
    }

    @Override
    public void updateScore(int id, int score) {
        Team team =teamRepository.get(id);
        teamRepository.updateScore(id,team.getScore()+score);
    }

//    @Override
//    public void updateScoreEachPlayer(Team team) {
//        team.getPlayers().forEach(player -> {
//            playerRepository.updateScore(player.getId(),(player.getScore()==null ? 0 : player.getScore())+(playerRepository.get(player.getId()).getScore() == null ? 0 :playerRepository.get(player.getId()).getScore()));});
//    }

    @Override
    public void updateScoreEachPlayer(Team team) {
        team.getPlayers().forEach(player -> {

            int playerScore = player.getScore() == null ? 0 : player.getScore();
//            Player currentPlayer = playerRepository.get(player.getId());
//            int currentPlayerScore = currentPlayer.getScore() == null ? 0 : currentPlayer.getScore();
//            int score = playerScore + currentPlayerScore;

            // ulozim skore playera spat do databazy
            playerRepository.updateScore(player.getId(), playerScore);
        });
    }
}
