/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_DAO;

import WinkelWeb_DBUTIL.DBConnection;
import WinkelWeb_POJO.CategoryPOJO;
import WinkelWeb_POJO.UserCredentialsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class UserDAO {
    
//     public static int getUserIdCount()
//    { int usid=-1;
//        try{
//        Connection conn=DBConnection.getConnection();
//        Statement st=conn.createStatement();
//        ResultSet rs=st.executeQuery("select count(usid) from user_credentials");
//        rs.next();
//        usid=rs.getInt(1);
//        }catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return usid++;
//    }
    
     
     
//     Customer Registration Module
     
     
    public static String customerRegister(UserCredentialsPOJO user)
    {
//        int usid=UserDAO.getUserIdCount();
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into user_credentials  values (?,?,?,?,?,?,?,?,?,?,'active')");
            ps.setString(1,"WW"+user.getMob());
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
    
    
    
     public static void merchantRegister(UserCredentialsPOJO user)throws SQLIntegrityConstraintViolationException,Exception
    {

        
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into user_credentials  values (?,?,?,?,?,?,?,?,?,?,'active')");
            ps.setString(1,"WW"+user.getMob());
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
      
        
        
        return ;
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
               if(rs.getString("user_status").equalsIgnoreCase("deactive"))
                   return null;
                return user;
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
    public static boolean blockUser(String mob)
    {
        try{
            Connection conn=DBConnection.getConnection();
            conn.setAutoCommit(false);
            try{
                PreparedStatement ps=conn.prepareStatement("update user_credentials set user_status='deactive' where mob=?");
                ps.setString(1, mob);
//                PreparedStatement ps1=conn.prepareStatement("update products set ppermission='denied' where pseller=?");
//                ps1.setString(1, mob);
                ps.executeUpdate();
                ProductDAO.productPermission(mob,"denied");
//                ps1.executeUpdate();
            }catch(Exception ex1){ex1.printStackTrace();
            conn.rollback();
            return false;}
            finally{
                conn.setAutoCommit(true);
            }
        }catch(Exception ex){
            ex.printStackTrace();return false;}
        return true;
    }
    
    
    public static boolean unblockUser(String unblock)
    {
          try{
               System.out.println("Starting unblock in userdao");
            System.out.println("unblock = "+unblock);
            Connection conn=DBConnection.getConnection();
              try{
              Statement st=conn.createStatement();
            st.executeUpdate("update user_credentials set user_status='active' where mob in ("+unblock+")");
           ProductDAO.productPermission(unblock,"granted");
              }catch(Exception ex1){
                  ex1.printStackTrace();
                  conn.rollback();
                  return false;}
              finally{
                  conn.setAutoCommit(false);}
           
            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public static ArrayList<UserCredentialsPOJO> loadBlockedUsers()
    {
        ArrayList<UserCredentialsPOJO> arr=null;
        try{
            UserCredentialsPOJO user;
            Connection conn=DBConnection.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from user_credentials where user_status='deactive'");
            arr=new ArrayList<UserCredentialsPOJO>();
            while(rs.next())
            {
                user=new UserCredentialsPOJO(rs.getString("firstname"),rs.getString("lastname"),rs.getString("mob"),rs.getString("dob"),rs.getString("email"),null,rs.getString("address"),rs.getString("user_type"));
                arr.add(user);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();}
        return arr;
    }
    
    
}
