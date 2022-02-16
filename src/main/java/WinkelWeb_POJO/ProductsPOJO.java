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
    private String pTitle;
    private String pDesc;
    private String pPic;
    private int    pPrice;
    private int    pDisc;
    private int    pQuant;

    public ProductsPOJO(String pId, String pTitle, String pDesc, String pPic, int pPrice, int pDisc, int pQuant) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPic = pPic;
        this.pPrice = pPrice;
        this.pDisc = pDisc;
        this.pQuant = pQuant;
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
