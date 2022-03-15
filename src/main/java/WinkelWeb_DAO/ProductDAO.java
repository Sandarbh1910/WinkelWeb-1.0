/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_DAO;

import WinkelWeb_DBUTIL.DBConnection;
import WinkelWeb_POJO.ProductsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class ProductDAO {
    public static ArrayList<String>loadPid(String seller)
    { ArrayList<String>pidlist=new ArrayList<>();
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select  pid from products where pseller=?");
            ps.setString(1, seller);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                pidlist.add(rs.getString(1));
            }
        }catch(Exception ex){ex.printStackTrace();}
        System.out.println("pid= "+pidlist);
        return pidlist;
    }
    
    public static void productPermission(String seller,String permission)throws Exception
    {
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set ppermission=? where pseller in (?)");
                ps1.setString(1, permission);
                ps1.setString(2, seller);
                ps1.executeUpdate();
    }
    
    
    public static ArrayList<ProductsPOJO> getProducts()
    {
        ArrayList<ProductsPOJO>prodlist=new ArrayList<ProductsPOJO>();
        
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select * from products");
         ResultSet rs=ps1.executeQuery();
         while(rs.next())
         {ProductsPOJO p=new ProductsPOJO(rs.getString("pid"),rs.getString("ptitle"),rs.getString("pdesc"),rs.getString("ppic"),rs.getInt("pprice"),rs.getInt("pdisc"),rs.getInt("pquant"));
             prodlist.add(p);
         }
        }catch(Exception ex)
        {ex.printStackTrace();}
        return prodlist;
    }
    
    
    public static String updateProductDetails(ProductsPOJO p)
    {
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set ptitle=?,pdesc=?,pprice=?,pquant=?");
         ps1.setString(1, p.getpTitle());
         ps1.setString(2, p.getpDesc());
         ps1.setInt(3, p.getpPrice());
         ps1.setInt(4, p.getpQuant());
         ps1.executeUpdate();
         
         
        }catch(Exception ex)
        {ex.printStackTrace();
        return "Could not update !!!!";}
        return "Product details Updated!";
    }
    
    
    public static boolean discountAllAt(int perc)
    {
        try{
            Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set pdisc=?");
         ps1.setInt(1, perc);
        }catch(Exception ex){ex.printStackTrace();return false;}
        return true;
    }
    
    
     
    public static boolean discountProductAt(int perc,String pid)
    {
        try{
            Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set pdisc=? where pid=?");
         ps1.setInt(1, perc);
         ps1.setString(2, pid);
        }catch(Exception ex){ex.printStackTrace();return false;}
        return true;
    }
}
