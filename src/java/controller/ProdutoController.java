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
public class ProdutoController extends HttpServlet {

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

        ProdutoDAO dao = new ProdutoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(Usuario.getIdUsuario() != 0){
            UsuarioDAO dao1 = new UsuarioDAO();
            List<Usuario> users = dao1.getUsuarioById(Usuario.getIdUsuario());
            request.setAttribute("usuario", users);
        }

        Produto produto = dao.readById(id);
        request.setAttribute("produto", produto);
        

        String imagemBase64 = null; // Defina como null por padrão
        if (produto.getImagemBytes() != null) {
            imagemBase64 = Base64.getEncoder().encodeToString(produto.getImagemBytes());
        }
        produto.setImagemBase64(imagemBase64);
        
        //serve para pegar as categorias no dropbutton do header
        CategoriaDAO cat = new CategoriaDAO();
        List<Categoria> categoria = cat.listarTodos();
        request.setAttribute("categorias", categoria);

        CarrinhoDAO carrinho = new CarrinhoDAO();
        if(carrinho.validaCarrinho(id)){
            request.setAttribute("erroMsg", "Você já possui este produto em seu carrinho, por favor acesse a página!");
        } else {
            request.setAttribute("erroMsg", null);
        }

        String url = "/WEB-INF/jsp/produtoUnico.jsp";
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
        String nextPage = "/WEB-INF/jsp/carrinho.jsp";
           
        if(url.equals("/inserir")){
            
            Carrinho c = new Carrinho();
            
            int id = Integer.parseInt(request.getParameter("idProduto"));
            
            String testeQTD = request.getParameter("quantidade");
            
            int qtd = (testeQTD == null || testeQTD.isEmpty()) ? 1 : Integer.parseInt(testeQTD);                       
                        
            c.setProduto(id);
            c.setQuantidade(qtd);
            
            
            System.out.println("Id: " + c.getProduto());
            System.out.println("QTD: "+ c.getQuantidade());
            
            
            CarrinhoDAO cd = new CarrinhoDAO();
            cd.adicionar(c);
            
            response.sendRedirect("./carrinho");
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
