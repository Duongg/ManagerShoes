/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.shoes.ShoesSizeDAO;
import manager.shoes.ShoesSizeDTO;
import manager.shoesdao.ShoesDAO;
import manager.shoesdto.ShoesError;

/**
 *
 * @author DELL
 */
public class CreateShoesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private final String productPage = "productList";
     private final String newShoesPage = "editshoes.html";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String url = productPage;
        String id = request.getParameter("id");
        String shoesID = request.getParameter("shoesID");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String size = request.getParameter("sizes");
        String country = request.getParameter("country");
        boolean error = false;
        ShoesError errorShoes = new ShoesError();
        float pri = 0;
        int siz = 0;
        int quan = 0;
        try {
            if(shoesID.trim().length() < 1 || shoesID.trim().length() >  10){
                error = true;
                errorShoes.setShoesID("Description length requires from 2 - 10 chars");
            }
            if(description.trim().length() < 1 || description.trim().length() >  10){
                error = true;
                errorShoes.setDescriptionErr("Description length requires from 1 - 10 chars");
            }
            try {
                pri = Float.parseFloat(price); 
                if(pri < 0){
                    error = true;
                    errorShoes.setPriceErr("Price is positive number");
                }
            } catch (Exception e) {
                error = true;
                errorShoes.setPriceErr("Price is positive number");
            }
            try {
                siz = Integer.parseInt(size);
                if(siz < 0){
                   error = true;
                   errorShoes.setSizesErr("Size is positive number");
                }
            } catch (Exception e) {
                error = true;
                errorShoes.setSizesErr("Size is positive number");
            }
            try {
                quan = Integer.parseInt(quantity);
                if(quan < 0){
                   error = true;
                   errorShoes.setQuantityErr("Quantity is positive number");
                }
                
            } catch (Exception e) {
                error = true;
                errorShoes.setQuantityErr("Quantity is positive number");
            }
            if(error){
                request.setAttribute("CREATE", errorShoes);
                 RequestDispatcher rd = request.getRequestDispatcher("editshoes.jsp");
                 rd.forward(request, response);
            }else{
                
                ShoesSizeDTO newshoes = new ShoesSizeDTO(shoesID, id, quan, pri, country);
                ShoesSizeDAO newshoesdao = new ShoesSizeDAO();
                newshoesdao.insertShoes(newshoes);
                ShoesDAO dao =new ShoesDAO();
                dao.insertShoes(shoesID, description);
            }
        }catch (SQLException ex) {
            log("CreateShoesServlet_SQL " + ex.getMessage());
        }catch(NamingException ex){
            log("CreateShoesServlet_Class Not Found " + ex.getMessage());
        }finally{
            response.sendRedirect(productPage);
            out.close();
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
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(CreateShoesServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NamingException ex) {
             Logger.getLogger(CreateShoesServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
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
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(CreateShoesServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NamingException ex) {
             Logger.getLogger(CreateShoesServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
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
