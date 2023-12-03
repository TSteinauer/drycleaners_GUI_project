package com.example.application;

import javafx.animation.ScaleTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class newCust {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String targetFile;
    private String targetOrder;

    @FXML
    private Button submit;
    @FXML
    private Button checkout;
    @FXML
    private TextField surPhone;
    @FXML
    private TextField surOrder_id;
    @FXML
    private TextArea display;



    @FXML
    void pickupSub(ActionEvent event) {
        targetFile = surPhone.getText() + ".txt";
        targetOrder = surOrder_id.getText();

        try (BufferedReader br = new BufferedReader(new FileReader(targetFile))) {
            String displayText;
            StringBuilder text = new StringBuilder();
            boolean withinOrder = false;
            int linesToCopy = 8;

            while ((displayText = br.readLine()) != null) {
                if (displayText.contains(targetOrder)) {
                    withinOrder = true;
                }

                if (withinOrder) {
                    text.append(displayText).append("\n");
                    linesToCopy--;

                    if (linesToCopy == 0) {
                        // Copying is complete
                        break;
                    }
                }
            }

            display.setText(text.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buttonAnimation(submit);
        checkout.setDisable(false);
    }


    @FXML
    void checkOut(ActionEvent event) {
        targetFile = surPhone.getText() + ".txt";
        targetOrder = surOrder_id.getText();

        try (BufferedReader br = new BufferedReader(new FileReader(targetFile))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(targetOrder)) {
                    // Skip 8 lines to exclude the entire order
                    for (int i = 0; i < 7; i++) {
                        br.readLine();
                    }
                } else {
                    lines.add(line);
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
                for (String rewrite : lines) {
                    bw.write(rewrite);
                    bw.newLine();
                }
            }

            display.setText("Order Checked Out successfully!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            buttonAnimation(checkout);
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
