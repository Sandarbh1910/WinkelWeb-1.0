/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_DAO;

import WinkelWeb_DBUTIL.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author sanda
 */
public class MerchantBusinessDetailsSubmissionDAO {
    
    public static String submitBusinessDetails(String firmname,String gstno,String accno,String ifsccode,String email,String firmaddress)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into merchant_business_details  values (?,?,?,?,?,?)");
            ps.setString(1,firmname);
            ps.setString(2,gstno);
            ps.setString(3,accno);
            ps.setString(4,ifsccode);
            ps.setString(5,email);
            ps.setString(6,firmaddress);
           
            System.out.println("Reached merchant business details regiser dao");
            ps.executeUpdate();
      
        }catch(SQLIntegrityConstraintViolationException ex)
        {
            ex.printStackTrace();
            return "GST number already exists";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "Could not register";
        }
        
        return "Details Submitted Successful";
    }
    
}
