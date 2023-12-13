package com.example.NBAapp.controller;

import com.example.NBAapp.db.service.imp.GameServiceImpl;
import com.example.NBAapp.db.service.imp.TeamServiceImpl;
import com.example.NBAapp.domain.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    private final GameServiceImpl gameService;
    private final TeamServiceImpl teamService;

    public GameController(GameServiceImpl gameService, TeamServiceImpl teamService) {
        this.gameService = gameService;
        this.teamService = teamService;
    }
    @GetMapping("play")
    public ResponseEntity playGame() {
        List<Team> teams = teamService.getTeamsWithList();
        gameService.game(teams);
        teams = teamService.getTeams();
        gameService.sortTeams(teams);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping("restart")
    public ResponseEntity restartGame() {
        gameService.restartGame();
        return new ResponseEntity("Game was restarted",HttpStatus.OK);
    }

}
