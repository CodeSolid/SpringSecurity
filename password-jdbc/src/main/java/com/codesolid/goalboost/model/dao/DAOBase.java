package com.codesolid.goalboost.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DAOBase {
    DriverManagerDataSource dataSource;

    @Autowired
    public void setDataSource(DriverManagerDataSource ds ) {
        dataSource = ds;
        JdbcTemplate template = new JdbcTemplate(ds);
        MySQLErrorCodesTranslator translator = new MySQLErrorCodesTranslator();
        translator.setDataSource(ds);
        template.setExceptionTranslator(translator);
        setJdbcTemplate(template);
    }

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}