/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller.pasien;

import com.tabeldata.configs.Pasien;
import com.tabeldata.dao.PasienDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(urlPatterns = {"/pasien/ubah"})
public class PasienUpdateController extends HttpServlet {

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
            Integer kodePasien = Integer.valueOf(req.getParameter("kodePasien"));
            Pasien yaPasien;
            yaPasien = new PasienDao().findById(kodePasien);
            req.setAttribute("pasien", yaPasien);
            req.getRequestDispatcher("/pasien/editPasien.jsp").forward(req, resp);

        } catch (SQLException ex) {
            Logger.getLogger(PasienUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
        Pasien pasien = new Pasien();
        pasien.setId(Integer.valueOf(req.getParameter("id")));
        pasien.setNama(String.valueOf(req.getParameter("nama")));
        pasien.setAlamat(String.valueOf(req.getParameter("alamat")));
        pasien.setTanggalLahir(Date.valueOf(req.getParameter("tanggalLahir")));

        PasienDao pasienDao = new PasienDao();
        try {
            pasienDao.update(pasien);
        } catch (SQLException ex) {
            Logger.getLogger(PasienUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
