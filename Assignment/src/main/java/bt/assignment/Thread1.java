/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kien Luu
 */
public class Thread1 extends StaffManager implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat();
                formater.applyPattern("hh:mm:ss aa");
                String time = formater.format(now);
                txtTime.setText(time);
            }
            catch (Exception e) {
                break;
            }
        }
    }
}
