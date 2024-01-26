package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Couch;

import java.util.List;
import java.util.Optional;

public interface CouchService {
    Optional<Couch> get(int id);
    Couch add(Couch couch);
    List<Couch> getCouches();
    void delete(int id);


}
