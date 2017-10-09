/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller.ruang;

import com.tabeldata.configs.Ruang;
import com.tabeldata.dao.RuangDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/ruang/ubah"})
public class RuangUpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            Integer kodeRuang = Integer.valueOf(req.getParameter("kodeRuang"));
            Ruang yaRuang = new RuangDao().findById(kodeRuang);
            req.setAttribute("ruang", yaRuang);
            req.getRequestDispatcher("/pages/ruang/editRuang.jsp").forward(req, resp);
            System.out.println("Kita di DoGet");
        } catch (SQLException ex) {
            Logger.getLogger(RuangUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doPost awal");
        Ruang ruang = new Ruang();

        ruang.setId(Integer.valueOf(req.getParameter("id")));
        ruang.setNoRuangan(req.getParameter("noRuangan"));
        ruang.setKosong(Boolean.valueOf(req.getParameter("kosong")));
        
        System.out.println("Kita di doPost tapi belum update nih");

        RuangDao ruangDao = new RuangDao();
        try {
            ruangDao.update(ruang);
            System.out.println("Baru eksekusi update");
        } catch (SQLException ex) {
            Logger.getLogger(RuangUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/");
        System.out.println("Baru send redirect ya");
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
