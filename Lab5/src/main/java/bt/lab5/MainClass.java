/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bt.lab5;

import java.io.IOException;


/**
 *
 * @author Kien Luu
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            byte[] data = XFile.read("D:\\Java Lab2\\Data\\file1.txt");
            XFile.write("D:\\Java Lab2\\Data\\file2.txt", data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
