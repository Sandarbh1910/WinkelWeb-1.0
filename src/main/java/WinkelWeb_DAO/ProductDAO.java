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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class ProductDAO {
    
    
    public static int getNewProductId()
    {
        int pid=0;
         try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select max(pid) from products limit 1");
         
         ResultSet rs=ps1.executeQuery();
         rs.next();
         pid=rs.getInt(1);
             System.out.println(" in get new id method pcount= "+pid);
         
        }catch(Exception ex)
        {ex.printStackTrace();}
        return pid++;
    }
    
    public static int getProductCount()
    {
        int pcount=0;
         try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select count(pid) from products");
         
         ResultSet rs=ps1.executeQuery();
         rs.next();
         pcount=rs.getInt(1);
             System.out.println("pcount= "+pcount);
         
        }catch(Exception ex)
        {ex.printStackTrace();}
        return pcount;
    }
    
    
    public static ArrayList<Integer>loadPid(String seller)
    { ArrayList<Integer>pidlist=new ArrayList<>();
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select  pid from products where pseller=?");
            ps.setString(1, seller);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                pidlist.add(rs.getInt(1));
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
        ArrayList<ProductsPOJO>prodlist=null;
        
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select * from products");
         ResultSet rs=ps1.executeQuery();
         prodlist=new ArrayList<ProductsPOJO>();
         while(rs.next())
         {ProductsPOJO p=new ProductsPOJO(rs.getString("pid"),rs.getString("pbrand"),rs.getString("ptitle"),rs.getString("pdesc"),rs.getString("ppic"),rs.getInt("pprice"),rs.getInt("pdisc"),rs.getInt("pquant"),rs.getString("cattitle"));
             prodlist.add(p);
         }
        }catch(Exception ex)
        {ex.printStackTrace();}
        return prodlist;
    }
    
    
    public static ArrayList<ProductsPOJO>getProductsOfCategory(String cat)
    {
         ArrayList<ProductsPOJO>prodlist=null;
        
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select * from products where cattitle=?");
         ps1.setString(1, cat);
         ResultSet rs=ps1.executeQuery();
         prodlist=new ArrayList<ProductsPOJO>();
         while(rs.next())
         {ProductsPOJO p=new ProductsPOJO(rs.getString("pid"),rs.getString("pbrand"),rs.getString("ptitle"),rs.getString("pdesc"),rs.getString("ppic"),rs.getInt("pprice"),rs.getInt("pdisc"),rs.getInt("pquant"),rs.getString("cattitle"));
             prodlist.add(p);
         }
        }catch(Exception ex)
        {ex.printStackTrace();}
        return prodlist;
    }
    
    public static ProductsPOJO getProductDetails(int pid)
    {ProductsPOJO product=null;
        try{Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select * from products where pid=?");
         ps1.setInt(1, pid);
         ResultSet rs=ps1.executeQuery();
         rs.next();
         product=new ProductsPOJO(rs.getString("pid"),rs.getString("pbrand"),rs.getString("ptitle"),rs.getString("pdesc"),rs.getString("ppic"),rs.getInt("pprice"),rs.getInt("pdisc"),rs.getInt("pquant"),rs.getString("cattitle"));
          
         
        }catch(Exception ex)
        {ex.printStackTrace();}
        return product;
    }
    
    
    public static ArrayList<ProductsPOJO> getProductsInSellersInventory(String seller)
    {
         ArrayList<ProductsPOJO>prodlist=null;
        
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("select * from products where pseller=? order by cattitle desc");
         ps1.setString(1, seller);
         ResultSet rs=ps1.executeQuery();
         prodlist=new ArrayList<ProductsPOJO>();
         while(rs.next())
         {ProductsPOJO p=new ProductsPOJO(rs.getString("pid"),rs.getString("pbrand"),rs.getString("ptitle"),rs.getString("pdesc"),rs.getString("ppic"),rs.getInt("pprice"),rs.getInt("pdisc"),rs.getInt("pquant"),rs.getString("cattitle"));
             prodlist.add(p);
         }
        }catch(Exception ex)
        {ex.printStackTrace();}
        return prodlist;
    }
    
    public static String updateProductDetails(ProductsPOJO p,int pid)
    {
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set pbrand=?,ptitle=?,pdesc=?,pprice=?,pquant=? where pid=?");
          ps1.setString(1, p.getPbrand());
         ps1.setString(2, p.getpTitle());
         ps1.setString(3, p.getpDesc());
         ps1.setInt(4, p.getpPrice());
         ps1.setInt(5, p.getpQuant());
         ps1.setInt(6, pid);
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
         ps1.executeUpdate();
        }catch(Exception ex){ex.printStackTrace();return false;}
        return true;
    }
    
    
     
    public static boolean discountProductAt(int perc,int pid)
    {System.out.println("At discount product method");
        try{
            Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set pdisc=? where pid=?");
         ps1.setInt(1, perc);
         ps1.setInt(2, pid);
         ps1.executeUpdate();
        }catch(Exception ex){ex.printStackTrace();return false;}
        return true;
    }
    
    
    public static String addProduct(ProductsPOJO prod,String cat,String seller)
    {
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("insert into products (pbrand,ptitle,pdesc,ppic,pprice,pdisc,pquant,cattitle,pseller)values(?,?,?,?,?,?,?,?,?)");
         ps1.setString(1, prod.getPbrand());
         ps1.setString(2, prod.getpTitle());
         ps1.setString(3,prod.getpDesc());
         ps1.setString(4,prod.getpPic());
         ps1.setInt(5,prod.getpPrice());
         ps1.setInt(6,prod.getpDisc());
         ps1.setInt(7,prod.getpQuant());
         ps1.setString(8,cat);
         ps1.setString(9,seller);
         ps1.executeUpdate();
         
        }catch(SQLIntegrityConstraintViolationException ex1){
            ex1.printStackTrace();
            return "Product already exists!";}
        catch(Exception ex){
            ex.printStackTrace();
        return "Could not add product!";}
        return "Product Added Successfully!";
    }
    
    
    public static String deleteProducts(String pid)
    {
        try{
             Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("delete from products where pid in ("+pid+")");
         
         ps1.executeUpdate();
         
        }
        catch(Exception ex){
            ex.printStackTrace();
        return "Could not add product!";}
        return "Product deleted Successfully!";
    }
}
