/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_POJO;

/**
 *
 * @author sanda
 */
public class CategoryPOJO {
   
    private String catTitle;
    private String catDesc;

    public CategoryPOJO( String catTitle, String catDesc) {
       
        this.catTitle = catTitle;
        this.catDesc = catDesc;
    }

    

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
    
    
}
