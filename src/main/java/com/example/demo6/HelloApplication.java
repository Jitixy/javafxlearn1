/**
 Daljeet singh
 991670669
 Assignment 2
 4 March 2023
 */

package com.example.demo6;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;



public class HelloApplication extends Application {
    private HelloController recordManager;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Record Manager");
        recordManager = new HelloController();
        primaryStage.setScene(new Scene(recordManager,
                400.0,
                400.0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}