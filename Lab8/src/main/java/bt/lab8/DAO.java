/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 * @param <Entity>
 */
abstract public class DAO<Entity> {
    protected List<Entity> list = new ArrayList<>();
    public void add(Entity entity) {
        list.add(entity);
    }
    public void removeEntity(Entity entity) {
        list.remove(entity);
    }
    abstract public void update(Entity entity);
    abstract public Entity find(Serializable id);
    public void load(String path) {
        try {
            try (FileInputStream fis = new FileInputStream(path); 
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                list = (List<Entity>) ois.readObject();
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void store(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
