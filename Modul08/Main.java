/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul08;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */


import PP2_2025_233040068_B.Modul08.controller.PersegiPanjangController;
import PP2_2025_233040068_B.Modul08.model.PersegiPanjangModel;
import PP2_2025_233040068_B.Modul08.view.PersegiPanjangView;

import PP2_2025_233040068_B.Modul08.model.PersegiPanjangModel;

import PP2_2025_233040068_B.Modul08.view.PersegiPanjangView;

import PP2_2025_233040068_B.Modul08.controller.PersegiPanjangController;

public class Main {
    public static void main(String[] args) {

        // 1. Instansiasi Model
        PersegiPanjangModel model = new PersegiPanjangModel();

        // 2. Instansiasi View
        PersegiPanjangView view = new PersegiPanjangView();

        // 3. Instansiasi Controller (Hubungkan Model & View)
        PersegiPanjangController controller = new PersegiPanjangController(model, view);

        // 4. Tampilkan View
        view.setVisible(true);
    }
}
