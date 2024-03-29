package com.example.NBAapp.controller;

import com.example.NBAapp.db.service.api.TeamService;
import com.example.NBAapp.domain.CreateValidationGroup;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Validated (CreateValidationGroup.class) Team team, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            Team teamFromDb = teamService.add(team);
            Integer id =teamFromDb.getId();
            if (id != null) {
                return new ResponseEntity<>(id, HttpStatus.CREATED);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Optional<Team> team = teamService.get(id);
        if (team.isPresent()) {
            return new ResponseEntity<>(team,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Team> teams = teamService.getTeams();
        return new ResponseEntity(teams,HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity getAllWithList() {
        List<Team> teams = teamService.getTeamsWithList();
        return new ResponseEntity(teams,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (teamService.get(id) !=null) {
            teamService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Team with id " + id + "does not exist");
    }
}
