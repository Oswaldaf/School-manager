package com.app.briefi.sclool_manager.controllers;

import com.app.briefi.sclool_manager.IDBCongig.IDBConfig;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.BreakIterator;
import java.time.LocalDate;
import java.util.*;

public class studentController implements Initializable {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> id;

    @FXML
    private TableColumn<Student, String> firstname;

    @FXML
    private TableColumn<Student, String> lastname;
    @FXML
    private TableColumn<Student, Date> dateOfBirth;

    @FXML
    private TableColumn<Student, String> placeOfBirth;
    @FXML
    private TableColumn<Student, Integer> state;

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
    private Button quitter;

    @FXML
    void addButton(ActionEvent event) throws IOException {
        if (firstN != null) {
            Stage stage = (Stage) studentTable.getScene().getWindow();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            stage.setScene(new Scene(parent));
            stage.show();
        }
    }
    @FXML
    void listSudent(ActionEvent event) throws IOException{
        Stage stage = (Stage) studentTable.getScene().getWindow();
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newfxml.fxml")));
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private final ObservableList<Student> students = FXCollections.observableArrayList();
    @FXML
    private void TableView () {
        try {
            Connection connection = IDBConfig.getConnection();
            String sql = "SELECT * FROM student";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDate(4),resultSet.getString(5),resultSet.getInt(6)));
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        id.setCellValueFactory(new PropertyValueFactory<Student ,Integer>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<Student, String>("Nom de Famille"));
        lastname.setCellValueFactory(new PropertyValueFactory<Student, String>("Prénoms"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<Student, Date>("Date de Naissance"));
        placeOfBirth.setCellValueFactory(new PropertyValueFactory<Student, String>("Lieu de Naissance"));
        state.setCellValueFactory(new PropertyValueFactory<Student, Integer>("statue"));
        studentTable.setItems(students);
    }
    @FXML
    public void quitter (ActionEvent event) {
        System.exit(0);
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


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
