/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kien Luu
 */
public class EvenThread implements Runnable {
    @Override
    public void run() {
        for(int i = 1 ; i <= 10; i++) {
            try {
                Thread.sleep(10);
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(OddThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
