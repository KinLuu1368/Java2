/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab8;

/**
 *
 * @author Kien Luu
 */
public class ProductManager {
    public static void main(String[] args) {
        Product p1 = new Product("iPhone", 1000.0);
        Product p2 = new Product("Samsung galaxy Fold", 1200.0);
        
        ProductDAO dao = new ProductDAO();
        dao.add(p1);
        dao.add(p2);
        dao.store("D:\\Java Lab2\\Data\\prod1.dat");
        
        ProductDAO dao2 = new ProductDAO();
        dao2.load("D:\\Java Lab2\\Data\\prod1.dat");
        Product p = dao2.find("iPhone");
        System.out.println(">Name: " + p.name);
        System.out.println(">Price: " + p.price);
    }
}
