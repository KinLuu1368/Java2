/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptLab1;

import java.util.Scanner;

/**
 *
 * @author Kien Luu
 */
public class Product implements DAO{
    private String name;
    private Double donGia;
    Double tax;
    public Product(){}
    
    public Product(String name, double donGia) {
        this.name = name;
        this.donGia = donGia;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    double getImportTax() {
        return (donGia*0.1); 
    }
    
    public void Nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap Ten: ");
        String name1 = input.nextLine();
        System.out.print("Nhap Gia: ");
        Double donGia1 = Double.valueOf(input.nextLine());
        this.setName(name1);
        this.setDonGia(donGia1);
    }
    
    public void Xuat() {
        System.out.println("Ten: " + this.getName());
        System.out.println("Gia: " + this.getDonGia());
        System.out.println("Thue: "+ this.getImportTax());
    }
    
    @Override
    public void select() {
        System.out.println("Chọn thành công");
    }

    @Override
    public void insert() {
        System.out.println("Thêm thành công");
    }

    @Override
    public void delete() {
        System.out.println("xóa thành công");
    }

    @Override
    public void update() {
        System.out.println("Cập nhật thành công");
    }
}

