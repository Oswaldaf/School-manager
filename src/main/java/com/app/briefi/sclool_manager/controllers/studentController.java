package com.app.briefi.sclool_manager.controllers;

import com.app.briefi.sclool_manager.HelloApplication;
import com.app.briefi.sclool_manager.IDBCongig.IDBConfig;
import com.app.briefi.sclool_manager.Studentlist;
import com.app.briefi.sclool_manager.modells.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class studentController implements Initializable {

    @FXML
    private Label lbetat;

    @FXML
    private Label add;

    @FXML
    private DatePicker Date;

    @FXML
    private TextField firstN;

    @FXML
    private TextField lastN;

    @FXML
    private TextField placeB;

    @FXML
    private TextField statue;


    @FXML
    private AnchorPane anchopane;

//    private final ObservableList<Student> student = FXCollections.observableArrayList();
//    @FXML
//    public void listStudent () {
//        try {
//            Connection connection = IDBConfig.getConnection();
//            String sql = "SELECT * FROM student";
//            assert connection != null;
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                student.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6)));
//            }
//            connection.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
//        firstname.setCellValueFactory(new PropertyValueFactory<Student, String>("Nom de Famille"));
//        lastname.setCellValueFactory(new PropertyValueFactory<Student, String>("Prénoms"));
//        dateOfBirth.setCellValueFactory(new PropertyValueFactory<Student, Date>("Date de Naissance"));
//        placeOfBirth.setCellValueFactory(new PropertyValueFactory<Student, String>("Lieu de Naissance"));
//        state.setCellValueFactory(new PropertyValueFactory<Student, Integer>("statue"));
//        studentTable.setItems(student);
//
//
//        try {
//            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newfxml.fxml")));
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    @FXML
    void listSudent(ActionEvent event) throws IOException{

        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("/com/app/briefi/sclool_manager/newfxml.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

//            tablestudent();
    }


    @FXML
    void addStudent(ActionEvent event) throws SQLException {
        String firstname = firstN.getText();
        String lastname = lastN.getText();
        LocalDate dateOfBirth = Date.getValue();
        String placeOfBirth = placeB.getText();
        int state = Integer.parseInt(statue.getText());

        Student student = new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setPlaceOfBirth(placeOfBirth);
        student.setDateOfBirth(Date);
        student.setState(state);

        student.create(student);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Confirmation de connexion");
        alert.setContentText("Un nouvel élève ajouté avec succès");
        alert.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        tablestudent();
    }
}
