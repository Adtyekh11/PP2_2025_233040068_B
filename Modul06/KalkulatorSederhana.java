package PP2_2025_233040068_B.Modul06;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * @author ADITYA EKA HERIYAWAN
 */
public class KalkulatorSederhana {

    public static void main(String[] args) {

        // 1. Buat frame
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // 2. Buat layar di bagian atas menggunakan JTextField
        JTextField layar = new JTextField();
        frame.add(layar, BorderLayout.NORTH);

        // 3. Buat panel untuk tombol dengan GridLayout 4 baris, 4 kolom
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5)); // 4 baris, 4 kolom, gap 5x5

        // 4. Tambahkan 16 tombol (0-9 dan operator +, -, *, /, =, C, .)
        // Baris 1: 7, 8, 9, /
        panelTombol.add(new JButton("7"));
        panelTombol.add(new JButton("8"));
        panelTombol.add(new JButton("9"));
        panelTombol.add(new JButton("/"));

        // Baris 2: 4, 5, 6, *
        panelTombol.add(new JButton("4"));
        panelTombol.add(new JButton("5"));
        panelTombol.add(new JButton("6"));
        panelTombol.add(new JButton("*"));

        // Baris 3: 1, 2, 3, -
        panelTombol.add(new JButton("1"));
        panelTombol.add(new JButton("2"));
        panelTombol.add(new JButton("3"));
        panelTombol.add(new JButton("-"));

        // Baris 4: C, 0, =, +
        panelTombol.add(new JButton("C")); // Clear
        panelTombol.add(new JButton("0"));
        panelTombol.add(new JButton("=")); // Equals
        panelTombol.add(new JButton("+"));

        // Tambahan baris untuk operator atau titik (opsional, disesuaikan kebutuhan)
        // panelTombol.add(new JButton("."));

        // 5. Tambahkan panel ke frame di bagian CENTER
        frame.add(panelTombol, BorderLayout.CENTER);

        // 6. Tampilkan frame
        frame.setVisible(true);
    }
}