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
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author sanda
 */
public class MerchantBusinessDetailsSubmissionDAO {
    
       public static String registerMerchant(UserCredentialsPOJO merchant,String firmname,String gstno,String accno,String ifsccode,String firmaddress)
    {
        try{
            Connection conn=DBConnection.getConnection();
            conn.setAutoCommit(false);
           try{
                PreparedStatement ps=conn.prepareStatement("insert into merchant_business_details  values (?,?,?,?,?,?)");
            ps.setString(1,firmname);
            ps.setString(2,gstno);
            ps.setString(3,accno);
            ps.setString(4,ifsccode);
            ps.setString(5, merchant.getMob());
            ps.setString(6,firmaddress);
               System.out.println("in merch dao :firmname="+firmname+", "+gstno+", "+accno+", "+ifsccode+", "+firmaddress+",");
            int usid=UserDAO.getUserIdCount();
             PreparedStatement ps1=conn.prepareStatement("insert into user_credentials  values (?,?,?,?,?,?,?,?,?,?)");
            ps1.setString(1,"WW"+usid);
            ps1.setString(2,merchant.getFirstname());
            ps1.setString(3,merchant.getLastname());
            ps1.setString(4,merchant.getMob());
            ps1.setString(5,merchant.getDob());
            ps1.setString(6,merchant.getEmail());
            ps1.setString(7,merchant.getPassword());
            ps1.setString(8,merchant.getAddress());
            ps1.setString(9,merchant.getUser_type());
            ps1.setString(10,"default.jpeg");
            System.out.println("Reached merchant  dao");
            ps.executeUpdate();
            ps1.executeUpdate();
            
           
           
            
           }catch(SQLIntegrityConstraintViolationException ex1)
        {
            ex1.printStackTrace();
            conn.rollback();
            return "Mobile/GST number already exists";
        }
           catch(Exception ex1){
               ex1.printStackTrace();
           conn.rollback();
               System.out.println("Rolling back");
           return "Could not register";}
           
           finally{
               conn.setAutoCommit(true);
           }
      
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "Could not register";
        }
        
        return "Registration Successful";
    }
    
}
