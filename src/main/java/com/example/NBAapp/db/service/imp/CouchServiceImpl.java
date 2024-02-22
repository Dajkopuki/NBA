package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.service.repository.CouchRepository;
import com.example.NBAapp.db.service.api.CouchService;
import com.example.NBAapp.domain.Couch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouchServiceImpl implements CouchService {

    private final CouchRepository couchRepository;


    public CouchServiceImpl(CouchRepository couchRepository, CouchRepository couchRepositoryTest) {
        this.couchRepository = couchRepository;

    }

    @Override
    public Optional<Couch> get(int id) {
        return couchRepository.findById(id);
    }

    @Override
    public Couch add(Couch couch) {
        return couchRepository.save(couch);
    }

    @Override
    public List<Couch> getCouches() {
        return (List<Couch>) couchRepository.findAll();
    }

    @Override
    public void delete(int id) {
        couchRepository.deleteById(id);
    }




}
