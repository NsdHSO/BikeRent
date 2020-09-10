package com.example.bikerental.renterModel;

import java.util.Random;

public class Renter {
    private String email;
    private String nickName;
    private String id;
    private int price;



    private Random random;




    public Renter(){

    }

    public Renter(String email, String nickName,int price) {
        this.email = email;
        this.nickName = nickName;
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
