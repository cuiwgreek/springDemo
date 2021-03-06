package com.cuiwjava.dao.impl;

import com.cuiwjava.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void transOut(Long outId, int money) {

        this.jdbcTemplate.update("update account set balabce = balabce-? where id = ?",money,outId);
    }

    public void transIn(Long inId, int money) {

        this.jdbcTemplate.update("update account set balabce = balabce+? where id = ?",money,inId);
    }
}