/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package bt.lab7;

/**
 *
 * @author Kien Luu
 */
public class Bai1 {

    public enum Career {
        UDPM, TKTW, LTDD, TKDH
    }
    
    public static class PolyStudent {
        public String fullname;
        public Career career;
        
        public void print() {
            System.out.println(">Fullname" + this.fullname);
            switch(this.career) {
                case UDPM:
                    System.out.println(">Career: Ung dung phan mem");
                    break;
                case TKTW:
                    System.out.println(">Career: Thiet ke trang web");
                    break;
                case LTDD:
                    System.out.println(">Career: Lap trinh di dong");
                    break;
                case TKDH:
                    System.out.println(">Career: Thiet ke do hoa");
                    break;
            }
        }
        
    }
    public static void main(String[] args) {
        PolyStudent sv = new PolyStudent();
        sv.fullname = "Nguyen Van Teo";
        //sv.career = Career.UDPM;
        sv.career = Career.valueOf("UDPM");
        sv.print();
    }
}
