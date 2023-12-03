package com.example.application;

import javafx.animation.ScaleTransition;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class HelloController {

    @FXML
    private Label ferror;
    @FXML
    private Label lerror;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private Button login;
    @FXML
    private Button home;
    @FXML
    private ImageView Limage;
    @FXML
    private Pane numPane;
    @FXML
    private TextField key;
    @FXML
    private Label kerror;


    public String loginCode;
    String firstN;
    String lastN;
    char fChar;
    char lChar;
    String initials;
    Random random = new Random();

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void bttn_pressed(MouseEvent event) {
        login.setStyle("-fx-background-color:#A2A9A8");


    }

    @FXML
    void bttn_released(MouseEvent event) {
        login.setStyle("-fx-background-color:#76D7C4");


    }

    @FXML
    void drag_shadow(MouseEvent event) {
        login.setStyle("-fx-border-color:RED;");
        login.setStyle("-fx-border-width:2;");

    }

    @FXML
    void drop_shadow(MouseEvent event) {

        login.setStyle("-fx-border-color:RED;");
        login.setStyle("-fx-border-width:10;");


    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private void buttonAnimation(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setByX(0.1);
        scaleTransition.setByY(0.1);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }


    @FXML
    void login_action(ActionEvent event) {
        buttonAnimation(login);
        if (key.getText().length() != 4) {
            kerror.setText("Must be 4 digits");
        } else {
            if (isNumeric(fname.getText()) || isNumeric(lname.getText())) {
                lerror.setText("Letters/characters only!");
                ferror.setText("Letters/characters only!");
            } else {

                firstN = fname.getText();
                lastN = lname.getText();
                fChar = firstN.charAt(0);
                lChar = lastN.charAt(0);
                initials = String.valueOf(fChar) + lChar;
                loginCode = key.getText();
                ferror.setText("Hey  " + firstN + "  " + lastN);
                lerror.setText("Your Initals are: " + fChar + lChar + "     Your key is: " + loginCode);

                String fileName = "Employees"+ File.separator +loginCode + ".txt";
                File userFile = new File(fileName);
                if (userFile.exists()) {
                    System.out.println("Your file is already in our system");
                } else {
                    try {
                        if (userFile.createNewFile()) {
                            System.out.println("User File created successfully.");
                            try (PrintWriter pw = new PrintWriter(userFile)) {
                                pw.println("User File: " + loginCode);
                                pw.println("Name: " + firstN + " " + lastN);

                            }
                        } else {
                            System.out.println("Unable to create user file.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while creating user file.");
                        e.printStackTrace();
                    }
                }

            }
            boolean isdisabled = (!firstN.isEmpty() || !firstN.trim().isEmpty() || !lastN.isEmpty() || !lastN.trim().isEmpty() || isNumeric(fname.getText()) || isNumeric(lname.getText()));
            boolean disabled = (firstN.isEmpty() || firstN.trim().isEmpty() || lastN.isEmpty() || lastN.trim().isEmpty());
            home.setVisible(isdisabled);
            home.setDisable(disabled);
            numPane.setStyle("-fx-background-color: white;");
            buttonAnimation(home);

        }
    }
}





