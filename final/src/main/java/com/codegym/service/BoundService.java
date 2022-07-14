package com.codegym.service;

import com.codegym.model.Bound;
import com.codegym.repository.IBoundRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoundService implements IBoundService{
    @Autowired
    private IBoundRepository boundRepository;


    @Override
    public List<Bound> findAll() {
        return this.boundRepository.findAll();
    }
}
