/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BEAN.Endereco;
import model.BEAN.Usuario;
import model.DAO.EnderecoDAO;

/**
 *
 * @author Senai
 */
public class CheckoutController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        String url = "/WEB-INF/jsp/checkout.jsp";
        System.out.println("Id Usuario Chekc: " + Usuario.getIdUsuario());
        request.setAttribute("idUsuario", Usuario.getIdUsuario());
        
        RequestDispatcher d = getServletContext().getRequestDispatcher(url);
        d.forward(request, response);
    }

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
        
        String url = request.getServletPath();
        
        if(url.equals("/inserirEndereco")){
        
            String estado = request.getParameter("estado");
            String cidade = request.getParameter("cidade");
            System.out.println(estado);
            System.out.println(cidade);
            
            int cep  = Integer.parseInt(request.getParameter("cep"));
            String nomeRua = request.getParameter("nomeRua");
            
            int idUsuario = Usuario.getIdUsuario();
            
            int numeroCasa = Integer.parseInt(request.getParameter("numeroCasa"));
            String complemento = request.getParameter("complemento");

            Endereco e = new Endereco();        
            e.setEstado(estado);
            e.setCidade(cidade);
            e.setCep(cep);
            e.setRua(nomeRua);
            e.setNumeroCasa(numeroCasa);
            e.setComplemento(complemento);
            e.setUsuario(idUsuario);
            
            EnderecoDAO ed = new EnderecoDAO();
            ed.inserirEndereco(e);        
            System.out.println("Id Usuario Check: " + Usuario.getIdUsuario());
           response.sendRedirect( "./cartaoController");
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
