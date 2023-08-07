/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import bt.assignment.Employee;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Kien Luu
 */
public class Validation {
    public static boolean isEmpty(JTextField txtField, String msg) {
        String txtValue = txtField.getText().trim();
        if (txtValue.length() == 0) {
            JOptionPane.showMessageDialog(null, msg);
            txtField.setBackground(Color.pink);
            return true;
        }
        txtField.setBackground(Color.white);
        return false;        
    }
    
    public static boolean isEmail(JTextField txtField) {
        String txtEmail = txtField.getText().trim();
        String reEmail = ("\\w+@\\w+(\\.\\w+){1,3}");
        if (!txtEmail.matches(reEmail)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng Email");
            txtField.setBackground(Color.pink);
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }
    
    public static boolean checkAge(JTextField txtField) {
        int age = 0;
        try {
            age = Integer.parseInt(txtField.getText());
        } 
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tuổi từ 16-55");
            txtField.setBackground(Color.pink);
            return false;
        }
        if (age < 16 || age >= 55) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tuổi từ 16-55");
            txtField.setBackground(Color.pink);
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }
    
    public static boolean checkSalary(JTextField txtField) {
        Double salary = 0.0;
        try {
            salary = Double.valueOf(txtField.getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng định dạng lương");
            txtField.setBackground(Color.pink);
            return false;
        }
        if (salary <= 5000000) {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập lương trên 5,000,000");
            txtField.setBackground(Color.pink);
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }
    
    public static boolean isExist(JTextField txtField, List<Employee> list) {
        String staffId = txtField.getText();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getStaffId().equalsIgnoreCase(staffId)) {
                return true;
            } 
        }
        return false;
    }
}

