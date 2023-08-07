/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab3;

/**
 *
 * @author Kien Luu
 */
public class Student {
    String name;
    double marks;
    String major;
        
    public String getGrade(){
        if (this.marks < 3){
            return "Kem";
        }
        else if (this.marks < 5){
            return "Yeu";
        }
        else if(this.marks < 6.5){
        return "Trung binh";
        }
            else if(this.marks < 7.5){
                return "Kha";
            }
            else if(this.marks < 9){
                return "Gioi";
            } 
            else {
                return "Xuat sac";
            }
        }    
    public boolean isBonus(){
            return this.marks >= 7.5;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
