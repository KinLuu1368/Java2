/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.io.Serializable;

/**
 *
 * @author Kien Luu
 */
public class Staff implements Serializable{
    private String fullname;
    private double salary;
    
    public Staff(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }
    
    public Staff() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
