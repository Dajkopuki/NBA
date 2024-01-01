package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.PlayerStatisticsPerMatch;

import java.util.List;

public interface PlayerStatisticsService {

    PlayerStatisticsPerMatch get(int id);
    Integer add(PlayerStatisticsPerMatch playerStatisticsPerMatch);

    void deleteAll();

}
