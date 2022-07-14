package com.codegym.repository;

import com.codegym.model.Statistic;
import com.codegym.model.Tour;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ITourRepository extends JpaRepository<Tour, String> {
    Page<Tour> findAllByFlagIs(Boolean flag, Pageable pageable);
    Optional<Tour> findByTourIdAndFlagIs(String tourId, Boolean flag);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tour SET flag = 0 WHERE tour_id= :tourId", nativeQuery = true)
    void updateFlag(@Param("tourId") String tourId);

    @Query(value = "select customer_id as customerId, COUNT(*) as total "
        + "from registration where status_id = 2 GROUP BY customer_id order by total DESC; ", nativeQuery = true)
    List<Statistic> getStatistic();
}
