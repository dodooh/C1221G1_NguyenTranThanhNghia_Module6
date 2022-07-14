package com.codegym.repository;

import com.codegym.model.Registration;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRegistrationRepository extends JpaRepository<Registration, Integer> {

    Boolean existsRegistrationByTour_TourId(String tourId);

    @Query(value = "Select SUM(COALESCE(number_of_customers, 0)) as total "
        + "from registration where status_id = 2 AND tour_id = :tourId group by tour_id", nativeQuery = true)
    Integer countTotalByTourId(String tourId);
}
