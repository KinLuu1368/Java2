/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyThread;

/**
 *
 * @author Kien Luu
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
            System.out.println(i);
        }
    }
    
    
    
    public static void main(String[] args) {
        MyThread Thread1 = new MyThread();
        MyThread Thread2 = new MyThread();
        Thread t1 = new Thread(Thread1);
        Thread t2 = new Thread(Thread2);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        
    }
}
