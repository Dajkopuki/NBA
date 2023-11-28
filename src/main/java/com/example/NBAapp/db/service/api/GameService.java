package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Team;

import java.util.List;

public interface GameService {
    void game(List<Team> teams);
    void restartGame();
    void listResults();

}
