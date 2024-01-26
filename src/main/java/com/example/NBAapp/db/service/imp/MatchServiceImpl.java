package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.MatchRepository;
import com.example.NBAapp.db.service.api.MatchService;
import com.example.NBAapp.domain.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;


    public MatchServiceImpl(MatchRepository matchRepository, MatchRepository matchRepositoryTest) {
        this.matchRepository = matchRepository;

    }

    @Override
    public Optional<Match> get(int id) {
        return matchRepository.findById(id);
    }

    @Override
    public Match add(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteAll() {
        matchRepository.deleteAll();
    }

    @Override
    public List<Match> getMatches() {
        return (List<Match>) matchRepository.findAll();
    }


}
