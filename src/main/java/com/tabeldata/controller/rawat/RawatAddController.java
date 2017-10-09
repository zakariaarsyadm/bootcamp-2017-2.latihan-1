/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller.rawat;

import com.tabeldata.configs.Dokter;
import com.tabeldata.configs.Pasien;
import com.tabeldata.configs.Rawat;
import com.tabeldata.configs.Ruang;
import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author namhee
 */
@WebServlet(urlPatterns = {"/rawat/add"})
public class RawatAddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet TransaksiAddController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet TransaksiAddController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<Pasien> listPasien = new PasienDao().findAll();;
            List<Dokter> listDokter = new DokterDao().findAll();
            List<Ruang> listRuang = new RuangDao().findAll();

            req.setAttribute("listPasien", listPasien);
            req.setAttribute("listDokter", listDokter);
            req.setAttribute("listRuang", listRuang);
        } catch (SQLException ex) {
            Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
            req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        processRequest(request, response);
       Rawat rawat = new Rawat();

        try {
            Integer pasienId = Integer.valueOf(req.getParameter("pasienId"));    
            rawat.setPasien(new PasienDao().findById(pasienId));
            System.out.println(rawat.getPasien().toString());

            Integer dokterId = Integer.valueOf(req.getParameter("dokterId"));
            rawat.setDokter(new DokterDao().findById(dokterId));
            System.out.println(rawat.getDokter().toString());
            
            Integer ruangId = Integer.valueOf(req.getParameter("ruangId"));
            rawat.setRuang(new RuangDao().findById(ruangId));
            System.out.println(rawat.getRuang().toString());
            
            new RawatDao().addRawat(rawat);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
            resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath()).append("/rawat/list").toString());

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
