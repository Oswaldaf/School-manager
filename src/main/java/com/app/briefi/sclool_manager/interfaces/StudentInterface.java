package com.app.briefi.sclool_manager.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {
    List<StudentInterface> list() throws SQLException;
    void create(StudentInterface student) throws SQLException;
    void update(StudentInterface student) throws SQLException;
    void delete(StudentInterface student) throws SQLException;
}
