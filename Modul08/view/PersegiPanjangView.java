/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul08.view;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */


import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {

    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Luas");
    private JButton btnHitungKeliling = new JButton("Keliling");
    private JButton btnReset = new JButton("Reset");
    

    public PersegiPanjangView() {
        // Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(5, 2, 10, 10)); 
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil:"));
        this.add(lblHasil);
        this.add(btnHitung);
        this.add(btnHitungKeliling);
        this.add(btnReset);
    }
    
    // Mengambil nilai panjang dari Textfield
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    // Mengambil nilai lebar dari Textfield
    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Menampilkan hasil ke Label
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }

    // Menampilkan pesan error (jika input bukan angka)
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Mendaftarkan Listener untuk tombol (Controller yang akan memberikan aksinya)
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
    
    public void addHitungKelilingListener(ActionListener listener) {
    btnHitungKeliling.addActionListener(listener);
}
    
       public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
    
    public void reset() {
    txtPanjang.setText("");
    txtLebar.setText("");
    lblHasil.setText("-");
}

    

}


