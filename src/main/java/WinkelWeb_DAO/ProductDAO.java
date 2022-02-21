/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_DAO;

import WinkelWeb_DBUTIL.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author sanda
 */
public class ProductDAO {
    
    
    public static void productPermission(String seller,String permission)throws Exception
    {
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps1=conn.prepareStatement("update products set ppermission=? where pseller in (?)");
                ps1.setString(1, permission);
                ps1.setString(2, seller);
                ps1.executeUpdate();
    }
}
