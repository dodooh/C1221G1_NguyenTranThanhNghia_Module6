package com.codegym.dto;

import com.codegym.model.Bound;
import com.codegym.model.Customer;
import com.codegym.model.TourType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TourDto implements Validator {
    private String tourName;
    private String destination;
    private String startDate;
    private String finishDate;
    private String closedRegisterDate;
    private Integer peopleAllowed;
    private String plans;
    private String participant_required;
    private Double cost;
    private Customer creator;
    private TourType tourType;
    private Bound bound;

    public TourDto() {
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getClosedRegisterDate() {
        return closedRegisterDate;
    }

    public void setClosedRegisterDate(String closedRegisterDate) {
        this.closedRegisterDate = closedRegisterDate;
    }

    public Integer getPeopleAllowed() {
        return peopleAllowed;
    }

    public void setPeopleAllowed(Integer peopleAllowed) {
        this.peopleAllowed = peopleAllowed;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }

    public String getParticipant_required() {
        return participant_required;
    }

    public void setParticipant_required(String participant_required) {
        this.participant_required = participant_required;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Customer getCreator() {
        return creator;
    }

    public void setCreator(Customer creator) {
        this.creator = creator;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TourDto tourDto = (TourDto) target;

        if (tourDto.getPeopleAllowed() == null || tourDto.getPeopleAllowed() < 0) {
            errors.rejectValue("peopleAllowed", "", "Số người tối đa không hợp lệ");
        }
    }
}
