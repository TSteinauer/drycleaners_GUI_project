package com.example.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Scene login = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(login);
        stage.show();
    }
        public static void main(String[] args) {
        launch(args);
    }
}



