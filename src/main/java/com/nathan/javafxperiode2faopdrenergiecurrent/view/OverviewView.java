package com.nathan.javafxperiode2faopdrenergiecurrent.view;

import com.nathan.javafxperiode2faopdrenergiecurrent.controller.OverviewController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class OverviewView {

    MenuBarView menuBarView = new MenuBarView();

    public void getUsageOverview(Stage primaryStage) {
        // Setting the grid.
        OverviewController overviewController = new OverviewController();
        BorderPane root = new BorderPane();
        FlowPane centerPane = new FlowPane();

        GridPane listOverview = overviewController.getUsageGrid();

        root.setTop(menuBarView.getMenuBar(primaryStage));
        centerPane.getStyleClass().add("flow-pane");
        root.setCenter(centerPane);

        // Getting the data.
        ArrayList<Double> gasList = overviewController.getUsageOverviewGas();
        ArrayList<Double> currentList = overviewController.getUsageOverviewCurrent();

        // Labels to display all information.
        Label weeklyUsageLabelGas = new Label("Average weekly gas usage: " + gasList.get(0) + " m3.");
        Label monthlyUsageLabelGas = new Label("Average monthly gas usage: " + gasList.get(1) + " m3.");
        Label yearlyUsageLabelGas = new Label("Average yearly gas usage: " + gasList.get(2) + " m3.");
        VBox vboxGasUsage = new VBox(weeklyUsageLabelGas, monthlyUsageLabelGas, yearlyUsageLabelGas);

        Label weeklyUsageLabelCurrent = new Label(" Average weekly current usage: " + currentList.get(0) + " kWh.");
        Label monthlyUsageLabelCurrent = new Label(" Average monthly current usage: " + currentList.get(1) + " kWh.");
        Label yearlyUsageLabelCurrent = new Label(" Average yearly current usage: " + currentList.get(2) + " kWh.");
        VBox vboxUsageCurrent = new VBox(weeklyUsageLabelCurrent, monthlyUsageLabelCurrent, yearlyUsageLabelCurrent);

        Label weeklyUsageLabelGasCost = new Label(" Weekly Usage Cost Gas: € " + gasList.get(3));
        Label monthlyUsageLabelGasCost = new Label(" Monthly Usage Cost Gas: € " + gasList.get(4));
        Label yearlyUsageLabelGasCost = new Label(" Yearly Usage Cost Gas: € " + gasList.get(5));
        VBox gasCosts = new VBox(weeklyUsageLabelGasCost, monthlyUsageLabelGasCost, yearlyUsageLabelGasCost);

        Label weeklyUsageLabelCurrentCost = new Label(" Weekly Usage Cost Current: € "+ currentList.get(3));
        Label monthlyUsageLabelCurrentCost = new Label(" Monthly Usage Cost Current: € " + currentList.get(4));
        Label yearlyUsageLabelCurrentCost = new Label(" Yearly Usage Cost Current: € " + currentList.get(5));
        VBox currentCosts = new VBox(weeklyUsageLabelCurrentCost, monthlyUsageLabelCurrentCost, yearlyUsageLabelCurrentCost);

        centerPane.getChildren().addAll(vboxGasUsage, vboxUsageCurrent, gasCosts, currentCosts, listOverview);

        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add(Objects.requireNonNull(
                getClass().getResource("/com/nathan/javafxperiode2faopdrenergiecurrent/stylesheet.css")
        ).toExternalForm());
        primaryStage.setScene(scene);
    }
}
