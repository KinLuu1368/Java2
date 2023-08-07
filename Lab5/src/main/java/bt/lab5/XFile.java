/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Kien Luu
 */
public class XFile {

    public static byte[] read(String path) throws FileNotFoundException, IOException {
        byte[] data;
        try ( FileInputStream fis = new FileInputStream(path)) {
            int length = fis.available();
            data = new byte[length];
            fis.read(data);
        }
        return data;
    }

    public static void write(String path, byte[] data) throws FileNotFoundException, IOException {
        try ( FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
        }
    }

    public static Object readObject(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (
                 FileInputStream fis = new FileInputStream(path);  ObjectInputStream ois = new ObjectInputStream(fis);) {
            return ois.readObject();
        }

    }

    public static void writeObject(String path, Object object) throws FileNotFoundException, IOException {
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));) {
            oos.writeObject(object);
        }
    }

}
