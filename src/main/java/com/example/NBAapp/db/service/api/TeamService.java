package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Team;

import java.util.List;

public interface TeamService {
    Team get (int id);
    Team getWithList (int id);
    List<Team> getTeams();
    List<Team> getTeamsWithList();
    Integer add(Team team);
    void delete(int id);
    void updateScore(int id, int score);
}
