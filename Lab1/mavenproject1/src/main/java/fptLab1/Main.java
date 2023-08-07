/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fptLab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kien Luu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bai34();
    }
    
    public static void Bai2() {
        Scanner input = new Scanner(System.in);
        ManagerProduct managerProduct = new ManagerProduct();
        for (int i = 0; i < 5; i++) {
            Product sp = new Product();
            sp.Nhap();
            sp.Xuat();
        }
    }
    
   
    public static void Bai34() {
        ArrayList<Product> list = new ArrayList();
        Scanner input = new Scanner(System.in);
        Product product0 = new NoTaxProduct("Bao moi", 30000);
        Product product1 = new Product("banh my", 20000);
        Product product2 = new Product("banh canh", 30000);
        list.add(product0);
        list.add(product1);
        list.add(product2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Ten: "+ list.get(i).getName()+" Dongia: " + list.get(i).getDonGia()+" Thue: " + list.get(i).getImportTax());
        }
    }
}
