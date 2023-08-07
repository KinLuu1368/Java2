/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptLab1;

/**
 *
 * @author Kien Luu
 */
public class NoTaxProduct extends Product {
    public NoTaxProduct(){
        
    } 
    public NoTaxProduct(String name, double donGia) {
        super(name,donGia);
    }
    
    @Override
    double getImportTax() {
        return 0;
    }
}
