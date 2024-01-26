package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.PlayerRepository;
import com.example.NBAapp.db.repository.PlayerStatisticsRepository;
import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl  implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;


    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerRepository = playerRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;

    }

    @Override
    public Optional<Player> get(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player add(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public void delete(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void updateScore(int id, int score) {
    playerRepository.updateScore(id,score);
    }

    @Override
    public List<PlayerStatisticsPerMatch> getPlayerRecord(int playerId) {
        return playerStatisticsRepository.getPlayerRecord(playerId);
    }


    @Override
    public void setScoreToZero() {
        playerRepository.setScoreToZero();
    }


}
