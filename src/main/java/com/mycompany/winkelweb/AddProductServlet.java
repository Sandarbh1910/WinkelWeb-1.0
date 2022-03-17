/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.winkelweb;

import Helper.UploadData;
import Helper.Validation;
import WinkelWeb_DAO.ProductDAO;
import WinkelWeb_POJO.ProductsPOJO;
import WinkelWeb_POJO.UserCredentialsPOJO;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author sanda
 */@javax.servlet.annotation.MultipartConfig(fileSizeThreshold=1024 * 1024 * 2 //2 MB
         ,maxFileSize=1024 * 1024 * 10 //10MB
         )
public class AddProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;multipart/form-data");
        HttpSession httpsess=request.getSession();
        try  {
           String ptitle=request.getParameter("ptitle");
           String pdesc=request.getParameter("pdesc");
           int pprice=Integer.parseInt(request.getParameter("pprice"));
           int pdisc=Integer.parseInt(request.getParameter("pdisc"));
           int pquant=Integer.parseInt(request.getParameter("pquant"));
           String pcat=request.getParameter("pcat");
           String seller=((UserCredentialsPOJO)httpsess.getAttribute("current_user")).getUsid();
           ProductsPOJO prod=new ProductsPOJO(ptitle,pdesc,null,pprice,pdisc,pquant);
           boolean val=Validation.addProductDataEmptyValidation(prod);
           if(!val)
           {
               httpsess.setAttribute("message","Please fill all the fields!");
               httpsess.setAttribute("dcol","1");
               response.sendRedirect("merchant.jsp");
               return;
           }
            System.out.println("In add prod servlet= "+prod+"  "+pcat+"  "+seller);
//            Saving Product Image
              Collection<Part>prodPics=request.getParts();
              System.out.println("ProdPics "+prodPics);
              String path="";
              String filepath="";
              String filename="";
              
              System.out.println("Path before = "+request.getRealPath("ProductImages"));
              System.out.println("File separator "+File.separator);
              System.out.println("Product id= "+ProductDAO.getNewProductId());
               path=request.getRealPath("ProductImages")+File.separator+"Product"+ProductDAO.getNewProductId();
              System.out.println("Path after = "+path);
              for(Part pic:prodPics)
              {System.out.println("PIC= "+pic);
              filepath=""+path;
              
                  System.out.println("filename= "+pic.getSubmittedFileName());
                  filename=pic.getSubmittedFileName();
                  if(filename!=null)
                  {
//                     
                  File f=new File(path);
                  if(!f.exists())
                  f.mkdir();
                             filepath=filepath.concat(File.separator+filename);
                  
                  f.setWritable(true);
                  System.out.println("filePath= "+filepath);
                  
                  UploadData.uploadData(filepath,pic.getInputStream());}
              }








//            Saving Product Details
           String res=ProductDAO.addProduct(prod,pcat,seller);
           
           
           if(res.equalsIgnoreCase("Product Added Successfully!"))
           {
               httpsess.setAttribute("message",res);
               httpsess.setAttribute("dcol","2");
              
           }
           else if(res.equalsIgnoreCase("Product already exists!"))
           {
               httpsess.setAttribute("message",res);
               httpsess.setAttribute("dcol","1");
              
           }
           else{
               httpsess.setAttribute("message",res);
               httpsess.setAttribute("dcol","0");
              
           }
           
           
        }catch(NumberFormatException ex1){
        ex1.printStackTrace();
         httpsess.setAttribute("message","Please enter valid input");
               httpsess.setAttribute("dcol","1");
              
        }catch(Exception ex){ex.printStackTrace();
         httpsess.setAttribute("message","Some error occured .Try after some time.");
               httpsess.setAttribute("dcol","0");
               }
         finally{response.sendRedirect("merchant.jsp");
               return;}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
