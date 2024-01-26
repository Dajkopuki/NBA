package com.example.NBAapp.db.repository;

import com.example.NBAapp.domain.Couch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CouchRepository extends CrudRepository<Couch,Integer> {

    @Query("SELECT c FROM Couch c WHERE c.TeamId = :teamId")
    Couch getByTeam(int teamId);
}
