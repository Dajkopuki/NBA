package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.MatchRepository;
import com.example.NBAapp.db.service.api.MatchService;
import com.example.NBAapp.domain.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match get(int id) {
        return matchRepository.get(id);
    }

    @Override
    public Integer add(Match match) {
        return matchRepository.add(match);
    }

    @Override
    public void deleteAll() {
        matchRepository.deleteAll();
    }

    @Override
    public List<Match> getMatches() {
        return matchRepository.getMatches();
    }


}
