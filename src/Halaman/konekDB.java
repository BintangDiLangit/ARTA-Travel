/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

/**
 *
 * @author BintangDiLangit
 */
import java.sql.*;
public class konekDB {
    
    private Connection connect;
    private String driveName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/artaTravel?serverTimezone=UTC";
    private String username = "root";
    private String password = "";
    
        public Connection getConn() throws SQLException 
    {
        if (connect == null) 
        { 
            try 
            {
                Class.forName(driveName);
                try 
                {
                    connect = DriverManager.getConnection(url, username, password);
                } catch (SQLException se) {
                    System.out.println("Koneksi gagal!");
                    System.out.println(se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException se) {
                System.out.println("Class tidak ditemukan");
                System.exit(0);
            }
        }
        return connect;
    }
}
