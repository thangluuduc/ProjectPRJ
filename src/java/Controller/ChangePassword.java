/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThangLD
 */
public class ChangePassword extends HttpServlet {

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
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String newPass = request.getParameter("newPass");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser(username, pass);
        if (user == null) {
            request.setAttribute("errorWrongAccount", 
                    "Wrong Password or Username. Please re-input");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        }
        userDAO.changePassword(username, pass, newPass);
        if(!checkPassword(newPass)){
            request.setAttribute("errorWrongAccount", 
                    "Password must be not empty, have no special characters"
                            + "and length more than 8. Please re-input");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login.jsp");
        }
    }
    private boolean checkPassword(String pass){
        Pattern p = Pattern.compile("[^0-9a-zA-Z]");
        if(p.matcher(pass).find() || pass.isEmpty() || pass.length() < 8){
            return false;
        }
        return true;
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
