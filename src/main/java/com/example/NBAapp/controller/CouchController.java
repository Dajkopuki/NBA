package com.example.NBAapp.controller;

import com.example.NBAapp.db.service.api.CouchService;
import com.example.NBAapp.domain.Couch;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("couch")
public class CouchController {

    private final CouchService couchService;

    public CouchController(CouchService couchService) {
        this.couchService = couchService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid Couch couch, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            Integer id = couchService.add(couch);
            if (id != null) {
                return new ResponseEntity(id, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Couch couch = couchService.get(id);
        if (couch !=null) {
            return new ResponseEntity<>(couch,HttpStatus.OK);
        }
        return new ResponseEntity<>("Couch with id " + id + " does not exist",HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Couch> couches = couchService.getCouches();
        return new ResponseEntity(couches,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (couchService.get(id) !=null) {
            couchService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Couch with id " + id + "does not exist");
    }


}
