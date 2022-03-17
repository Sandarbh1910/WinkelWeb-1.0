/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author sanda
 */
public class UploadData {
    public static boolean uploadData(String path,InputStream source)
    {
        try{
            System.out.println("Path in uplod Data "+path);
            FileOutputStream fos=new FileOutputStream(path);
            
            
            byte []rd=new byte[source.available()];
            
            source.read(rd);
            
            fos.write(rd);
            fos.close();
            source.close();
        }catch(Exception ex){ex.printStackTrace();return false;}
        return true;
    }
}
