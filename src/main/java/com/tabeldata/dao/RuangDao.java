/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.DatabaseConnection;
import com.tabeldata.configs.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author namhee
 */
public class RuangDao {
    
    public void save(Ruang ruang) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "insert into latihan_1.ruang (no_ruangan,kosong) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, ruang.getNoRuangan());
        statement.setBoolean(2, ruang.getKosong());
        
        statement.executeUpdate();
        statement.close();
        connection.close();    
    }
    
    public void save() throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "insert into latihan_1.ruang (no_ruangan,kosong) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, "A101");
        statement.setBoolean(2, true);
        
        statement.executeUpdate();
        statement.close();
        connection.close();    
    }
    
    public void delete(Integer kodeRuang) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        DataSource dataSource = databaseConnection.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "delete from latihan_1.ruang where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, kodeRuang);
        
        statement.executeUpdate();
        statement.close();
        connection.close();     
    }
    
    public void update(Ruang ruang) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        DataSource dataSource = databaseConnection.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "update latihan_1.ruang set no_ruangan = ?, set kosong = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, ruang.getNoRuangan());
        statement.setBoolean(2, ruang.getKosong());
        statement.setInt(3, ruang.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
        
        
    }
    
    public List<Ruang> findAll() throws SQLException {
        List<Ruang> listRuang = new ArrayList<>();
        
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "select id,no_ruangan,kosong from latihan_1.ruang";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
            Ruang ruang = new Ruang();
            
            ruang.setId(resultSet.getInt("id"));
            ruang.setNoRuangan(resultSet.getString("no_ruangan"));
            ruang.setKosong(resultSet.getBoolean("kosong"));
            
            listRuang.add(ruang);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return listRuang;
    }
    
    public Ruang findById(Integer kodeRuang) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        DataSource dataSource = databaseConnection.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "select id,no_ruangan,kosong from latihan_1.ruang where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, kodeRuang);
        ResultSet resultSet = statement.executeQuery();
        
        Ruang ruang = new Ruang();
        
        if (resultSet.next()) {
            
            ruang.setId(resultSet.getInt("id"));
            ruang.setNoRuangan(resultSet.getString("no_ruangan"));
            ruang.setKosong(Boolean.valueOf(resultSet.getString("kosong")));
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return ruang;
    }
    
}
