package com.codegym.service;

import com.codegym.model.Statistic;
import com.codegym.model.Tour;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITourService {

    Page<Tour> findAll(Pageable pageable);

    boolean checkCondition(String tourId);

    void deleteById(String tourId);

    Tour save(Tour tour);

    List<Statistic> getStatistic();
}
