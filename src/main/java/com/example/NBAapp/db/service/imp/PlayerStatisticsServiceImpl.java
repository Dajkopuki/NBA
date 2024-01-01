package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.PlayerStatisticsRepository;
import com.example.NBAapp.db.service.api.PlayerStatisticsService;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerStatisticsServiceImpl implements PlayerStatisticsService {

    private final PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerStatisticsServiceImpl(PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    @Override
    public PlayerStatisticsPerMatch get(int id) {
        return playerStatisticsRepository.get(id);
    }

    @Override
    public Integer add(PlayerStatisticsPerMatch playerStatisticsPerMatch) {
        return playerStatisticsRepository.add(playerStatisticsPerMatch);
    }



    @Override
    public void deleteAll() {
        playerStatisticsRepository.deleteAll();
    }
}
