package com.example.NBAapp.db.repository;

import com.example.NBAapp.domain.Player;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player,Integer> {

    @Query("SELECT p FROM Player p WHERE p.teamId = :teamId")
    List<Player> getPlayersFromTeam(int teamId);



    @Modifying
    @Transactional
    @Query("UPDATE Player p SET p.score = :score WHERE p.id = :id")
    void updateScore(int id, int score);

    @Modifying
    @Transactional
    @Query("UPDATE Player SET score =0")
    void setScoreToZero();
}
