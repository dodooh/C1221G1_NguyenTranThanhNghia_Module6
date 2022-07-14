package com.codegym.service;


import com.codegym.repository.ITourTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.model.TourType;
import java.util.List;

@Service
public class TourTypeService implements ITourTypeService {

    @Autowired
    private ITourTypeRepository tourTypeRepository;

    @Override
    public List<TourType> findAll() {
        return this.tourTypeRepository.findAll();
    }
}
