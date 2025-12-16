/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */
public class AplikasiFileIO extends JFrame{
    
    //KOMPONEN UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;
    private JButton btnSaveObject, btnLoadObject;
    private JButton btnAppendText;
    
    public AplikasiFileIO() {

    super("Tutorial File IO & Exception Handling");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // --- Inisialisasi Komponen ---
    textArea = new JTextArea();
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
    fileChooser = new JFileChooser();

    // --- Panel Tombol ---
    JPanel buttonPanel = new JPanel();

    btnOpenText   = new JButton("Buka Text");
    btnSaveText   = new JButton("Simpan Text");
    btnAppendText = new JButton("Append Text");
    btnSaveBinary = new JButton("Simpan Config (Binary)");
    btnLoadBinary = new JButton("Muat Config (Binary)");
    btnSaveObject = new JButton("Simpan Objek Config");
    btnLoadObject = new JButton("Muat Objek Config");

    buttonPanel.add(btnOpenText);
    buttonPanel.add(btnSaveText);
    buttonPanel.add(btnAppendText);
    buttonPanel.add(btnSaveBinary);
    buttonPanel.add(btnLoadBinary);
    buttonPanel.add(btnSaveObject);
    buttonPanel.add(btnLoadObject);

    // --- Layout ---
    add(new JScrollPane(textArea), BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // --- Event Handling ---

    // 1. Membaca File Teks (Text Stream)
    btnOpenText.addActionListener(e -> bukaFileTeks());

    // 2. Menulis File Teks (Text Stream)
    btnSaveText.addActionListener(e -> simpanFileTeks());

    // 3. Menulis File Binary (Byte Stream)
    btnSaveBinary.addActionListener(e -> simpanConfigBinary());

    // 4. Membaca File Binary (Byte Stream)
    btnLoadBinary.addActionListener(e -> muatConfigBinary());
    
    // 5. Menulis Objek (Object Stream - Serialization)
    btnSaveObject.addActionListener(e -> simpanObjectConfig());

    // 6. Membaca Objek (Object Stream - Deserialization)
    btnLoadObject.addActionListener(e -> muatObjectConfig());
    
    // 7. Menamhbah button text append
    btnAppendText.addActionListener(e -> tambahFileTeks());
    
    bacaFileOtomatis();
}

    // Contoh: Membaca File Teks dengan Try-Catch-Finally Konvensional
private void bukaFileTeks() {
    if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

        File file = fileChooser.getSelectedFile();
        BufferedReader reader = null;   // Deklarasi di luar try agar bisa ditutup di finally

        try {
            // Membuka stream
            reader = new BufferedReader(new FileReader(file));

            // Kosongkan area teks
            textArea.setText("");

            String line;

            // Baca file baris demi baris
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }

            JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "File tidak ditemukan: " + ex.getMessage());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal membaca file: " + ex.getMessage());

        } finally {
            // Blok finally: selalu dijalankan untuk menutup resource
            try {
                if (reader != null) {
                    reader.close();     // Menutup stream
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

// Contoh: Menulis File Teks menggunakan Try-With-Resources (Lebih Modern)
private void simpanFileTeks() {
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

        File file = fileChooser.getSelectedFile();

        // Try-with-resources otomatis menutup stream tanpa blok finally
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "File berhasil disimpan!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan file: " + ex.getMessage());
        }
    }
}

     //menambah fungsi buat button append text
     private void tambahFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
           
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                
                writer.newLine();
                writer.write(textArea.getText());
                
                JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan di baris baru!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan text: " + ex.getMessage());
            }
        }
    }

    // Menulis Binary (Menyimpan ukuran font ke file config.bin)
private void simpanConfigBinary() {
    try (DataOutputStream dos =
            new DataOutputStream(new FileOutputStream("config.bin"))) {

        int fontSize = textArea.getFont().getSize();
        dos.writeInt(fontSize);

        JOptionPane.showMessageDialog(this,
                "Ukuran font (" + fontSize + ") berhasil disimpan ke config.bin");

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this,
                "Gagal menyimpan binary: " + ex.getMessage());
    }
}


