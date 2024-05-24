module com.app.briefi.sclool_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.app.briefi.sclool_manager to javafx.fxml;
    exports com.app.briefi.sclool_manager;

    opens com.app.briefi.sclool_manager.controllers to javafx.fxml;
    exports com.app.briefi.sclool_manager.controllers;
}