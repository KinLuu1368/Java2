/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab8;

import java.util.ArrayList;

/**
 *
 * @author Kien Luu
 */
public class Lab8Bai2 {
    public static void main(String[] args) {
        ArrayList<Integer> myarr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            myarr.add(i);
        }
        for (int i : myarr) {
            System.out.println(i);
        }
    }
}
