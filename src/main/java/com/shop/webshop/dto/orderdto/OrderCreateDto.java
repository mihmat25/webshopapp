package com.shop.webshop.dto.orderdto;

import com.shop.webshop.model.Status;
import com.shop.webshop.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class OrderCreateDto {
    // TODO make user id
    private User user;
    private String userAddress;
    private Double totalCost;
    private LocalDateTime dateOfSubmission;
    private Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(LocalDateTime dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}


