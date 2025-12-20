/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul10.model;

import PP2_2025_233040068_B.Modul10.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaModel {

    public List<String[]> getAllMahasiswa() {
        List<String[]> list = new ArrayList<>();
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM mahasiswa");

            while (res.next()) {
         
                String[] data = {
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                };
                list.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertMahasiswa(String nama, String nim, String jurusan) throws SQLException {
        Connection conn = KoneksiDB.configDB();
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, nim);
        pst.setString(3, jurusan);
        pst.executeUpdate();
    }

    public void updateMahasiswa(String nama, String nim, String jurusan) throws SQLException {
        Connection conn = KoneksiDB.configDB();
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, jurusan);
        pst.setString(3, nim);
        pst.executeUpdate();
    }

    public void deleteMahasiswa(String nim) throws SQLException {
        Connection conn = KoneksiDB.configDB();
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.executeUpdate();
    }

    public List<String[]> searchMahasiswa(String keyword) {
        List<String[]> list = new ArrayList<>();
        try {
            Connection conn = KoneksiDB.configDB();
            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ? OR nim LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                String[] data = {
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                };
                list.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}