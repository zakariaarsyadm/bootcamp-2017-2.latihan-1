/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.DatabaseConnection;
import com.tabeldata.configs.Dokter;
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
public class DokterDao {

    public void save(Dokter dokter) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "insert into latihan_1.dokter (nama,spesialis) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, dokter.getNama());
        statement.setString(2, dokter.getSpesialis());

        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(Dokter dokter) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "update latihan_1.dokter set nama=?, spesialis=? where id=? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, dokter.getNama());
        statement.setString(2, dokter.getSpesialis());
        statement.setInt(3, dokter.getId());

        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer kodeDokter) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "delete from latihan_1.dokter where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, kodeDokter);

        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Dokter> findAll() throws SQLException {
        List<Dokter> listDokter = new ArrayList<>();

        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "select id,nama,spesialis from latihan_1.dokter";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Dokter dokter = new Dokter();

            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));

            listDokter.add(dokter);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return listDokter;
    }

    public Dokter findById(Integer kodeDokter) throws SQLException {
        DatabaseConnection DBConnect = new DatabaseConnection();
        DataSource dataSource = DBConnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "select id,nama,spesialis from latihan_1.dokter where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, kodeDokter);
        ResultSet resultSet = statement.executeQuery();
        
        Dokter dokter = new Dokter();
        dokter.toString();
        
        if (resultSet.next()) {
            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return dokter;
                
    }

}
