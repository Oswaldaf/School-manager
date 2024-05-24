package com.app.briefi.sclool_manager.modells;

import com.app.briefi.sclool_manager.IDBCongig.IDBConfig;
import com.app.briefi.sclool_manager.interfaces.StudentInterface;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Student extends User implements StudentInterface {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private Connection connection;
    private static int state = 0;

    public Student(int anInt, String string, String string1, Date date, String string2, int anInt1) {
        super();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Student(int anInt, String string, String string1, java.sql.Date date, String string2) {
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DatePicker dateOfBirth) {
        this.dateOfBirth = dateOfBirth.getValue();
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void create(Student student) throws SQLException {
        this.connection = IDBConfig.getConnection();
        if(connection != null){
            String req = "INSERT INTO student(firstname, lastname, dateOfBirth, placeOfBirth, state) VALUES (?,?,?,?,?);";


            PreparedStatement prepareStatement = this.connection.prepareStatement(req);

            prepareStatement.setString(1, getFirstname());
            prepareStatement.setString(2, getLastname());
            prepareStatement.setDate(3, Date.valueOf(getDateOfBirth()));
            prepareStatement.setString(4, getPlaceOfBirth());
            prepareStatement.setInt(5, getState());

            prepareStatement.executeUpdate();

            prepareStatement.close();

            this.connection.close();

        }

    }

    @Override
    public List<StudentInterface> list() throws SQLException {
        return null;
    }

    @Override
    public void create(StudentInterface student) throws SQLException {

    }

    @Override
    public void update(StudentInterface student) throws SQLException {

    }

    @Override
    public void delete(StudentInterface student) throws SQLException {

    }
}
