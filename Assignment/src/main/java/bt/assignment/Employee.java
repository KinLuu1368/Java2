/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.assignment;

import java.io.Serializable;

/**
 *
 * @author Kien Luu
 */
public class Employee implements Serializable{
    private String staffId;
    private String name;
    private int tuoi;
    private String email;
    private Double salary;
    
    public Employee(String staffId, String name, int tuoi, String email, Double salary) {
        this.staffId = staffId;
        this.name = name;
        this.tuoi = tuoi;
        this.email = email;
        this.salary = salary;
    }
    
    public Employee() {
        
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
