/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
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
public class CreateAccount extends HttpServlet {

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
        String email = request.getParameter("email");
        boolean checkErrorFormat = false;
        if(!checkUsername(username)){
            checkErrorFormat = true;
            request.setAttribute("errorCreateUsername", 
                    "Username must be not empty and have no special characters. Please re-input");
        }
        if(!checkPassword(pass)){
            checkErrorFormat = true;
            request.setAttribute("errorCreatePass", 
                    "Password must be not empty, have no special characters"
                            + "and length more than 8. Please re-input");
        }
        if(!checkEmail(email)){
            checkErrorFormat = true;
            request.setAttribute("errorCreateEmail", 
                    "Email must be format ...@... . Please re-input");
        }
        if(checkErrorFormat){
            request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
            return;
        }
        UserDAO userDAO = new UserDAO();
        boolean checkCreate = userDAO.createAccount(username, pass, email);
        if(checkCreate){
            request.setAttribute("errorCreateUser", "Acount will be exist. Please re-input");
            request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
        }else{
            response.sendRedirect("Login.jsp");
        }
    }
    
    private boolean checkUsername(String username){
        Pattern p = Pattern.compile("[^0-9a-zA-Z]");
        if(p.matcher(username).find() || username.isEmpty()){
            return false;
        }
        return true;
    }
    private boolean checkPassword(String pass){
        Pattern p = Pattern.compile("[^0-9a-zA-Z]");
        if(p.matcher(pass).find() || pass.isEmpty() || pass.length() < 8){
            return false;
        }
        return true;
    }
    private boolean checkEmail(String email){
        email = email.trim();
        Pattern pChracter = Pattern.compile("[@]");
        Pattern pText = Pattern.compile("[^0-9a-zA-Z]");
        if(email.isEmpty()){
            return false;
        }else if(!pChracter.matcher(email).find()){
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
