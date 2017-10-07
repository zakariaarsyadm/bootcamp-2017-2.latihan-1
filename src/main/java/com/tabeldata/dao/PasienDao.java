/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.DatabaseConnection;
import com.tabeldata.configs.Pasien;
import java.sql.Connection;
import java.sql.Date;
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
public class PasienDao {

    public void save(Pasien pasien) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "insert into latihan_1.pasien (nama,alamat,tanggal_lahir) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String date = "1999-01-08";

        statement.setString(1, pasien.getNama());
        statement.setString(2, pasien.getAlamat());
        statement.setDate(3, pasien.getTanggalLahir());

        statement.executeUpdate();
        statement.close();
        connection.close();

    }

    public void update(Pasien pasien) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "update latihan_1.pasien set nama = ?, set alamat = ?, set tanggal_lahir = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, pasien.getNama());
        statement.setString(2, pasien.getAlamat());
        statement.setDate(3, pasien.getTanggalLahir());
        statement.setInt(4, pasien.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idPasien) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "delete from latihan_1.pasien where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, idPasien);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Pasien> findAll() throws SQLException {

        List<Pasien> listPasien = new ArrayList<>();

        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "select id,nama,alamat,tanggal_lahir from latihan_1.pasien";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            Pasien pasien = new Pasien();

            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
            pasien.setAlamat(resultSet.getString("alamat"));
            pasien.setTanggalLahir(resultSet.getDate("tanggal_lahir"));

            listPasien.add(pasien);

        }

        resultSet.close();
        statement.close();
        connection.close();

        return listPasien;
    }

    public Pasien findById(Integer kodePasien) throws SQLException {
        DatabaseConnection DBconnect = new DatabaseConnection();
        DataSource dataSource = DBconnect.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "select id,nama,alamat,tanggal_lahir from latihan_1.pasien where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, kodePasien);
        ResultSet resultSet = statement.executeQuery();
        
        Pasien pasien = new Pasien();
        
        if (resultSet.next()) {
            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
            pasien.setAlamat(resultSet.getString("alamat"));
            pasien.setTanggalLahir(Date.valueOf(resultSet.getString("tanggal_lahir")));
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return pasien;
        }

}
