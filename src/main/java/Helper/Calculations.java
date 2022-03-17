/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author sanda
 */
public class Calculations {
    public static float getDiscountedPrice(int oprice,int discPerc)
    {
        if(discPerc==0)
            return oprice;
        
        float sellingprice=oprice;
        
        sellingprice=(float)oprice-(discPerc/100.00f*oprice);
        return sellingprice;
    }
}
