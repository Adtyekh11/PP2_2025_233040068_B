package PP2_2025_233040068_B.Modul08.controller;

import PP2_2025_233040068_B.Modul08.model.PersegiPanjangModel;
import PP2_2025_233040068_B.Modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {

    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;
        
        //
        this.view.addResetListener(new ResetListener());
        
        // Listener untuk tombol hitung luas
        this.view.addHitungListener(new HitungListener());

        // Listener untuk tombol hitung keliling
        this.view.addHitungKelilingListener(new HitungKelilingListener());
    }

 
    // Listener Hitung Luas
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungLuas();

                double hasil = model.getLuas();
                view.setHasil(hasil);

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }


    // Listener Hitung Keliling
    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.HitungKeliling();

                double hasilKeliling = model.getKeliling();
                view.setHasil(hasilKeliling);

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
    
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.reset(); 
        }
    }
}

