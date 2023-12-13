package com.example.NBAapp.db.service.imp;

import com.example.NBAapp.db.repository.CouchRepository;
import com.example.NBAapp.db.service.api.CouchService;
import com.example.NBAapp.domain.Couch;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CouchServiceImpl implements CouchService {

    private final CouchRepository couchRepository;

    public CouchServiceImpl(CouchRepository couchRepository) {
        this.couchRepository = couchRepository;
    }

    @Override
    public Couch get(int id) {
        return couchRepository.get(id);
    }

    @Override
    public Integer add(Couch couch) {
        return couchRepository.add(couch);
    }

    @Override
    public List<Couch> getCouches() {
        return couchRepository.getAll();
    }

    @Override
    public void delete(int id) {
        couchRepository.delete(id);
    }




}
