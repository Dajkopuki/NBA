package com.example.NBAapp.db.service.repository;

import com.example.NBAapp.domain.PlayerStatisticsPerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatisticsPerMatch,Integer> {

    @Query("SELECT p FROM PlayerStatisticsPerMatch p WHERE p.playerId = :playerId")
    List<PlayerStatisticsPerMatch> getPlayerRecord (int playerId);

    List<PlayerStatisticsPerMatch> findPlayerStatisticsPerMatchListByPlayerId (int playerId);

}
