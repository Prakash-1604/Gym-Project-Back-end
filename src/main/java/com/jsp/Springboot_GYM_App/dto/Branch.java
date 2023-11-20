package com.jsp.Springboot_GYM_App.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;
    @NotNull(message="Email not be Null")
    private String branchEmail;
    @Min(6000000000l)
    @Max(9999999999l)
    private long branchPhone;
    private double branchTime;

    @OneToOne(cascade = CascadeType.ALL)
    private BranchHead branchHead;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainer> trainers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MemberShip> memberships;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    
    public BranchHead getBranchHead() {
        return branchHead;
    }

    public void setBranchHead(BranchHead branchHead) {
        this.branchHead = branchHead;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<MemberShip> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<MemberShip> memberships) {
        this.memberships = memberships;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchEmail() {
        return branchEmail;
    }

    public void setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail;
    }

    public long getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(long branchPhone) {
        this.branchPhone = branchPhone;
    }

    public double getBranchTime() {
        return branchTime;
    }

    public void setBranchTime(double branchTime) {
        this.branchTime = branchTime;
    }
}