// Membaca Binary (Memuat ukuran font dari file config.bin)
private void muatConfigBinary() {
    try (DataInputStream dis =
            new DataInputStream(new FileInputStream("config.bin"))) {

        int fontSize = dis.readInt();

        textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
        JOptionPane.showMessageDialog(this,
                "Font berhasil diubah menjadi ukuran: " + fontSize);

    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this,
                "File config.bin belum dibuat! Simpan terlebih dahulu.");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this,
                "Gagal membaca binary: " + ex.getMessage());
    }
}


    

    // Metode baru untuk membaca file secara otomatis saat startup
private void bacaFileOtomatis() {
    File file = new File("last_notes.txt");
    
    // Gunakan Try-with-resources untuk memastikan resource tertutup
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        
        textArea.setText(""); // Kosongkan area teks
        String line;
        
        // Baca file baris demi baris
        while ((line = reader.readLine()) != null) {
            textArea.append(line + "\n");
        }
        
        // Tidak perlu JOptionPane, agar startup bersih
        System.out.println("last_notes.txt berhasil dimuat.");

    } catch (FileNotFoundException ex) {
        // Jika file tidak ada, tidak perlu memunculkan error/dialog.
        // Cukup diam atau berikan pesan debug.
        System.out.println("File last_notes.txt tidak ditemukan. Memulai dengan teks kosong.");
        textArea.setText("Selamat datang! Catatan terakhir tidak ditemukan.");

    } catch (IOException ex) {
        // Menangani error I/O lainnya (misalnya, izin akses)
        System.err.println("Gagal membaca file: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, 
                                "Gagal membaca file last_notes.txt: " + ex.getMessage(),
                                "Error IO", 
                                JOptionPane.ERROR_MESSAGE);
    }
}


    // Menulis Objek ke file (Serialization)
private void simpanObjectConfig() {
    
    // 1. Buat Objek
    UserConfig config = new UserConfig();
    
    // Asumsi: Isi data dari inputan pengguna (Anda bisa mengganti ini)
    String inputUsername = JOptionPane.showInputDialog(this, "Masukkan Username:");
    if (inputUsername == null || inputUsername.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Penyimpanan dibatalkan.");
        return;
    }
    
    config.setUsername(inputUsername);
    config.setFontsize(textArea.getFont().getSize()); 

    // 2. Tulis Objek ke file 'config.ser'
    try (ObjectOutputStream oos = 
            new ObjectOutputStream(new FileOutputStream("config.ser"))) {

        oos.writeObject(config);
        
        JOptionPane.showMessageDialog(this, 
                "Objek UserConfig (User: " + config.getUsername() + ", Size: " + config.getFontsize() + 
                ") berhasil disimpan ke config.ser.");

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, 
                "Gagal menyimpan objek: " + ex.getMessage());
    }
}


    // Membaca Objek dari file (Deserialization)
private void muatObjectConfig() {
    try (ObjectInputStream ois = 
            new ObjectInputStream(new FileInputStream("config.ser"))) {

        // 1. Baca Objek dan lakukan Casting
        UserConfig config = (UserConfig) ois.readObject();

        // 2. Terapkan data ke UI
        textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontsize()));

        JOptionPane.showMessageDialog(this, 
                "Konfigurasi dimuat: User = " + config.getUsername() + 
                ", Font Size = " + config.getFontsize());
        
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this, 
                "File config.ser belum ditemukan. Silakan simpan objek terlebih dahulu.");
        
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(this, 
                "Kesalahan Deserialisasi: Kelas UserConfig tidak ditemukan.");
        
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, 
                "Gagal memuat objek: " + ex.getMessage());
    }
}

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}
