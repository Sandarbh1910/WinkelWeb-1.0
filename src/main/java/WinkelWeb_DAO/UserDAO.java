/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_DAO;

import WinkelWeb_DBUTIL.DBConnection;
import WinkelWeb_POJO.UserCredentialsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

/**
 *
 * @author sanda
 */
public class UserDAO {
    
     public static int getUserIdCount()
    { int usid=-1;
        try{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(usid) from user_credentials");
        rs.next();
        usid=rs.getInt(1);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return usid++;
    }
    
     
     
//     Customer Registration Module
     
     
    public static String customerRegister(UserCredentialsPOJO user)
    {
        int usid=UserDAO.getUserIdCount();
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into user_credentials  values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"WW"+usid);
            ps.setString(2,user.getFirstname());
            ps.setString(3,user.getLastname());
            ps.setString(4,user.getMob());
            ps.setString(5,user.getDob());
            ps.setString(6,user.getEmail());
            ps.setString(7,user.getPassword());
            ps.setString(8,user.getAddress());
            ps.setString(9,user.getUser_type());
            ps.setString(10,"default.jpeg");
            System.out.println("Reached regiser dao");
            ps.executeUpdate();
      
        }catch(SQLIntegrityConstraintViolationException ex)
        {
            ex.printStackTrace();
            return "Mobile/Email already exists";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "Could not register";
        }
        
        return "Registration Successful";
    }
    
    
    
//    Login Module
    
    public static UserCredentialsPOJO authenticateUser(String mob,String password)
    {
        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from user_credentials where mob=? and password=?");
            ps.setString(1, mob);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                UserCredentialsPOJO user=new UserCredentialsPOJO(rs.getString("firstname"),rs.getString("lastname"),rs.getString("mob"),rs.getString("dob"),rs.getString("email"),rs.getString("password"),rs.getString("address"),rs.getString("user_type"));
               
                return user;
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
