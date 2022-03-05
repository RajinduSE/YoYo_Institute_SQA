/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentregistration.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rajindu
 */
public class MainThemeController implements Initializable {

    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnStudents;
    @FXML
    private Button btnTutors;
    @FXML
    private Button btnSubjects;
    @FXML
    private Button btnSessions;
    @FXML
    private Button btnPayments;
    @FXML
    private TextField tfDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Date date = new Date();
        SimpleDateFormat formattedDate = new SimpleDateFormat("MM/dd/yyyy");
        tfDate.setText(String.valueOf(formattedDate.format(date)));
    }    

    @FXML
    private void navigateDashboard(ActionEvent event) {
        try {
            Stage stage = (Stage)btnDashboard.getScene().getWindow();
            Stage locationStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/studentregistration/views/Dashboard.fxml"));
            locationStage.setResizable(false);
            Scene scene = new Scene(root);
            locationStage.setScene(scene);
            locationStage.show();
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void navigateSubjects(ActionEvent event) {
        try {
            Stage stage = (Stage)btnSubjects.getScene().getWindow();
            Stage locationStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/studentregistration/views/Subject.fxml"));
            locationStage.setResizable(false);
            Scene scene = new Scene(root);
            locationStage.setScene(scene);
            locationStage.show();
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigateStudents(ActionEvent event) {
        try {
            Stage stage = (Stage)btnStudents.getScene().getWindow();
            Stage locationStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/studentregistration/views/Student.fxml"));
            locationStage.setResizable(false);
            Scene scene = new Scene(root);
            locationStage.setScene(scene);
            locationStage.show();
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigateTutors(ActionEvent event) {
        try {
            Stage stage = (Stage)btnTutors.getScene().getWindow();
            Stage locationStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/studentregistration/views/Tutor.fxml"));
            locationStage.setResizable(false);
            Scene scene = new Scene(root);
            locationStage.setScene(scene);
            locationStage.show();
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigateSessions(ActionEvent event) {
        try {
            Stage stage = (Stage)btnSessions.getScene().getWindow();
            Stage locationStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/studentregistration/views/Session.fxml"));
            locationStage.setResizable(false);
            Scene scene = new Scene(root);
            locationStage.setScene(scene);
            locationStage.show();
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigatePayments(ActionEvent event) {
        try {
            Stage stage = (Stage)btnPayments.getScene().getWindow();
            Stage locationStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/studentregistration/views/Payment.fxml"));
            locationStage.setResizable(false);
            Scene scene = new Scene(root);
            locationStage.setScene(scene);
            locationStage.show();
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
