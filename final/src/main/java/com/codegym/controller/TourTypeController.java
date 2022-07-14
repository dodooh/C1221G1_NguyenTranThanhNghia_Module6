package com.codegym.controller;


import com.codegym.model.TourType;
import com.codegym.service.ITourTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/tour-types")
public class TourTypeController {

    @Autowired
    private ITourTypeService tourTypeService;

    @GetMapping
    public ResponseEntity<List<TourType>> findAll() {
        List<TourType> tourTypes = this.tourTypeService.findAll();
        return ResponseEntity.ok(tourTypes);
    }

}
