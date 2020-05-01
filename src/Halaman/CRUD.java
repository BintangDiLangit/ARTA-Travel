/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author BintangDiLangit
 */
public class CRUD {

    private PreparedStatement CRUDprestat;
    private Statement CRUDstat;
    private ResultSet CRUDdata;
    private String CRUDquery;
    private Connection CRUDcon;
    private Travel t;

    public CRUD() {
        try {
            konekDB conn = new konekDB();
            CRUDcon = conn.getConn();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ResultSet getAllData() {
        CRUDquery = "SELECT * FROM dataorder";
        try {
            CRUDstat = CRUDcon.createStatement();
            CRUDdata = CRUDstat.executeQuery(CRUDquery);
        } catch (SQLException e) {
        }
        return CRUDdata;
    }

    public void tambahData(String nama, String alamat, String nohp, String paket, String jmlorang, String tgl, String total) {
        CRUDquery = "INSERT INTO dataorder (nama, alamat, nohp,paket,jmlorang,tgl,total) VALUES(?,?,?,?,?,?,?)";
        try {
            CRUDprestat = CRUDcon.prepareStatement(CRUDquery);
            CRUDprestat.setString(1, nama);
            CRUDprestat.setString(2, alamat);
            CRUDprestat.setString(3, nohp);
            CRUDprestat.setString(4, paket);
            CRUDprestat.setString(5, jmlorang);
            CRUDprestat.setString(6, tgl);
            CRUDprestat.setString(7, total);
          
            CRUDprestat.executeUpdate();
            CRUDprestat.close();
            System.out.println("berhasil");
            
        } catch (SQLException e) {
//            System.out.println("Data gagal ditambahkan");
//            System.out.println(e);
e.printStackTrace();
        }
    }

    public ResultSet countRows() {
        CRUDquery = "SELECT COUNT(*) FROM dataorder";
        try {
            CRUDstat = CRUDcon.createStatement();
            CRUDdata = CRUDstat.executeQuery(CRUDquery);
        } catch (SQLException e) {
        }
        return CRUDdata;
    }

    public int count() {
        int num = 0;
        try {
            ResultSet data = countRows();
            data.next();
            num = data.getInt(1);
        } catch (SQLException e) {
//            System.out.println();
        }
        return num;
    }

    public ResultSet lastId() {
        CRUDquery = "SELECT MAX(id) FROM dataorder";
        try {
            CRUDstat = CRUDcon.createStatement();
            CRUDdata = CRUDstat.executeQuery(CRUDquery);
        } catch (SQLException e) {
        }
        return CRUDdata;
    }

    public int getLastID() {
        int id = 1;
        try {
            ResultSet data = lastId();
            data.next();
            id = data.getInt(1);
        } catch (SQLException e) {

        }
        return id;
    }

    public void editData(String nama, String alamat, String nohp, String paket, String jmlorang, String tgl, String lunas,int id) {
//        CRUDquery = "UPDATE 'dataorder' SET 'nama' = ?, 'alamat' = ?, 'nohp'= ?, 'paket'= ?, 'jmlorang'= ?, 'tgl'= ? WHERE 'id' = ?";
        CRUDquery = "UPDATE `dataorder` SET `nama`=?,`alamat`=?,`nohp`=?,`paket`=?,`jmlorang`=?,`tgl`=?,`total`=?,`lunas`=?  WHERE `dataorder`.`id`=?;";
        try {
            CRUDprestat = CRUDcon.prepareStatement(CRUDquery);
            CRUDprestat.setString(1, nama);
            CRUDprestat.setString(2, alamat);
            CRUDprestat.setString(3, nohp);
            CRUDprestat.setString(4, paket);
            CRUDprestat.setString(5, jmlorang);
            CRUDprestat.setString(6, tgl);
//            CRUDprestat.setString(7, total);
            CRUDprestat.setString(7, lunas);
            CRUDprestat.setInt(8, id);
            CRUDprestat.executeUpdate();
            CRUDprestat.close();
            System.out.println("Edited");
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Gaiso diedit");
//            e.printStackTrace();
        }
    }
    
    public void hapusData(int id){
        CRUDquery = "DELETE FROM dataorder WHERE id=?";
        try {
            CRUDprestat = CRUDcon.prepareStatement(CRUDquery);
            CRUDprestat.setInt(1, id);
            CRUDprestat.executeUpdate();
            CRUDprestat.close();
            System.out.println("Deleted");
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Gaiso dihapus");
//            e.printStackTrace();
        }
    }
}
