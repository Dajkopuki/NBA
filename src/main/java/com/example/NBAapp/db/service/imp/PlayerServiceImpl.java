package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.PlayerRepository;
import com.example.NBAapp.db.repository.PlayerStatisticsRepository;
import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl  implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerRepository = playerRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    @Override
    public Player get(int id) {
        return playerRepository.get(id);
    }

    @Override
    public Integer add(Player player) {
        return playerRepository.add(player);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.getPlayers();
    }

    @Override
    public void delete(int id) {
        playerRepository.delete(id);
    }

    @Override
    public void updateScore(int id, int score) {
    playerRepository.updateScore(id,score);
    }

    @Override
    public List<PlayerStatisticsPerMatch> getPlayerRecord(int id) {
        return playerStatisticsRepository.getPlayerRecord(id);
    }

    @Override
    public void setScoreToZero() {
        playerRepository.setScoreToZero();
    }


}
