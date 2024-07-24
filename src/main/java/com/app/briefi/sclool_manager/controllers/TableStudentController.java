package com.app.briefi.sclool_manager.controllers;

import com.app.briefi.sclool_manager.HelloApplication;
import com.app.briefi.sclool_manager.IDBCongig.IDBConfig;
import com.app.briefi.sclool_manager.Studentlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

public class TableStudentController implements Initializable {

    @FXML
    private Button quitter;

    @FXML
    private TableView<Studentlist> studentTable;
    @FXML
    private TableColumn<Studentlist, Integer> id;

    @FXML
    private TableColumn<Studentlist, String> firstname;

    @FXML
    private TableColumn<Studentlist, String> lastname;
    @FXML
    private TableColumn<Studentlist, Date> dateOfBirth;

    @FXML
    private TableColumn<Studentlist, String> placeOfBirth;
    @FXML
    private TableColumn<Studentlist, Integer> state;

    public ObservableList<Studentlist> list() {

        ObservableList<Studentlist> listStudent = FXCollections.observableArrayList();
        Connection connection = IDBConfig.getConnection();
        String req = "SELECT * FROM student";

        try {
            assert connection != null;
            PreparedStatement prepareStatement = connection.prepareStatement(req);

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
//                    Student student = new Student();
//                    student.setId(resultSet.getInt("id"));
//                    student.setFirstname(resultSet.getString("firstname"));
//                    student.setLastname(resultSet.getString("lastname"));
//                    student.setDateOfBirth(resultSet.getDate("dateOfBirth").toLocalDate());
//                    student.setPlaceOfBirth(resultSet.getString("placeOfBirth"));
//                    student.setState(resultSet.getInt(" state"));
                Studentlist student = new Studentlist(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("placeOfBirth"),
                        resultSet.getInt("state")
                );

                listStudent.add(student);
            }
//            prepareStatement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        if (connection != null) {
//
//
//        }

        return listStudent;
    }

    public void tablestudent() {
        ObservableList<Studentlist> addStudent = list();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        placeOfBirth.setCellValueFactory(new PropertyValueFactory<>("placeOfBirth"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));

        System.out.println();

        studentTable.setItems(addStudent);

    }

    @FXML
    public void quitter (ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void addButton(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hello-view.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablestudent();
    }
}
