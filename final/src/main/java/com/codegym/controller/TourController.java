package com.codegym.controller;


import com.codegym.dto.TourDto;
import com.codegym.model.Statistic;
import com.codegym.model.Tour;
import com.codegym.service.ITourService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/tours")
public class TourController {

    @Autowired
    private ITourService tourService;

    @GetMapping
    public ResponseEntity<Page<Tour>> findAllTours(@PageableDefault(size = 20)Pageable pageable) {
        Page<Tour> tours = this.tourService.findAll(pageable);
        return ResponseEntity.ok(tours);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTourById(@PathVariable("id") String tourId) {
        boolean canDelete = this.tourService.checkCondition(tourId);
        if (canDelete) {
            this.tourService.deleteById(tourId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Validated TourDto tourDto, BindingResult bindingResult) {
        new TourDto().validate(tourDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> errorMap = new HashMap<>();
            for(FieldError fe : bindingResult.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
        }
        Tour tour = new Tour();
        BeanUtils.copyProperties(tourDto, tour);
        Tour savedTour = this.tourService.save(tour);
        return ResponseEntity.ok(savedTour);
    }

    @GetMapping("statistic")
    public ResponseEntity<List<Statistic>> getStatistic() {
        List<Statistic> statistics = this.tourService.getStatistic();
        return ResponseEntity.ok(statistics);
    }


}
