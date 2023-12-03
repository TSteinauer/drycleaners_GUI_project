package com.example.application;

import java.awt.*;
import java.io.*;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;


public class FindCustController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button loadBttn;
    @FXML
    public Button findBttn;

    @FXML
    public TextField surFname;
    @FXML
    public TextField surLname;
    @FXML
    public TextField surPhone;
    @FXML
    public TextField surPhone1;

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private TableColumn<Person, String> phone;

    @FXML
    private TableColumn<Person, String> orderInfo;

    @FXML
    private TableView<Person> table;

    private ObservableList<Person> personList = FXCollections.observableArrayList();


    @FXML
    public void saveBttn() {
        if (!surFname.getText().isEmpty() || !surLname.getText().isEmpty() || !surPhone.getText().isEmpty()) {
            // Save the current data to a file
            File file = new File(surPhone.getText() + ".txt");
            try (PrintWriter pw = new PrintWriter(file)) {
                pw.println(surFname.getText());
                pw.println(surLname.getText());
                pw.println(surPhone.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Person newData = new Person(surFname.getText(), surLname.getText(), surPhone.getText());
            personList.add(newData);

            surFname.clear();
            surLname.clear();
            surPhone.clear();


            refreshTable();

        }
        buttonAnimation(loadBttn);
    }

    @FXML
    public void initialize() {
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        orderInfo.setCellFactory(col -> new TableCell<>() {
            final Button orderButton = new Button("Open Order");

            {
                orderButton.setOnAction(event -> {
                    TableRow<?> row = getTableRow();
                    if (row != null && row.getItem() instanceof Person) {
                        Person person = (Person) row.getItem();
                        String fileName = person.getPhone() + ".txt";
                        openOrderFile(fileName);
                    }
                });
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(orderButton);
                }
            }
        });


        loadExistingData();
    }

    private void loadExistingData() {
        File dataDirectory = new File(".");
        File[] dataFiles = dataDirectory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (dataFiles != null) {
            for (File file : dataFiles) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String fName = br.readLine();
                    String lName = br.readLine();
                    String phone = br.readLine();

                    // Add the loaded data to the list
                    Person loadedPerson = new Person(fName, lName, phone);
                    personList.add(loadedPerson);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        refreshTable();
    }

    private void refreshTable() {
        table.getItems().setAll(personList);
    }

    private void openOrderFile(String fileName) {
        try {
            File file = new File(fileName);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                // Handle the case where Desktop is not supported (e.g., on some environments)
                System.out.println("Desktop is not supported on this platform.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    void find_cust(ActionEvent event){
        String phoneNumberToSearch = surPhone1.getText();

        int indexOfMatchingCustomer = -1;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getPhone().equals(phoneNumberToSearch)) {
                indexOfMatchingCustomer = i;
                break;
            }
        }
        if (indexOfMatchingCustomer != -1) {
            Person matchingCustomer = personList.remove(indexOfMatchingCustomer);
            personList.add(0, matchingCustomer);
            table.setItems(FXCollections.observableArrayList(personList));
        } else {
            System.out.println("Customer not found for phone number: " + phoneNumberToSearch);
        }
        buttonAnimation(findBttn);
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
    public void clockIn(ActionEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("clock-in.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}




