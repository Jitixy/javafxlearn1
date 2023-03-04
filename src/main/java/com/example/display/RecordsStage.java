/**
 Daljeet singh
 991670669
 Assignment 2
 4 March 2023
 */

package com.example.demo6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RecordsStage extends Stage {
    public void displayRecords(ArrayList<String[]> records) {
        // Create a VBox to display the records
        VBox recordsBox = new VBox();
        recordsBox.setSpacing(10);
        recordsBox.setPadding(new Insets(10));
        recordsBox.setAlignment(Pos.CENTER);

        // Create a label for the records
        Label recordsLabel = new Label("Records");
        recordsBox.getChildren().add(recordsLabel);

        // Display each record in a label
        for (String[] record : records) {
            String recordString = "ID: " + record[0] +
                    ", Name: " + record[1] +
                    ", Address: " + record[2] +
                    ", City: " + record[3];
            Label recordLabel = new Label(recordString);
            recordsBox.getChildren().add(recordLabel);
        }

        // Set the scene and show the stage
        Scene scene = new Scene(recordsBox);
        this.setScene(scene);
        this.setTitle("Records");
        this.show();
    }
}
