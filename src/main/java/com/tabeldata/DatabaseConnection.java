/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author namhee
 */
public class DatabaseConnection {

    private final static String url = "jdbc:postgresql://localhost:5432/bootcamp_latihan";
    private final static String username = "bootcamp_latihan";
    private final static String password = "latihan";

    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
    
    public static void main(String[] args) throws SQLException {
//        DatabaseConnection koneksiDB = new DatabaseConnection();
//        Connection connection = koneksiDB.getDataSource().getConnection();
//        if (connection != null) {
//            System.out.println("Database Connection Success");
//        } else {
//            System.out.println("Database Connection Failed");
//        }
    }

}
