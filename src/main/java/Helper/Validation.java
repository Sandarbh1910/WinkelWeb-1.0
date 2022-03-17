/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import WinkelWeb_POJO.ProductsPOJO;
import WinkelWeb_POJO.UserCredentialsPOJO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sanda
 */
public class Validation {
    public static boolean registrationDataEmptyValidation(UserCredentialsPOJO user)
    {
        if((user.getFirstname().length()!=0)&&(user.getLastname().length()!=0)&&(user.getMob().length()!=0)&&(user.getDob().length()!=0)&&(user.getEmail().length()!=0)&&(user.getPassword().length()!=0)&&(user.getAddress().length()!=0))
        {
            return true;
        }
        return false;
    }
    
    
    public static boolean merchantBusinessDataEmptyValidation(String firmname,String gstno,String accno,String ifsccode,String firmaddress)
    {
        
        if(firmname.length()!=0&&gstno.length()!=0&&accno.length()!=0&&ifsccode.length()!=0&&firmaddress.length()!=0)
        {
            return true;
        }
        return false;
    }
    
    public static boolean loginDataEmptyValidation(String mob,String password)
    {   
        
        if(mob.length()!=0&&password.length()!=0)
        {return true;}
        return false;
    }
    
    
    public static boolean mobValidation(String mob)
    {
        char ch=mob.charAt(0);
        if(mob.length()==10)
        {

            
            if(ch=='9'||ch=='8'||ch=='7'||ch=='6')
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    public static boolean passwordValidation(String password)
    {
         if(password.length()>=8)
        {
            Pattern small_letter=Pattern.compile("[a-z]");
            Pattern capital_letter=Pattern.compile("[A-Z]");
        Pattern digits=Pattern.compile("[0-9]");
        Pattern special=Pattern.compile("[!@#$%^&*()_?]");
        Matcher has_small_letter=small_letter.matcher(password);
        Matcher has_capital_letter=capital_letter.matcher(password);
        Matcher has_digit=digits.matcher(password);
        Matcher has_special=special.matcher(password);
   
          return (has_small_letter.find()&&has_capital_letter.find()&&has_digit.find()&&has_special.find());
        }
         return false;
   }
    
    
    public static boolean addCategoryDataEmptyValidation(String title,String desc)
    {   
        
        if(title.length()!=0&&desc.length()!=0)
        {return true;}
        return false;
    }
    
    
    public static boolean addProductDataEmptyValidation(ProductsPOJO prod)
    {
        if(prod.getPbrand().isEmpty()||prod.getpTitle().isEmpty()||prod.getpDesc().isEmpty()||prod.getpPrice()==0||prod.getpQuant()==0||prod.getpDisc()==0)
        {
            return false;
        }
        return true;
    }
}
