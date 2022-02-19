/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.winkelweb;

import Helper.Validation;
import WinkelWeb_DAO.UserDAO;
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
public class MerchantRegistrationServlet extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
        HttpSession httpsess=request.getSession();
        String firstname=request.getParameter("mrfirstname");
        String lastname=request.getParameter("mrlastname");
        String mob=request.getParameter("mrmob");
        String dob=request.getParameter("mrdob");
        String email=request.getParameter("mremail");
        String password=request.getParameter("mrpassword");
        String address=request.getParameter("mraddress");
        UserCredentialsPOJO merchant=new UserCredentialsPOJO(firstname,lastname,mob,dob,email,password,address,"merchant");
//        Empty field validation
        if(!Validation.registrationDataEmptyValidation(merchant))
        {
            
        httpsess.setAttribute("message","Fields cannot be empty!");
        httpsess.setAttribute("dcol","1");
        response.sendRedirect("merchantregister.jsp");
        return;
        }
        //        Mobile no validation
         if(!Validation.mobValidation(mob))
        {
             httpsess.setAttribute("message","Invalid Mobile number");
        httpsess.setAttribute("dcol","1");
        response.sendRedirect("merchantregister.jsp");
            return;
        }
         
//         Password validation
        if(!Validation.passwordValidation(password))
        {
             httpsess.setAttribute("message","Weak Password! Password should contain minimum 8 characters including A-Z ,a-z ,0-9 and Special characters like ! ,@ ,# ,$ ,% ,^ ,& ,* ,( ,) ,_ ,? ");
        httpsess.setAttribute("dcol","1");
        response.sendRedirect("merchantregister.jsp");
            return;
        }
        System.out.println(merchant);
        
        httpsess.setAttribute("merchant_details", merchant);
        response.sendRedirect("merchant_business_details.jsp");
        System.out.println("Reached servlet merchant register");
        
        
        
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
