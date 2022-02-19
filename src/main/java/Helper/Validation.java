/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

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
        if(user.getFirstname().length()==0)
        {
            return false;
        }
        else if(user.getLastname().length()==0){return false;}
        else if(user.getMob().length()==0){return false;}
        else if(user.getDob().length()==0){return false;}
        else if(user.getEmail().length()==0){return false;}
        else if(user.getPassword().length()==0){return false;}
        else if(user.getAddress().length()==0){return false;}
        return true;
    }
    
    
    public static boolean merchantBusinessDataEmptyValidation(String firmname,String gstno,String accno,String ifsccode,String firmaddress)
    {
        if(firmname.length()==0)
        {return false;}
        else if(gstno.length()==0){return false;}
        else if(accno.length()==0){return false;}
        else if(ifsccode.length()==0){return false;}
        else if(firmaddress.length()==0){return false;}
        
        return true;
    }
    
    public static boolean loginDataEmptyValidation(String mob,String password)
    {
        int m=mob.length();
        int p=password.length();
        System.out.println("m="+m+" p="+p);
        if(m<=0)
        {
            System.out.println("login valid= "+false);
            return false;
        }
        else if(p<=0)
        {
            return false;
        }
        System.out.println("login valid= "+true);
        return true;
    }
    
    
    public static boolean mobValidation(String mob)
    {
        char ch=mob.charAt(0);
        if(mob.length()==10)
        {
            if((ch=='9')&&mob.length()<=10)
        { return true;}
        else if(ch=='8'){return true;}
        else if(ch=='7'){return true;}
        else if(ch=='6'){return true;}
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
        if(!has_small_letter.find())
        {return false;}
        
        else if(!has_capital_letter.find())
        {return false;}
        
        else if(!has_digit.find())
        {return false;}
        
        else if(!has_special.find())
        {return false;}
        
        return true;
        }
        
        return false;
    }
}
