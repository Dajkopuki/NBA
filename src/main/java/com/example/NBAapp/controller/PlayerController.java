package com.example.NBAapp.controller;

import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.domain.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity add (@RequestBody Player player) {
        Integer id = playerService.add(player);
        if(id!=null) {
           return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Player player = playerService.get(id);
        if (player !=null) {
            return new ResponseEntity<>(player,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Player> players = playerService.getPlayers();
        return new ResponseEntity(players,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (playerService.get(id) !=null) {
            playerService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Player with id " + id + "does not exist");
    }

}
