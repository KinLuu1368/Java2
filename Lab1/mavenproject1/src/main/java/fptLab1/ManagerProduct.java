/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptLab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class ManagerProduct {
    List<Product> product;
    
    public ManagerProduct() {
        this.product = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        this.product.add(product);
    }
    
    public void showProduct() {
        this.product.forEach(o -> System.out.println(o.toString()));
    }
    
    
}
