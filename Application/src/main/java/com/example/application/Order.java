package com.example.application;

public class Order {

    private String phoneNum;
    private String clothesType;
    private String color;
    private String quantity;
    private String id;
    private String cost;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCost() {return cost;}
    public void setCost(String cost) {this.cost = cost;}


    public Order(String phoneNum, String clothesType, String color, String quantity, String id,String cost) {
        this.phoneNum = phoneNum;
        this.clothesType = clothesType;
        this.color = color;
        this.quantity = quantity;
        this.id = id;
        this.cost= cost;
    }

    public String createOrder(String phoneNum, String clothesType, String color, String quantity, String id, String cost){
        this.phoneNum = phoneNum;
        this.clothesType = clothesType;
        this.color = color;
        this.quantity = quantity;
        this.id = id;
        this.cost = cost;

        String order = "\n"+ this.id + " ////////////////////////////////////////" +
                "\n" + "Customer ID: " + this.phoneNum +"\n" + "Clothing Type: " + this.clothesType + "\n" +
                "Color: " + this.color + "\n" + "Quantity: " + this.quantity + "\n" + "Order ID: " + this.id + "\n" +
                "Cost: " + this.cost + "\n" + "//////////////////////////////////////// " + this.id;
        return order;
    }



}
