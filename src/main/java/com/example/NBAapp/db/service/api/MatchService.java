package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Match;

import java.util.List;
import java.util.Optional;

public interface MatchService {
    Optional<Match> get(int id);
    Match add (Match match);
    void deleteAll();
    List<Match> getMatches();
}
