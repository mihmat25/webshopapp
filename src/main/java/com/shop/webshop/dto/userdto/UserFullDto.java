package com.shop.webshop.dto.userdto;

public class UserFullDto {
    private Integer id;
    private String userName;
    private String email;
    private String address;

    public UserFullDto(Integer id, String userName, String email, String address) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
