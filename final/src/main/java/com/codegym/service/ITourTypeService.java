package com.codegym.service;

import com.codegym.model.Tour;
import com.codegym.model.TourType;
import java.util.List;
import org.springframework.data.domain.Page;

public interface ITourTypeService {

    List<TourType> findAll();
}
