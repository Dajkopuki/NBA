package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;

import java.util.List;

public interface PlayerService {
    Player get(int id);
    Integer add(Player player);
    List<Player> getPlayers();
    void delete(int id);
    void updateScore(int id, int score);
    List<PlayerStatisticsPerMatch> getPlayerRecord(int id);


}
