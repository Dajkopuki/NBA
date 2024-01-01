package com.example.NBAapp.db.service.api;

import com.example.NBAapp.domain.Match;

import java.util.List;

public interface MatchService {
    Match get(int id);
    Integer add (Match match);
    void deleteAll();
    List<Match> getMatches();
}
