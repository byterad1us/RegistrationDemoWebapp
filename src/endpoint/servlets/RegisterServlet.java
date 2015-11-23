/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint.servlets;

import business.services.RegistrationException;
import business.services.RegistrationService;
import form.beans.UserData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author ouvre
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       UserData formBean;
       HttpSession session = request.getSession(true);
        try {
             
             Map<String,String[]> formData = request.getParameterMap();
             ConcurrentHashMap<String,String[]> tsFormData = new ConcurrentHashMap<String,String[]>();
             tsFormData.putAll(formData);
             formBean = new UserData(tsFormData);
             RegistrationService service = new RegistrationService();
             String userIdVal = service.registerNewUser(formBean);
     
             session.setAttribute("USER_ID", userIdVal);
             session.setAttribute("USER_DATA",formBean);
             session.setAttribute("REGISTERED",Boolean.TRUE);
        } 
        catch(Exception x){
          session.setAttribute("REGISTERED",Boolean.FALSE);
          session.setAttribute("ERROR",x); 
        }
      response.sendRedirect("confirmation.jsp");  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        try{
             out.write("<html><head><title>Invalid URL</title></head><body><br /><br /><br /><center><h1>Invalid HTTP method used: Get</h1></center></body></html>");
        }
       finally{
                out.close();
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
