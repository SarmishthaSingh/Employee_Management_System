
package employee_management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener
{
        
    JButton Back,Add;
    JTextField tfeducation,tfname,tffname,tfempid,tfsalary,tfadd,tfphone,tfemail,tfdesig,tfadhar;
    
    JLabel labelempid;
    String  empid;
    public UpdateEmployee(String empid)
    {
        this.empid=empid;
      getContentPane().setBackground(Color.white);
      setLayout(null);
      JLabel heading=new JLabel("Update Employee Details");
      heading.setBounds(140, 30, 500, 50);
      heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
      add(heading);
      
      JLabel labelname=new JLabel("Name");
      labelname.setBounds(40, 150, 150, 30);
      labelname.setFont(new Font("SERIF",Font.BOLD,25));
      add(labelname);
      
      JLabel lblname=new JLabel();
      lblname.setBounds(200, 150, 150, 30);
      add(lblname);
      
      JLabel labelfname=new JLabel("Father's Name");
      labelfname.setBounds(450, 150, 150, 30);
      labelfname.setFont(new Font("SERIF",Font.BOLD,25));
      add(labelfname);
      
      tffname=new JTextField();
      tffname.setBounds(600, 150, 150, 30);
      add(tffname);
      
      JLabel labeldob=new JLabel("Date of Birth");
      labeldob.setBounds(40, 200, 150, 30);
      labeldob.setFont(new Font("SERIF",Font.BOLD,25));
      add(labeldob);
      
      JLabel lbldob=new JLabel();
      lbldob.setBounds(200, 200, 150, 30);
      add(lbldob);
      
      JLabel labelsalary=new JLabel("Salary");
      labelsalary.setBounds(450, 200, 150, 30);
      labelsalary.setFont(new Font("SERIF",Font.BOLD,25));
      add(labelsalary);
      
      tfsalary=new JTextField();
      tfsalary.setBounds(600, 200, 150, 30);
      add(tfsalary);
      
      JLabel labeladd=new JLabel("Address");
      labeladd.setBounds(40, 250, 150, 30);
      labeladd.setFont(new Font("SERIF",Font.BOLD,25));
      add(labeladd);
      
      tfadd=new JTextField();
      tfadd.setBounds(200, 250, 150, 30);
      add(tfadd);
      
      JLabel labelphone=new JLabel("Phone");
      labelphone.setBounds(450, 250, 150, 30);
      labelphone.setFont(new Font("SERIF",Font.BOLD,25));
      add(labelphone);
      
      tfphone=new JTextField();
      tfphone.setBounds(600, 250, 150, 30);
      add(tfphone);
      
       JLabel labelemil=new JLabel("Email");
      labelemil.setBounds(40, 300, 150, 30);
      labelemil.setFont(new Font("SERIF",Font.BOLD,25));
      add(labelemil);
      
      tfemail=new JTextField();
      tfemail.setBounds(200, 300, 150, 30);
      add(tfemail);
      
      JLabel labeledu=new JLabel("Highest Education");
      labeledu.setBounds(450, 300, 150, 30);
      labeledu.setFont(new Font("SERIF",Font.BOLD,25));
      add(labeledu);
      
      
      tfeducation=new JTextField();
      tfeducation.setBounds(600, 300, 150, 30);
      add(tfeducation);
      
      JLabel labeldesig=new JLabel("Designation");
      labeldesig.setBounds(40, 350, 150, 30);
      labeldesig.setFont(new Font("SERIF",Font.BOLD,25));
      add(labeldesig);
      
      tfdesig=new JTextField();
      tfdesig.setBounds(200, 350, 150, 30);
      add(tfdesig);
      
      JLabel labeladdhar=new JLabel("Aadhar Number");
      labeladdhar.setBounds(450, 350, 150, 30);
      labeladdhar.setFont(new Font("SERIF",Font.BOLD,25));
      add(labeladdhar);
      
      JLabel lbladhar=new JLabel();
      lbladhar.setBounds(600, 350, 150, 30);
      add(lbladhar);
      
      labelempid=new JLabel("Employee ID");
      labelempid.setBounds(40, 400, 150, 30);
      labelempid.setFont(new Font("SERIF",Font.BOLD,25));
      add(labelempid);
      
       tfempid=new JTextField();
      tfempid.setBounds(200, 400, 150, 30);
      add(tfempid);
      
      try{
          Conn c=new Conn();
          String query="select * from employee where empid='"+empid+"'";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next()){
              lblname.setText(rs.getString("name"));
              tffname.setText(rs.getString("fname"));
              lbldob.setText(rs.getString("dob"));
              tfsalary.setText(rs.getString("salary"));
              tfadd.setText(rs.getString("address")); 
              tfphone.setText(rs.getString("phone"));
              tfemail.setText(rs.getString("email"));
              tfeducation.setText(rs.getString("education"));
              tfdesig.setText(rs.getString("designation"));
              lbladhar.setText(rs.getString("aadhar"));
              tfempid.setText(rs.getString("empid")); 
              
          }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
        Add=new JButton("Update Details");
        Add.setBounds(250, 550, 150, 40);
        Add.addActionListener(this);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        add(Add);
        
        
        Back=new JButton("Back");
        Back.setBounds(450, 550, 150, 40);
        Back.addActionListener(this);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);      
        add(Back);
        
      
      setSize(600,500);
      setLocation(300,50);
      setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==Add){
           
             String fname=tffname.getText();
             String salary=tfsalary.getText();
             String address=tfadd.getText();
             String phone=tfphone.getText();
             String email=tfemail.getText();
             String education= tfeducation.getText();
             String designation=tfdesig.getText();
            
           
             
             try{
                 Conn conn=new Conn();
                 String query1="update  employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empid+"'";
                 conn.s.executeUpdate(query1);
                 JOptionPane.showMessageDialog(null,"Records Add Succesfully");
                 setVisible(false);
                 new Home();
                
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
         }
                
           }
    
    public static void main(String args[])
    {
        new UpdateEmployee("");
    }
    
}








