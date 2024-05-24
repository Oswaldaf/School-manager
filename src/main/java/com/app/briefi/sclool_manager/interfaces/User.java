package com.app.briefi.sclool_manager.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface User {
    List<User> list() throws SQLException;
    void create(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(User user) throws SQLException;
}
