package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Couch;

import java.util.List;

public interface CouchService {
    Couch get(int id);
    Integer add(Couch couch);
    List<Couch> getCouches();
    void delete(int id);


}
