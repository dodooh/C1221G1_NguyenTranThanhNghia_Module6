package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
@JsonIgnoreProperties({"registrationList"})
public class Tour {
    @Id
    @GeneratedValue(generator = "id-generator")
    @GenericGenerator(name = "id-generator",
        parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "TR"),
        strategy = "com.codegym.utils.IdentityCodeGenerator")
    private String tourId;
    private String tourName;
    private String destination;
    private String startDate;
    private String finishDate;
    private String closedRegisterDate;
    private Integer peopleAllowed;
    private String plans;
    private String participant_required;
    private Double cost;
    private Boolean flag = true;
    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "customerId")
    private Customer creator;
    @ManyToOne
    @JoinColumn(name = "tour_type_id", referencedColumnName = "tourTypeId")
    private TourType tourType;
    @ManyToOne
    @JoinColumn(name = "bound_id", referencedColumnName = "boundId")
    private Bound bound;
    @OneToMany(mappedBy = "tour")
    private List<Registration> registrationList;

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
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

    public Tour() {
    }
}
