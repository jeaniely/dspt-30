package com.neuedu.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultOject {
    Object getByResultSet(ResultSet resultSet) throws SQLException;
}
