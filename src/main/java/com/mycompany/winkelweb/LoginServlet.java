
package com.mycompany.winkelweb;

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
public class LoginServlet extends HttpServlet {

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
            HttpSession httpsess=request.getSession();
           
            String mob=request.getParameter("logmob");
            String password=request.getParameter("logpassword");
             if(mob.equals("")&&password.equals(""))
           {
               httpsess.setAttribute("message","Fields cannot be left blank!!");
               httpsess.setAttribute("dcol", "1");
               response.sendRedirect("index.jsp");
               return;
               
           }
           
          UserCredentialsPOJO user= UserDAO.authenticateUser(mob,password);
           
            System.out.println("In ogin serv user="+user);
          if(user!=null)
          {
              String utype=user.getUser_type();
              System.out.println("utype "+utype);
              
              httpsess.setAttribute("current_user",user);
              if(utype.equalsIgnoreCase("customer"))
          {
              
                 response.sendRedirect("customer.jsp");
                 return;
          }
              
              else if(utype.equalsIgnoreCase("admin"))
          {
             
                  response.sendRedirect("admin.jsp");
                  
          }
              else if(utype.equalsIgnoreCase("merchant"))
              {
                  response.sendRedirect("merchant.jsp");
              }
          
          }
          
          
          else {
              System.out.println("reached loginservlet else part wrong password");
               httpsess.setAttribute("message","Invalid Username/Password!!");
               httpsess.setAttribute("dcol", "1");
               response.sendRedirect("index.jsp");
               return;
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
