package com.codesolid.securecassandra.model.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import java.sql.SQLException;

public class MySQLErrorCodesTranslator implements SQLExceptionTranslator {

    DriverManagerDataSource dataSource;

    public void setDataSource(DriverManagerDataSource ds ) {
        dataSource = ds;
    }

    @Override
    public DataAccessException translate(String task, String sql, SQLException ex) {
        return new InvalidDataAccessApiUsageException(ex.getMessage());
    }
}