package com.example.NBAapp.db.service.repository;

import com.example.NBAapp.domain.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Team t SET t.score = :score WHERE t.id = :id")
    void updateScore(int id, int score);

    @Modifying
    @Transactional
    @Query("UPDATE Team SET score =0")
    void setScoreToZero();

}
