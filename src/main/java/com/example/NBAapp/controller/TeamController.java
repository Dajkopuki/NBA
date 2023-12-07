package com.example.NBAapp.controller;

import com.example.NBAapp.db.service.api.TeamService;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Team team) {
        Integer id = teamService.add(team);
        if(id !=null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Team team = teamService.get(id);
        if (team !=null) {
            return new ResponseEntity<>(team,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Team> teams = teamService.getTeams();
        return new ResponseEntity(teams,HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("List")
    public ResponseEntity getAllWithList() {
        List<Team> teams = teamService.getTeamsWithList();
        return new ResponseEntity(teams,HttpStatus.OK);
    }
}
