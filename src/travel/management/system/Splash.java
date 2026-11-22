package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1081, 500, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1081, 500);
        add(image);
        
        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }
    
    public static void main(String[] args) {
        Splash frame = new Splash();
        int x=1;
        for (int i = 1; i <= 500; x+=7, i+=6) {
            frame.setBounds(750 - (x+i)/2, 400 - (i/2), x + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
        } catch (Exception e) {
        }
    }
}
