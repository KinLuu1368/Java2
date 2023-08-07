/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;
import bt.assignment.Employee;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Kien Luu
 */
public class Extensions {
    public static int getLocate(JTextField field, List<Employee> list) {
        String id = field.getText();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStaffId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}
