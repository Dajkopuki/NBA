package com.example.NBAapp.db.service.repository;

import com.example.NBAapp.domain.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Integer> {

}
