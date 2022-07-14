package com.codegym.controller;

import com.codegym.model.Bound;
import com.codegym.service.IBoundService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/bounds")
public class BoundController {

    @Autowired
    private IBoundService boundService;

    @GetMapping
    public ResponseEntity<List<Bound>> findAll() {
        List<Bound> bounds = this.boundService.findAll();
        return ResponseEntity.ok(bounds);
    }
}
