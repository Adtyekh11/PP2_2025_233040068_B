/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP2_2025_233040068_B.Modul08.model;

/**
 *
 * @author ADITYA EKA HERIYAWAN
 */

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling;

    // Menghitung luas (Logika Bisnis)
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }

    // Setter Panjang
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
    // Menghitung keliling
    public void HitungKeliling() {
        this.keliling = 2*  (this.panjang + this.lebar);
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getLuas() {
        return luas;
    }
    
    public double getKeliling(){
        return keliling;
    }
    
    
}
