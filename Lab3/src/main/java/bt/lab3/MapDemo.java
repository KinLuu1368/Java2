package bt.lab3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Kien Luu
 */
public class MapDemo {


    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student sv1 = new Student();
        sv1.name = "Tuan";
        sv1.major = "CNTT";
        sv1.marks = 7.0;
        map.put(sv1.name, sv1);
        
        Student sv2 = new Student();
        sv2.name = "Teo";
        sv2.major = "CNTT";
        sv2.marks = 8.0;
        map.put(sv2.name, sv2);
        
        Student sv3 = new Student();
        sv3.name = "Ti";
        sv3.major = "CNTT";
        sv3.marks = 6.0;
        map.put(sv3.name, sv3);
        
        Set<String> keyset = map.keySet();
        for (String i : keyset) {
            Student sv = map.get(i);
            System.out.println("Ho ten: " + sv.name);
            System.out.println("Hoc luc: " + sv.getGrade());
        }
        
    }
    
}
