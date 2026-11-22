package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    Login(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(100, 80, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("San_serif",Font.PLAIN, 20));
        p2.add(lblusername);
        
        JTextField tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        setBounds(350, 200, 900, 400);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
