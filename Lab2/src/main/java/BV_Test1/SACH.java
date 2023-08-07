/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BV_Test1;

/**
 *
 * @author Kien Luu
 */
public class SACH {
    private String Masach;
    private String Tensach;
    private String Loaisach;
    private Double Dongia;
    public SACH() {}
    
    public SACH(String Masach, String Tensach, String Loaisach, Double Dongia) {
        this.Masach = Masach;
        this.Tensach = Tensach;
        this.Loaisach = Loaisach;
        this.Dongia = Dongia;
    }

    public String getLoaisach() {
        return Loaisach;
    }

    public void setLoaisach(String Loaisach) {
        this.Loaisach = Loaisach;
    }

    public String getMasach() {
        return Masach;
    }

    public void setMasach(String Masach) {
        this.Masach = Masach;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String Tensach) {
        this.Tensach = Tensach;
    }

    public Double getDongia() {
        return Dongia;
    }

    public void setDongia(Double Dongia) {
        this.Dongia = Dongia;
    }
    
    
}
