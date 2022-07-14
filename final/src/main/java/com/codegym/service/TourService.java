package com.codegym.service;


import com.codegym.model.Statistic;
import com.codegym.model.Tour;
import com.codegym.repository.IRegistrationRepository;
import com.codegym.repository.ITourRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TourService implements ITourService {

    @Autowired
    private ITourRepository tourRepository;
    @Autowired
    private IRegistrationRepository registrationRepository;

    @Override
    public Page<Tour> findAll(Pageable pageable) {
        return this.tourRepository.findAllByFlagIs(true, pageable);
    }

    @Override
    public boolean checkCondition(String tourId) {
        boolean isExistInTour = this.tourRepository.findByTourIdAndFlagIs(tourId, true)
            .isPresent();
        if (!isExistInTour) {
            return false;
        }
        Integer totalNumberRegistration = this.registrationRepository.countTotalByTourId(tourId);
        return totalNumberRegistration == null || totalNumberRegistration <= 0;
    }

    @Override
    public void deleteById(String tourId) {
        this.tourRepository.updateFlag(tourId);
    }

    @Override
    public Tour save(Tour tour) {
        return this.tourRepository.save(tour);
    }

    @Override
    public List<Statistic> getStatistic() {
        return this.tourRepository.getStatistic();
    }
}
