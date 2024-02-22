package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.service.repository.PlayerStatisticsRepository;
import com.example.NBAapp.db.service.api.PlayerStatisticsService;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerStatisticsServiceImpl implements PlayerStatisticsService {

    private final PlayerStatisticsRepository playerStatisticsRepository;


    public PlayerStatisticsServiceImpl(PlayerStatisticsRepository playerStatisticsRepository, PlayerStatisticsRepository playerStatisticsRepositoryTest) {
        this.playerStatisticsRepository = playerStatisticsRepository;

    }

    @Override
    public Optional<PlayerStatisticsPerMatch> get(int id) {
        return playerStatisticsRepository.findById(id);
    }

    @Override
    public PlayerStatisticsPerMatch add(PlayerStatisticsPerMatch playerStatisticsPerMatch) {
        return  playerStatisticsRepository.save(playerStatisticsPerMatch);
    }



    @Override
    public void deleteAll() {
        playerStatisticsRepository.deleteAll();
    }
}
