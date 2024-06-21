/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BEAN.Categoria;
import model.BEAN.Usuario;
import model.DAO.CategoriaDAO;
import model.DAO.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class LoginController extends HttpServlet {

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

        String url = "/WEB-INF/jsp/login.jsp";
        System.out.println("Id Usuario: " + Usuario.getIdUsuario());
        

        
        //serve para pegar as categorias no dropbutton do header
        CategoriaDAO cat = new CategoriaDAO();
        List<Categoria> categoria = cat.listarTodos();
        request.setAttribute("categorias", categoria);

        RequestDispatcher d = getServletContext().getRequestDispatcher(url);
        d.forward(request, response);

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

        String url = request.getServletPath();

        if ("/logar".equals(url)) {

            String email = request.getParameter("email");
            String password = request.getParameter("senha");
            String errorMessage = "";

            if (isEmpty(email) || isEmpty(password)) {
                
                errorMessage = "Por favor, preencha todos os campos.";
                
            } else if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
                
                response.sendRedirect("./CadastrarProduto");                
                return;
                
            } else {
                
                Usuario user = new Usuario();
                user.setEmail(email);
                user.setSenha(password);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario userAutenticado = usuarioDAO.login(user);

                if (userAutenticado != null && !isEmpty(userAutenticado.getEmail())) {
                    
                    response.sendRedirect("./home");                    
                    return;
                    
                } else {
                    errorMessage = "Email ou senha inválidos";
                }
            }

            if (errorMessage != null) {
                request.setAttribute("errorMessage", errorMessage);
            }

            forwardToPage(request, response, "/WEB-INF/jsp/login.jsp");
            
            
        }else if(url.equals("/sair")){
            Usuario.setIdUsuario(0);
            response.sendRedirect(request.getContextPath() + "/login");
        }
        else {
            
            processRequest(request, response);
        }
    }

    private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
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
