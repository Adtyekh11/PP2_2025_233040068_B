/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul10;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */

import PP2_2025_233040068_B.Modul10.controller.MahasiswaController;
import PP2_2025_233040068_B.Modul10.model.MahasiswaModel;
import PP2_2025_233040068_B.Modul10.view.MahasiswaView;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaView view = new MahasiswaView();
            MahasiswaModel model = new MahasiswaModel();
            
            new MahasiswaController(view, model);
            
            view.setVisible(true);
        });
    }
}