package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.PlayerStatisticsPerMatch;

import java.util.List;
import java.util.Optional;

public interface PlayerStatisticsService {

    Optional<PlayerStatisticsPerMatch> get(int id);
    PlayerStatisticsPerMatch add(PlayerStatisticsPerMatch playerStatisticsPerMatch);

    void deleteAll();

}
