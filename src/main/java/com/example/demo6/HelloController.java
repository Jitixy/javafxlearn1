/**
 Daljeet singh
 991670669
 Assignment 2
 4 March 2023
 */

package com.example.demo6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class HelloController extends VBox {
    private static final int MAX_RECORDS = 10;
    private ArrayList<String[]> records;
    private int currentRecordIndex;
    private int currentShapeIndex;
    private boolean displayEnabled;

    // Declare UI elements
    private Label idLabel, nameLabel, addressLabel, cityLabel;
    private TextField idField, nameField, addressField, cityField;
    private Button addButton, displayButton;
    private HBox shapeBox;

    public HelloController() {
        // Initialize UI elements
        idLabel = new Label("ID");
        nameLabel = new Label("Name");
        addressLabel = new Label("Address");
        cityLabel = new Label("City");

        idField = new TextField();
        nameField = new TextField();
        addressField = new TextField();
        cityField = new TextField();

        addButton = new Button("Add");
        displayButton = new Button("Display");

        shapeBox = new HBox();
        shapeBox.setAlignment(Pos.CENTER);
        shapeBox.setSpacing(10);

        // Set button actions
        addButton.setOnAction(event -> addRecord());
        displayButton.setOnAction(event -> displayRecords());

        // Arrange UI elements in a VBox
        VBox inputBox = new VBox();
        inputBox.setSpacing(10);
        inputBox.setPadding(new Insets(10));
        inputBox.setAlignment(Pos.CENTER);

        HBox idRow = new HBox(idLabel, idField);
        idRow.setSpacing(10);
        idRow.setAlignment(Pos.CENTER);

        HBox nameRow = new HBox(nameLabel, nameField);
        nameRow.setSpacing(10);
        nameRow.setAlignment(Pos.CENTER);

        HBox addressRow = new HBox(addressLabel, addressField);
        addressRow.setSpacing(10);
        addressRow.setAlignment(Pos.CENTER);

        HBox cityRow = new HBox(cityLabel, cityField);
        cityRow.setSpacing(10);
        cityRow.setAlignment(Pos.CENTER);

        inputBox.getChildren().addAll(idRow, nameRow, addressRow, cityRow);

        VBox buttonBox = new VBox(addButton, displayButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(inputBox, buttonBox, shapeBox);

        records = new ArrayList<>();
        currentRecordIndex = 0;
        currentShapeIndex = 0;
        displayEnabled = false;
    }

    /*
     * Method to display the records
     */
    private void displayRecords() {
        // Create a new RecordsStage instance
        RecordsStage recordsStage = new RecordsStage();

        // Display the records in the recordsStage
        recordsStage.displayRecords(records);

        // Clear the records ArrayList
        records.clear();

        // Clear the shapes from the shapeBox
        shapeBox.getChildren().clear();

        // Enable add button and disable display button
        addButton.setDisable(false);
        displayButton.setDisable(true);

        // Clear the text fields and set focus to idField
        idField.clear();
        nameField.clear();
        addressField.clear();
        cityField.clear();
        idField.requestFocus();
    }

    /*
     * Method to add a record
     */
    private void addRecord() {
        if (records.size() < MAX_RECORDS) {
            String[] record = new String[4];
            record[0] = idField.getText();
            record[1] = nameField.getText();
            record[2] = addressField.getText();
            record[3] = cityField.getText();
            records.add(record);

            // Add a shape to the shapeBox
            Circle circle = new Circle(10, Color.RED);
            shapeBox.getChildren().add(circle);
            currentShapeIndex++;

            // Clear the text fields and set focus to idField
            idField.clear();
            nameField.clear();
            addressField.clear();
            cityField.clear();
            idField.requestFocus();

            // Disable add button and enable display button once five records have been added
            if (records.size() == 5) {
                addButton.setDisable(true);
                displayButton.setDisable(false);
            }
        }

    }
}