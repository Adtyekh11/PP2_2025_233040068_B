/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul10.controller;

import PP2_2025_233040068_B.Modul10.model.MahasiswaModel;
import PP2_2025_233040068_B.Modul10.view.MahasiswaView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MahasiswaController {
    private MahasiswaView view;
    private MahasiswaModel model;

    public MahasiswaController(MahasiswaView view, MahasiswaModel model) {
        this.view = view;
        this.model = model;

        this.view.addSimpanListener(new SimpanListener());
        this.view.addEditListener(new EditListener());
        this.view.addHapusListener(new HapusListener());
        this.view.addClearListener(e -> clearForm());
        this.view.addCariListener(new CariListener());
        this.view.addTabelListener(new TabelListener());

        loadData();
    }

    private void loadData() {
        List<String[]> list = model.getAllMahasiswa();
        updateTable(list);
    }

    private void updateTable(List<String[]> list) {
        view.getModel().setRowCount(0);
        int no = 1;
        for (String[] mhs : list) {
            view.getModel().addRow(new Object[]{
                no++, mhs[0], mhs[1], mhs[2] 
            });
        }
    }

    private void clearForm() {
        view.setNamaInput("");
        view.setNimInput("");
        view.setJurusanInput("");
    }

  class SimpanListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = view.getNamaInput();
        String nim = view.getNimInput();
        String jurusan = view.getJurusanInput();

        if (nama.isEmpty() || nim.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }

        try {
            model.insertMahasiswa(nama, nim, jurusan);
            JOptionPane.showMessageDialog(view, "Data Berhasil Disimpan");
            loadData();
            clearForm();
        } catch (java.sql.SQLException ex) {
           
            if (ex.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(view, "NIM sudah Ada!");
            } else {
                JOptionPane.showMessageDialog(view, "Database Error: " + ex.getMessage());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
        }
    }
}
    class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.updateMahasiswa(view.getNamaInput(), view.getNimInput(), view.getJurusanInput());
                JOptionPane.showMessageDialog(view, "Data Berhasil Diubah");
                loadData();
                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
            }
        }
    }

    class HapusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.deleteMahasiswa(view.getNimInput());
                JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
                loadData();
                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
            }
        }
    }

    class CariListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String keyword = view.getCariInput();
            List<String[]> list = model.searchMahasiswa(keyword);
            updateTable(list);
        }
    }

    class TabelListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = view.getTable().getSelectedRow();
            if (row != -1) {
                view.setNamaInput(view.getTable().getValueAt(row, 1).toString());
                view.setNimInput(view.getTable().getValueAt(row, 2).toString());
                view.setJurusanInput(view.getTable().getValueAt(row, 3).toString());
            }
        }
    }
}