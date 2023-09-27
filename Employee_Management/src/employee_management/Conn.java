
package employee_management;
import java.sql.*;
public class Conn {
     Connection c;
     Statement s;
    public Conn(){
        try
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          System.out.print("Hello");
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_managment","root","");
          s=c.createStatement();
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

   
    
}
