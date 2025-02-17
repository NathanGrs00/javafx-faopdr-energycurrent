package com.nathan.javafxperiode2faopdrenergiecurrent.view;

import com.nathan.javafxperiode2faopdrenergiecurrent.controller.CustomerController;
import com.nathan.javafxperiode2faopdrenergiecurrent.service.UtilityService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class CustomerView {
    UtilityService util = new UtilityService();
    CustomerController customerController = new CustomerController();

    public void setCustomer(Stage primaryStage){
        // User input for Customer class.
        TextField inputCustomerID = new TextField();
        VBox vboxID = util.createLabeledInput("Customer ID:", "Customer ID", inputCustomerID);
        inputCustomerID.getStyleClass().add("input-customer-id");

        TextField inputFirstName = new TextField();
        VBox vboxFirstName = util.createLabeledInput("First name:", "First name", inputFirstName);
        inputFirstName.getStyleClass().add("input-first-name");

        TextField inputLastName = new TextField();
        VBox vboxLastName = util.createLabeledInput("Last name:", "Last name", inputLastName);
        inputLastName.getStyleClass().add("input-last-name");

        TextField inputAdvance = new TextField();
        VBox vboxAdvance = util.createLabeledInput("Advance:", "Advance", inputAdvance);
        inputAdvance.getStyleClass().add("input-advance");

        // Sending data to the controller to validate it.
        Button buttonSend = new Button("Send");
        buttonSend.setOnAction(e -> {
            customerController.ValidateFields(inputCustomerID, inputFirstName, inputLastName, inputAdvance, primaryStage);
        });

        // Setting styling.
        VBox inputFieldsCustomer = new VBox(vboxID, vboxFirstName, vboxLastName, vboxAdvance, buttonSend);
        inputFieldsCustomer.setAlignment(Pos.CENTER_LEFT);
        inputFieldsCustomer.setSpacing(12);
        inputFieldsCustomer.setPadding(new Insets(0,20,0,20));
        Scene scene = new Scene(inputFieldsCustomer, 480, 270);

        scene.getStylesheets().add(Objects.requireNonNull(
                getClass().getResource("/com/nathan/javafxperiode2faopdrenergiecurrent/stylesheet.css")
        ).toExternalForm());

        //Setting icon.
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/nathan/javafxperiode2faopdrenergiecurrent/energy.png")));

        //Setting Stage options.
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Energy company 'Current'");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
