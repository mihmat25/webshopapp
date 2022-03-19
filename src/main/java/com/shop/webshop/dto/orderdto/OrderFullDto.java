package com.shop.webshop.dto.orderdto;

import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;
import com.shop.webshop.model.Order;
import com.shop.webshop.model.Status;
import com.shop.webshop.model.User;

import java.util.Date;
import java.util.List;

public class OrderFullDto {
    private Integer id;
    private Integer userId;
    private String userAddress;
    private Double totalCost;
    private Date dateOfSubmission;
    private Status status;
    // TODO add orderlist
    private List<OrderLineFullDto> orderLines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderLineFullDto> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineFullDto> orderLines) {
        this.orderLines = orderLines;
    }
}
