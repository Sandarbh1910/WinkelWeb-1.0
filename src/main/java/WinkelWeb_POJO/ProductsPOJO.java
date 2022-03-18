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
public class ProductsPOJO {
    private String pId;
    private String pbrand;
    private String pTitle;
    private String pDesc;
    private String pPic;
    private int    pPrice;
    private int    pDisc;
    private int    pQuant;
    private String pcat;

    public String getPcat() {
        return pcat;
    }

    public void setPcat(String pcat) {
        this.pcat = pcat;
    }
    
    
    
    
    @Override
    public String toString() {
        return "ProductsPOJO{" + "pId=" + pId + ", pbrand=" + pbrand + ", pTitle=" + pTitle + ", pDesc=" + pDesc + ", pPic=" + pPic + ", pPrice=" + pPrice + ", pDisc=" + pDisc + ", pQuant=" + pQuant + '}';
    }
   
    
    
    
    
    public ProductsPOJO(String pbrand,String pTitle, String pDesc, int pPrice, int pQuant) {
        this.pbrand=pbrand;
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPrice = pPrice;
        this.pQuant = pQuant;
    }
    

    public ProductsPOJO(String pId,String pbrand, String pTitle, String pDesc, String pPic, int pPrice, int pDisc, int pQuant,String pcat) {
        this.pcat=pcat;
        this.pId = pId;
        this.pbrand=pbrand;
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPic = pPic;
        this.pPrice = pPrice;
        this.pDisc = pDisc;
        this.pQuant = pQuant;
    }

    public ProductsPOJO( String pbrand,String pTitle, String pDesc, String pPic, int pPrice, int pDisc, int pQuant) {
        this.pbrand=pbrand;
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPic = pPic;
        this.pPrice = pPrice;
        this.pDisc = pDisc;
        this.pQuant = pQuant;
    }

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

   
    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDisc() {
        return pDisc;
    }

    public void setpDisc(int pDisc) {
        this.pDisc = pDisc;
    }

    public int getpQuant() {
        return pQuant;
    }

    public void setpQuant(int pQuant) {
        this.pQuant = pQuant;
    }
    
}
