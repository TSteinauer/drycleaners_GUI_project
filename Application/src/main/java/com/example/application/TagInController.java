package com.example.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.*;

public class TagInController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField Tcolor;

    @FXML
    private TextField Tid;

    @FXML
    private TextField Tphone;

    @FXML
    private TextField Tquantity;

    @FXML
    private TextField Ttype;
    @FXML
    private TextField cost;





    @FXML
    void submitOrder(ActionEvent event) {
        if(!Tphone.getText().isEmpty()||!Ttype.getText().isEmpty()||!Tcolor.getText().isEmpty()||!Tquantity.getText().isEmpty()
                ||!Tid.getText().isEmpty()||!cost.getText().isEmpty())
        {
            try {
                int quantity = Integer.parseInt(Tquantity.getText());
                float the_cost = Float.parseFloat(cost.getText());
                if (quantity <= 0 && the_cost <= 0) {
                    // Handle invalid quantity
                    // For example, display an error message to the user
                    System.out.println("Invalid quantity. Please enter a positive integer.");
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle non-integer input for quantity
                // For example, display an error message to the user
                System.out.println("Invalid quantity. Please enter a valid number.");
                return;
            }

            File file = new File(Tphone.getText() + ".txt");
            Order order = new Order(Tphone.getText(), Ttype.getText(), Tcolor.getText(),Tquantity.getText(),Tid.getText(),cost.getText());
            String createOrder = order.createOrder(Tphone.getText(), Ttype.getText(), Tcolor.getText(),Tquantity.getText(),
                    Tid.getText(),cost.getText());

            try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))){
                pw.print(createOrder);
                Tphone.clear();
                Ttype.clear();
                Tcolor.clear();
                Tquantity.clear();
                Tid.clear();
                cost.clear();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }





    @FXML
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
    @FXML
    public void clockIn(ActionEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("clock-in.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}