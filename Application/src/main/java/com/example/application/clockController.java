package com.example.application;


import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class clockController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField cashID;

    @FXML
    private Button clockIn;

    @FXML
    private Button clockOut;

    @FXML
    private TextField date;

    public String inTime;
    public String outTime;



    @FXML
    void clock_In(ActionEvent event) {
        String fileName = "Employees" + File.separator + cashID.getText() + ".txt";
        File userFile = new File(fileName);
        LocalTime now = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        inTime = now.format(dtf);
        try (PrintWriter pw = new PrintWriter(new FileWriter(userFile, true))){

            pw.println("/////////////////Clock In/////////////////");
            pw.println("Date: " + date.getText());
            pw.println("Time: " + inTime);
            pw.println("/////////////////Clock In/////////////////");
            System.out.println("User " + cashID.getText() +"'s HAS CLOCKED IN at: " + inTime);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buttonAnimation(clockIn);

    }

    @FXML
    void clock_Out(ActionEvent event) {
        String fileName = "Employees" + File.separator + cashID.getText() + ".txt";
        File userFile = new File(fileName);
        LocalTime now = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        outTime = now.format(dtf);

        try (PrintWriter pw = new PrintWriter(new FileWriter(userFile, true))) {
            pw.println("/////////////////Clock Out/////////////////");
            pw.println("Date: " + date.getText());
            pw.println("Time: " + outTime);
            pw.println("/////////////////Clock Out/////////////////");
            System.out.println("User " + cashID.getText() + "'s clock in/out File has been successfully updated CLOCK OUT AT: " + outTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buttonAnimation(clockOut);
    }

    private void buttonAnimation(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setByX(0.1);
        scaleTransition.setByY(0.1);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }


    public void switchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void addNewCust(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("new-customer.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void findCustomer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("find-customer.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void clothesTagIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tag-in.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void clockIn(ActionEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("clock-in.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
