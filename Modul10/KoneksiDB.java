/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul10;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            // URL database (ganti "root" dan "" sesuai user/pass database lokal Anda)
            String url = "jdbc:mysql://localhost:3306/kampus_db";
            String user = "root";
            String pass = "";

            // Registrasi Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Buat Koneksi
            mysqlconfig = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
        return mysqlconfig;
    }
}
