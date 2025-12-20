/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul10.view;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class MahasiswaView extends JFrame {
 
    private JTextField txtNama, txtNIM, txtJurusan, txtCari;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    private JTable tableMahasiswa;
    private DefaultTableModel model;

    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa JDBC - MVC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents() {
      
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

      
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

      
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelCari.add(new JLabel("Cari Mahasiswa"));
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");
        panelCari.add(txtCari);
        panelCari.add(btnCari);


        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BoxLayout(panelAtas, BoxLayout.Y_AXIS));
        panelAtas.add(panelForm);
        panelAtas.add(panelTombol);
        panelAtas.add(panelCari);
        add(panelAtas, BorderLayout.NORTH);


        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");

        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);
    }

    
    public String getNamaInput() { return txtNama.getText(); }
    public String getNimInput() { return txtNIM.getText(); }
    public String getJurusanInput() { return txtJurusan.getText(); }
    public String getCariInput() { return txtCari.getText(); }

   
    public void setNamaInput(String nama) { txtNama.setText(nama); }
    public void setNimInput(String nim) { txtNIM.setText(nim); }
    public void setJurusanInput(String jurusan) { txtJurusan.setText(jurusan); }

    public DefaultTableModel getModel() { return model; }
    public JTable getTable() { return tableMahasiswa; }


    public void addSimpanListener(ActionListener listener) { btnSimpan.addActionListener(listener); }
    public void addEditListener(ActionListener listener) { btnEdit.addActionListener(listener); }
    public void addHapusListener(ActionListener listener) { btnHapus.addActionListener(listener); }
    public void addClearListener(ActionListener listener) { btnClear.addActionListener(listener); }
    public void addCariListener(ActionListener listener) { btnCari.addActionListener(listener); }
    public void addTabelListener(MouseAdapter adapter) { tableMahasiswa.addMouseListener(adapter); }
}