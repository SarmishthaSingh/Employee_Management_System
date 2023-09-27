
package employee_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JTextField Ttextname,Ttextpassword;
    
    Login()
    {
        
        getContentPane().setBackground(Color.WHITE);
	setLayout(null);

        JLabel lblname=new JLabel("Username");
        lblname.setBounds(40, 20, 100, 30);
        add(lblname);
        
         Ttextname=new JTextField();
        Ttextname.setBounds(150,20,150,30);
        add( Ttextname);
        
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        Ttextpassword=new JTextField();
        Ttextpassword.setBounds(150,70,150,30);
        add( Ttextpassword);
        
        JButton login=new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
         
         try{
             String Username= Ttextname.getText();
             String Password= Ttextpassword.getText();
              Conn c=new Conn();
              String query="select * from login where Username='"+Username +"' and Password='"+Password+"'";
              ResultSet rs=c.s.executeQuery(query);
              if(rs.next())
              {
                  setVisible(false);
                  new Home();
              }
             else
              {
                  JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
                  setVisible(false);
              }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }
    
    public static void main(String args[])
    {
        new Login();
    }
}
