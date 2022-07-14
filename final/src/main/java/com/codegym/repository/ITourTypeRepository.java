package com.codegym.repository;

import com.codegym.model.TourType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITourTypeRepository extends JpaRepository<TourType, Integer> {

}
