/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BEAN.Carrinho;
import model.BEAN.Categoria;
import model.BEAN.Pedido;
import model.BEAN.Produto;
import model.BEAN.Usuario;
import model.DAO.CarrinhoDAO;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutoDAO;
import model.DAO.UsuarioDAO;

/**
 *
 * @author Davi
 */
public class CarrinhoController extends HttpServlet {

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
        
        //serve para pegar as categorias no dropbutton do header
        CategoriaDAO cat = new CategoriaDAO();
        List<Categoria> categoria = cat.listarTodos();
        request.setAttribute("categorias", categoria);


        String url = "/WEB-INF/jsp/carrinho.jsp";

        CarrinhoDAO cd = new CarrinhoDAO();
        List<Carrinho> carrinho = cd.visualizarCarrinho();
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i).getImagemBytes() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(carrinho.get(i).getImagemBytes());
                carrinho.get(i).setImagemBase64(imagemBase64);
            }
        }

        request.setAttribute("carrinhos", carrinho);

        float total = 0;

        for (Carrinho c : carrinho) {
            total += c.getSubProduto();
        }

        request.setAttribute("total", total);

        System.out.println(total);

        request.setAttribute("idUsuario", Usuario.getIdUsuario());
        
        if(Usuario.getIdUsuario() != 0) {
            UsuarioDAO u = new UsuarioDAO();
            List<Usuario> usuarios = u.getUsuarioById(2);
            request.setAttribute("usuarios", usuarios);
            System.out.println("Usuario Lista:"+usuarios);
        }

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

        if (url.equals("/excluirProdutoUnico")) {

            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
            System.out.println("ID do Carrinho" + idCarrinho);

            CarrinhoDAO cd = new CarrinhoDAO();
            cd.excluirProdutoUnico(idCarrinho);

            response.sendRedirect("./carrinho");

        } else if (url.equals("/excluirTodos")) {

            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            CarrinhoDAO cd = new CarrinhoDAO();
            cd.excluirTodos(idUsuario);

            response.sendRedirect("./carrinho");

        } else if (url.equals("/aumentarQTD")) {

            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
            int qtd = Integer.parseInt(request.getParameter("quantidade"));

            CarrinhoDAO cdd = new CarrinhoDAO();
            cdd.mudarQuantidade(qtd, idCarrinho);

            response.sendRedirect("./carrinho");

        } else if (url.equals("/diminuirQTD")) {

            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
            int qtd = Integer.parseInt(request.getParameter("quantidade"));

            CarrinhoDAO cdd = new CarrinhoDAO();

            if (qtd <= 0) {

                cdd.excluirProdutoUnico(idCarrinho);
                response.sendRedirect("./carrinho");

            } else {
                cdd.mudarQuantidade(qtd, idCarrinho);
                response.sendRedirect("./carrinho");
            }

        } else if (url.equals("/continuarCompra")) {

            url = "/WEB-INF/jsp/checkout.jsp";
            

            RequestDispatcher d = getServletContext().getRequestDispatcher(url);
            d.forward(request, response);
            
        }else if(url.equals("/calcularFrete")){
            
            
            Pedido p = new Pedido();
            p.getValorFrete();
            
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
