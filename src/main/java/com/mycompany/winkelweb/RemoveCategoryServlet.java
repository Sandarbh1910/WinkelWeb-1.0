/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.winkelweb;

import WinkelWeb_DAO.CategoryDAO;
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
public class RemoveCategoryServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            StringBuilder del=new StringBuilder();
             boolean result=true;
           String del_cat []=request.getParameterValues("del-cat");
           
            System.out.println("Reached remove cat servlet");
           if(del_cat!=null)
           {
               for(String s:del_cat)
               {System.out.println("s= "+s);
                   del.append("'"+s+"',");
               }
               del.deleteCharAt(del.length()-1);
               System.out.println("del= "+del);
               result=CategoryDAO.deleteCategory(del.toString());
               if(result!=true)
               {
                   httpsess.setAttribute("message","Error Could not delete");
           httpsess.setAttribute("dcol","0");
           response.sendRedirect("admin.jsp");
           return;
               }
               httpsess.setAttribute("message","Category deleted");
           httpsess.setAttribute("dcol","2");
           response.sendRedirect("admin.jsp");
           return;
           }
           httpsess.setAttribute("message","Please select atleast one category to proceed.");
           httpsess.setAttribute("dcol","1");
           response.sendRedirect("admin.jsp");
           
           return ;
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
