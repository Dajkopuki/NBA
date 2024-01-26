package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.PlayerStatisticsPerMatch;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Optional<Player> get(int id);
    Player add(Player player);
    List<Player> getPlayers();
    void delete(int id);
    void updateScore(int id, int score);

    List<PlayerStatisticsPerMatch> getPlayerRecord(int playerId);
    void setScoreToZero();


}
