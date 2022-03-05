/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentregistration.controllers;

import com.studentregistration.models.Tutor;
import com.studentregistration.utils.ConnectionUtil;
import com.studentregistration.utils.IDGenerator;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Rajindu
 */
public class TutorController implements Initializable {

    @FXML
    private TableView<Tutor> tvTutors;
    @FXML
    private TableColumn<Tutor, String> colId;
    @FXML
    private TableColumn<Tutor, String> colName;
    @FXML
    private TableColumn<Tutor, String> colTutorId;
    @FXML
    private TableColumn<Tutor, String> colSubject;
    @FXML
    private TableColumn<Tutor, Integer> colGrade;
    @FXML
    private TableColumn<Tutor, String> colDob;
    @FXML
    private TableColumn<Tutor, Integer> colPhone;
    @FXML
    private TableColumn<Tutor, Integer> colFee;
    @FXML
    private TableColumn<Tutor, String> colAcc;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfTutorId;
    @FXML
    private ComboBox<String> cbSubject;
    @FXML
    private ComboBox<String> cbGrade;
    @FXML
    private TextField tfDob;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfFee;
    @FXML
    private TextField tfAccNo;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnSave;
    
    private ConnectionUtil conUtil = new ConnectionUtil();
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private Integer grade = null;
    private String subject = null;
    private String tutorId = null;
    
    ObservableList<String> SubjectList = FXCollections.observableArrayList("Maths" ,"ICT","Science","History");
    ObservableList<String> gradeList = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11");
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showTutors();
        cbSubject.setItems(SubjectList);
        cbGrade.setItems(gradeList);
    }    

    @FXML
    private void handleMouseActions(MouseEvent event) {
        Tutor tutor = tvTutors.getSelectionModel().getSelectedItem();
        tutorId = tutor.getId();
        tfName.setText(tutor.getName());
        tfTutorId.setText(tutor.getTutorId());
        cbSubject.setValue(tutor.getSubject());
        cbGrade.setValue(String.valueOf(tutor.getGrade()));
        tfDob.setText(tutor.getDob());
        tfPhone.setText(String.valueOf(tutor.getPhoneNumber()));
        tfFee.setText(String.valueOf(tutor.getFee()));
        tfAccNo.setText(tutor.getAccNo());
    }

    @FXML
    private void subjectChange(ActionEvent event) {
        subject = cbSubject.getValue();
    }

    @FXML
    private void gradeChange(ActionEvent event) {
        grade = Integer.parseInt(cbGrade.getValue());
    }

    @FXML
    private void buttonHandler(ActionEvent event) {
        Tutor tutor = tvTutors.getSelectionModel().getSelectedItem();
        if(event.getSource() == btnSave){
            insertRecord();
        }else if(event.getSource() == btnUpdate && tutor != null){
            updateRecord();
        }else if(event.getSource() == btnDelete && tutor != null){
            deleteRecord();
            clearRecord();
        }else if(event.getSource() == btnClear){
            clearRecord();
        }
    }
    
    public void showTutors(){
        ObservableList<Tutor> list = getTutorList();
       
        colId.setCellValueFactory(new PropertyValueFactory<Tutor, String>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Tutor, String>("name"));
        colTutorId.setCellValueFactory(new PropertyValueFactory<Tutor, String>("tutorId"));
        colSubject.setCellValueFactory(new PropertyValueFactory<Tutor, String>("subject"));
        colGrade.setCellValueFactory(new PropertyValueFactory<Tutor, Integer>("grade"));
        colDob.setCellValueFactory(new PropertyValueFactory<Tutor, String>("dob"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Tutor, Integer>("phoneNumber"));
        colFee.setCellValueFactory(new PropertyValueFactory<Tutor, Integer>("fee"));
        colAcc.setCellValueFactory(new PropertyValueFactory<Tutor, String>("accNo"));
        
        tvTutors.setItems(list);
    }
    
    public ObservableList<Tutor> getTutorList(){
        ObservableList<Tutor> tutorList = FXCollections.observableArrayList();
        conn = conUtil.getConnection();
        String query = "SELECT * FROM tutors";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Tutor tutor;
            while(rs.next()){
                tutor = new Tutor(rs.getString("id"), rs.getString("name"), rs.getString("tutorId"), rs.getString("subject"),rs.getInt("grade"),rs.getString("dob"),rs.getInt("phone"),rs.getInt("fee"),rs.getString("account"));
                tutorList.add(tutor);
            }   
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return tutorList;
    }
    
    private void insertRecord(){
        IDGenerator nextId = new IDGenerator();
        String nextgeneratedId = nextId.generateId("tutors", "T");
        String query = "INSERT INTO tutors VALUES (" + "'" + nextgeneratedId + "'" + ",'" + tfName.getText() + "','" + tfTutorId.getText() + "','" + subject + "',"
                + "'" + grade + "'" + "," + "'" + tfDob.getText() + "'" + "," + "'" + Integer.parseInt(tfPhone.getText()) + "'" + "," + "'" + Integer.parseInt(tfFee.getText()) + "'" + "," + "'" + tfAccNo.getText() + "'" + ")";
        executeQuery(query);
        showTutors();
    }
    
    private void executeQuery(String query) {
        conn = conUtil.getConnection();
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    private void updateRecord(){
        String query = "UPDATE  tutors SET name  = '" + tfName.getText() + "', tutorId = '" + tfTutorId.getText() + "', subject = " +
                "'" + subject + "'" + ", grade = " + "'" + grade + "'" + ", dob = " + "'" + tfDob.getText() + "'" + ", phone = " + "'" + Integer.parseInt(tfPhone.getText()) + "'" + ", fee = " +  "'" + Integer.parseInt(tfFee.getText()) + "'" +", account = " + "'" + tfAccNo.getText() + "'" +" WHERE id = " + "'" + tutorId + "'";
        executeQuery(query);
        showTutors();
    }
    
    private void deleteRecord(){
        String query = "DELETE FROM tutors WHERE id = " + "'" + tutorId + "'";
        executeQuery(query);
        showTutors();
    }
    
    private void clearRecord(){
        tfName.setText(null);
        tfTutorId.setText(null);
        cbSubject.setValue("Select Subject");
        cbGrade.setValue("Select Grade");
        tfDob.setText(null);
        tfPhone.setText(null);
        tfFee.setText(null);
        tfAccNo.setText(null);
    }
}
