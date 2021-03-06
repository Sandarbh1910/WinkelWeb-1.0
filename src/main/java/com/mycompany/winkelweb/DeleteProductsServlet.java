/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.winkelweb;

import WinkelWeb_DAO.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class DeleteProductsServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpsess=request.getSession();
        try  {
           String delpidlist[]=request.getParameterValues("del-prod-check");
           if(delpidlist==null)
           {
               httpsess.setAttribute("message","Please select a product to perform delete operation");
               httpsess.setAttribute("dcol","1");
               response.sendRedirect("merchant.jsp");
               return;
           }
           
           StringBuilder delstr=new StringBuilder();
           for(String s:delpidlist)
           {
               delstr.append(s+",");
           }
           delstr.deleteCharAt(delstr.length()-1);
            System.out.println("In del prod serv delstr= "+delstr.toString());
            String res=ProductDAO.deleteProducts(delstr.toString());
            if(res.equalsIgnoreCase("Product deleted Successfully!"))
            {
                httpsess.setAttribute("message",res);
               httpsess.setAttribute("dcol","2");
               response.sendRedirect("merchant.jsp");
               return;
            }
            else{
                httpsess.setAttribute("message",res);
               httpsess.setAttribute("dcol","2");
               response.sendRedirect("merchant.jsp");
               return;
            }
        }catch(Exception ex){ex.printStackTrace();}
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
