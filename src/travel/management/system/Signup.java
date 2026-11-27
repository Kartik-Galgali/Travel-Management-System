package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener{

    JTextField tfusername, tfname, tfanswer;
    JPasswordField tfpassword;
    Choice security;
    JButton create, back;
    
    public Signup() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(50, 100, 125, 25);
        p1.add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(50, 140, 130, 25);
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("Fav Character from Boys");
        security.add("Fav Marvel Superhero");
        security.add("Your Lucky Number");
        security.add("Your Childhood Superhero");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50, 180, 125, 25);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create = new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBorder(BorderFactory.createEmptyBorder());
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(580, 40, 250, 250);
        add(image);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            
            String user = tfusername.getText();
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("Select * from account where username = '"+user+"'");
                if (rs.next()) {
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username Already exists");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String name = tfname.getText();
            String pass = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            try {
                Conn conn = new Conn();
                String update = "insert into account value('"+user+"','"+name+"','"+pass+"','"+question+"','"+answer+"')";
                conn.s.executeUpdate(update);
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
}
