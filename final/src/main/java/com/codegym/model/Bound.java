package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"tourList"})
public class Bound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boundId;
    private String boundName;
    @OneToMany(mappedBy = "bound")
    private List<Tour> tourList;

    public Integer getBoundId() {
        return boundId;
    }

    public void setBoundId(Integer boundId) {
        this.boundId = boundId;
    }

    public String getBoundName() {
        return boundName;
    }

    public void setBoundName(String boundName) {
        this.boundName = boundName;
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }

    public Bound() {
    }
}
