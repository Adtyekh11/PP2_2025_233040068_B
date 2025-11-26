/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */
public class TugasManajemenNilaiSiswaApp extends JFrame { 

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

   
    public TugasManajemenNilaiSiswaApp() {
        // 1. Konfigurasi Frame Utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Posisi di tengah layar

        // 2. Inisialisasi Tabbed Pane
        tabbedPane = new JTabbedPane();

        // 3. Membuat Panel untuk Tab 1 (Form Input)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        // 4. Membuat Panel untuk Tab 2 (Tabel Data)
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        // Menambahkan TabbedPane ke Frame
        add(tabbedPane);
    }

    // Method untuk membuat desain Tab Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Komponen Mata Pelajaran (ComboBox)
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
                           "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Komponen Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);
        
        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);
        
        //Tombol reset
        JButton btnReset = new JButton("Reset Data");
        panel.add(btnReset);

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });
        
        //Event Handling Tombol reset
        btnReset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Data Telah direset");
        }
        });
       
        return panel;
    }

    // Method untuk membuat desain Tab Tabel (FIXED)
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Setup Model Tabel (Kolom)
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        // Membungkus tabel dengan ScrollPane
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // menambahkan tombol hapus data
        JButton btnHapus = new JButton("Hapus Data Terpilih");
        panel.add(btnHapus, BorderLayout.SOUTH);
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableData.getSelectedRow();
                if (selectedRow > -1) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });   
        return panel;
    }

    // Logika Validasi dan Penyimpanan Data
    private void prosesSimpan() {
        // 1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // 2. VALIDASI INPUT
        // Validasi 1: Cek apakah nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                                          "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; // Hentikan proses
        }

        // Validasi 2: Cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                                              "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                                          "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Validasi 3: Cek apakah terdiri lebih dari 3 angka/huruf
        if (nama.trim().length() < 3) {
        JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter!",
                                      "Error Validasi", JOptionPane.ERROR_MESSAGE);
        return; 
        }

        // 3. Logika Bisnis (Menentukan Grade)
        String grade;
        int rentang = nilai /10;
        switch (rentang) {
        case 10:
        case 9: 
        case 8:  
        grade = "A";
        break;
        case 7: 
        grade = "AB";
        break;
        case 6: 
        grade = "B";
        break;
        case 5: 
        grade = "BC";
        break;
        case 4: 
        grade = "C";
        break;
        case 3:  
        grade = "D";
        break;
        default:
        grade = "E";
        break;
    }

        // 4. Masukkan ke Tabel (Update Model)
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // 5. Reset Form dan Pindah Tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1); // Otomatis pindah ke tab tabel
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}