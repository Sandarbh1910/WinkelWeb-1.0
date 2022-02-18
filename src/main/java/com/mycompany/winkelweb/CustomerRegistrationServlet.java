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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class CustomerRegistrationServlet extends HttpServlet {

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
        String firstname=request.getParameter("crfirstname");
        String lastname=request.getParameter("crlastname");
        String mob=request.getParameter("crmob");
        String dob=request.getParameter("crdob");
        String email=request.getParameter("cremail");
        String password=request.getParameter("crpassword");
        String address=request.getParameter("craddress");
        UserCredentialsPOJO user=new UserCredentialsPOJO(firstname,lastname,mob,dob,email,password,address,"customer");
        System.out.println(user);
        
//        User Input Validation
        if(!Validation.registrationDataEmptyValidation(user))
        {
            
        httpsess.setAttribute("message","Fields cannot be empty!");
        httpsess.setAttribute("dcol","1");
        response.sendRedirect("index.jsp");
        return;
        }
        
//        Password validation
        if(!Validation.passwordValidation(password))
        {
             httpsess.setAttribute("message","Weak Password! Password should contain A-Z ,a-z ,0-9 and Special characters like ! ,@ ,# ,$ ,% ,^ ,& ,* ,( ,) ,_ ,? ");
        httpsess.setAttribute("dcol","1");
        response.sendRedirect("index.jsp");
            return;
        }
        String res=UserDAO.customerRegister(user);
        System.out.println("Reached servlet customer register");
        if(res.equalsIgnoreCase("Registration Successful"))
        {
            httpsess.setAttribute("message",res);
            httpsess.setAttribute("dcol","2");
            
        }
        else if(res.equalsIgnoreCase("Mobile/Email already exists")){
            httpsess.setAttribute("message",res);
            httpsess.setAttribute("dcol","1");
            
        }
        else{
             httpsess.setAttribute("message",res);
            httpsess.setAttribute("dcol","0");
            
        }
        response.sendRedirect("index.jsp");
        return;
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
