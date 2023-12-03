package com.example.application;

import javafx.scene.control.Button;
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;

public class Person {
    private String firstName;
    private String lastName;
    private String phone;
    private String orderFilePath;
    private Button orderButton;

    private String orderInfo;





    public Person(String firstName, String lastName, String phone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.orderButton = new Button("Open Order");
    }





    private void openOrderFile() {
        String fileName = phone + ".txt";
        File file = new File(fileName);

        if (file.exists()) {
            try {
                Desktop.getDesktop().edit(file);
            } catch (IOException e) {
                e.printStackTrace();

            }
        } else {
            System.out.println("File not found: " + fileName);

        }
    }

    //getter and setters
    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
    public String getOrderFilePath() {
        return orderFilePath;
    }

    public void setOrderFilePath(String orderFilePath) {
        this.orderFilePath = orderFilePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Button getOrderButton() {
        return orderButton;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}