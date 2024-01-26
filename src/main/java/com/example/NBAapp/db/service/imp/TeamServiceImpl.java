package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.CouchRepository;
import com.example.NBAapp.db.repository.PlayerRepository;
import com.example.NBAapp.db.repository.TeamRepository;
import com.example.NBAapp.db.service.api.TeamService;
import com.example.NBAapp.domain.Team;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final CouchRepository couchRepository;





    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository, CouchRepository couchRepository, CouchRepository couchRepositoryTest, TeamRepository teamRepositoryTest) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.couchRepository = couchRepository;



    }

    @Override
    public Optional<Team> get(int id) {
       return teamRepository.findById(id);
    }

    @Override
    public Team getWithList(int id) {
        Optional<Team> team = teamRepository.findById(id);
        team.get().setPlayers(playerRepository.getPlayersFromTeam(id));
        team.get().setCouch(couchRepository.getByTeam(id));
        return team.get();
    }

    @Override
    public List<Team> getTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public List<Team> getTeamsWithList() {
        List<Team> teams = (List<Team>) teamRepository.findAll();
        teams.forEach(team -> {team.setPlayers(playerRepository.getPlayersFromTeam(team.getId()));
                               team.setCouch(couchRepository.getByTeam(team.getId()));});
        return teams;
    }

    @Override
    public Team add(Team team) {
         return teamRepository.save(team);
    }

    @Override
    public void delete(int id) {
     teamRepository.deleteById(id);
    }

    @Override
    public void updateScore(int id, int score) {
        Team team = teamRepository.findById(id).get();
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

    @Override
    public void setScoreToZero() {
        teamRepository.setScoreToZero();
    }
}
