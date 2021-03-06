/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.winkelweb;

import Helper.Validation;
import WinkelWeb_DAO.MerchantBusinessDetailsSubmissionDAO;
import WinkelWeb_POJO.UserCredentialsPOJO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class MerchantBusinessDetailsSubmissionServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
             response.setContentType("text/html;charset=UTF-8");
        HttpSession httpsess=request.getSession();
        String firmname=request.getParameter("mrfirmname");
        String gstno=request.getParameter("mrgstnumber");
        String accno=request.getParameter("mraccnumber");
        String ifsccode=request.getParameter("mrifsccode");
        String firmaddress=request.getParameter("mrfirmaddress");
        
        UserCredentialsPOJO merchant=(UserCredentialsPOJO)httpsess.getAttribute("merchant_details");
        httpsess.removeAttribute("merchant_details");
        if(!Validation.merchantBusinessDataEmptyValidation(firmname, gstno, accno, ifsccode, firmaddress))
        {
            httpsess.setAttribute("message", "Fields cannot be left empty.");
            httpsess.setAttribute("dcol","1");
            response.sendRedirect("merchantregister.jsp");
            return;
        }
        
        String res=MerchantBusinessDetailsSubmissionDAO.registerMerchant(merchant,firmname, gstno, accno, ifsccode, firmaddress);
        System.out.println("Reached servlet merchant business details submit ");
        if(res.equalsIgnoreCase("Registration Successful"))
        {
            httpsess.setAttribute("message",res);
            httpsess.setAttribute("dcol","2");
             response.sendRedirect("index.jsp");
            
            
        }
        else if(res.equalsIgnoreCase("Mobile/GST number already exists")){
            httpsess.setAttribute("message",res);
            httpsess.setAttribute("dcol","1");
             response.sendRedirect("merchantregister.jsp");
            
            
        }
        else{
             httpsess.setAttribute("message",res);
            httpsess.setAttribute("dcol","0");
            response.sendRedirect("merchantregister.jsp");
        }
        
        
        }
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
