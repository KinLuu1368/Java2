/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bt.lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class Main2 {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        List<Student> list = new ArrayList<>();
        final String path = "D:\\Java Lab2\\\\Data\\\\listStudent1.dat";
        list.add(new Student("Tuan", 5, "CNTT"));
        list.add(new Student("Cuong", 7.5, "TKTW"));
        list.add(new Student("Hanh", 8.5, "CNTT"));
        XFile.writeObject(path, list);
        
        try {
            List<Student> list2 = (List<Student>) XFile.readObject(path);
            for (Student sv : list2) {
                System.out.println("Name: " + sv.getName() + " Mark: " + sv.getMarks() + " Major: " + sv.getMajor());
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
}
