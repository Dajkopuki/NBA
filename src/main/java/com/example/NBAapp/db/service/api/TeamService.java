package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> get (int id);
    Team getWithList (int id);
    List<Team> getTeams();
    List<Team> getTeamsWithList();
    Team add(Team team);
    void delete(int id);
    void updateScore(int id, int score);
    void updateScoreEachPlayer(Team team);
    void setScoreToZero();
}
