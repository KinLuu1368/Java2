package MyThread;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Kien Luu
 */
public class TestThread {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        OddThread t1 = new OddThread();
        EvenThread t2 = new EvenThread();
        Thread m1 = new Thread(t1);
        Thread m2 = new Thread(t2);
        m1.start();
        m1.join();
        m2.start();
        
    }
    
}
