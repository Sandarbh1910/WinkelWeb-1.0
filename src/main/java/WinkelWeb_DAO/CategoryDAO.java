/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_DAO;

import WinkelWeb_DBUTIL.DBConnection;
import WinkelWeb_POJO.CategoryPOJO;
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
public class CategoryDAO {
    
    public static int getCatid()
    {
        int catid=-1;
        try{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(catid) from category");
        rs.next();
        catid=rs.getInt(1);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return catid++;
    }
    
    public static String addCategory(String title,String desc)
    {
        try{
            int catid=CategoryDAO.getCatid();
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into category values (?,?,?)");
            ps.setString(1,"C"+catid);
            ps.setString(2,title);
            ps.setString(3,desc);
            ps.executeUpdate();
            
        }catch(SQLIntegrityConstraintViolationException ex){
            ex.printStackTrace();
        return "Category already exists!";}
        catch(Exception ex){
            ex.printStackTrace();
            return "Could not add new category!";}
        return "Category added successfully!";
    }
    
    
    public static ArrayList<CategoryPOJO>loadCategory()
    {
        ArrayList<CategoryPOJO> arr=null;
        try{
            CategoryPOJO cat;
            Connection conn=DBConnection.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from category");
            arr=new ArrayList<CategoryPOJO>();
            while(rs.next())
            {
                cat=new CategoryPOJO(rs.getString("catid"),rs.getString("cattitle"),rs.getString("catdesc"));
                arr.add(cat);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();}
        return arr;
    }
    
    
    public static boolean deleteCategory(String del_cat)
    {
        try{
            System.out.println("Starting cat removal in catdao");
            System.out.println("del_cat = "+del_cat);
            Connection conn=DBConnection.getConnection();
            Statement st=conn.createStatement();
            st.executeUpdate("delete from category where cattitle in ("+del_cat+")");
           
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    
}
