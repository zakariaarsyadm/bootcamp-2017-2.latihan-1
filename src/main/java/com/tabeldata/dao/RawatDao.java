/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.DatabaseConnection;
import com.tabeldata.configs.Dokter;
import com.tabeldata.configs.Pasien;
import com.tabeldata.configs.Rawat;
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
public class RawatDao {

    public void addRawat(Rawat rawat) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        DataSource dataSource = databaseConnection.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        String sql = "insert into latihan_1.rawat (pasien_id,dokter_id,ruang_id,waktu_register) values (?,?,?,now())";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, rawat.getPasien().getId());
        preparedStatement.setInt(2, rawat.getDokter().getId());
        preparedStatement.setInt(3, rawat.getRuang().getId());
        
        System.out.println(preparedStatement);
        
        preparedStatement.executeUpdate();
        preparedStatement.close();

        sql = "update latihan_1.ruang set kosong = ? where id = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
        preparedStatement1.setBoolean(1, rawat.getRuang().getKosong());  
        preparedStatement1.setInt(2, rawat.getRuang().getId());
        
        System.out.println(preparedStatement1);
        
        preparedStatement1.executeUpdate();
        preparedStatement1.close();

        connection.commit();
        connection.close();
    }

    public List<Rawat> listRawat() throws SQLException {

        String sql = "SELECT \n"
                + "p.id as id_pasien,\n"
                + "p.nama as nama_pasien,\n"
                + "p.alamat as alamat,\n"
                + "p.tanggal_lahir as tanggal_lahir, \n"
                + "d.id as id_dokter,\n"
                + "d.nama as nama_dokter,\n"
                + "d.spesialis as spesialis,\n"
                + "ru.id as id_ruang,\n"
                + "ru.no_ruang as no_ruang,\n"
                + "ru.kosong as kosong,\n"
                + "ra.id as id_rawat,\n"
                + "ra.waktu_register as waktu_register,\n"
                + "ra.waktu_checkout as waktu_checkout\n"
                + "FROM latihan_1.pasien p\n"
                + "join latihan_1.dokter d on p.id = ra.pasien_id\n"
                + "join latihan_1.rawat ra on ra.dokter_id = d.id\n"
                + "join latihan_1.ruang ru on ra.ruang_id = ru.id\n";
        
        System.out.println(sql);
        

        DatabaseConnection koneksiDB = new DatabaseConnection();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        List<Rawat> listRawat = new ArrayList<>();
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Rawat rawat = new Rawat();

            rawat.setPasien(new Pasien(
                    resultSet.getInt("id_pasien"),
                    resultSet.getString("nama_pasien"),
                    resultSet.getString("alamat"),
                    resultSet.getDate("tanggal_lahir")));

            rawat.setDokter(new Dokter(
                    resultSet.getInt("id_dokter"),
                    resultSet.getString("nama_dokter"),
                    resultSet.getString("spesialis")));

            rawat.setId(resultSet.getInt("id_rawat"));
            rawat.setWaktuRegister(resultSet.getDate("waktu_register"));
            rawat.setWaktuCheckout(resultSet.getDate("waktu_checkout"));

            listRawat.add(rawat);
        }
        
        resultSet.close();
        statement.close();
        koneksi.close();

        return listRawat;
    }

//    public List<Rawat> listRawat() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
