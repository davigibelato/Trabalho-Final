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
import model.BEAN.Endereco;
import model.BEAN.Pedido;
import model.BEAN.Produto;
import model.BEAN.Usuario;
import model.DAO.CarrinhoDAO;
import model.DAO.EnderecoDAO;
import model.DAO.PedidoDAO;
import model.DAO.ProdutoDAO;
import model.DAO.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class FormaDePagamentoController extends HttpServlet {
    
    float total = 0;
    
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
        
        total = 0;
        
        String url = "/WEB-INF/jsp/formaDePagamento.jsp";

        CarrinhoDAO cd = new CarrinhoDAO();
        List<Carrinho> carrinho = cd.visualizarCarrinho();
        
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i).getImagemBytes() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(carrinho.get(i).getImagemBytes());
                carrinho.get(i).setImagemBase64(imagemBase64);
            }
        }        

        request.setAttribute("carrinhos", carrinho);
        
        
        UsuarioDAO ud = new UsuarioDAO();
        Usuario u = ud.pushCheckout();
        request.setAttribute("usuario", u);
        
        EnderecoDAO ed = new EnderecoDAO();
        Endereco e = ed.mostrarCheckout();
        request.setAttribute("endereco", e);
        
        Pedido p = new Pedido();       
        
        for (Carrinho c : carrinho) {
            total += c.getSubProduto();
        }               
        request.setAttribute("total", total);

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
        processRequest(request, response);
        
        
        String url = request.getServletPath();
        
        if(url.equals("/fazerPedido")){
            
            Pedido p = new Pedido();
            
            int idUsuario = Usuario.getIdUsuario();            
            System.out.println("O id do usuario é: "+idUsuario);
            p.setUsuario(Usuario.getIdUsuario());
            
            System.out.println("o id do endereço é: "+Endereco.getIdEnderecoAtual());
            p.setEndereco_entrega(Endereco.getIdEnderecoAtual());            
            
            p.setValorTotal(total);
            p.getData_registro();
            PedidoDAO pd = new PedidoDAO();
            
            pd.inserir(p);
        }    
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
