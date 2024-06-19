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
import model.BEAN.Endereco;
import model.BEAN.Pedido;
import model.BEAN.Produto;
import model.BEAN.ProdutoPedido;
import model.BEAN.Usuario;
import model.DAO.CarrinhoDAO;
import model.DAO.CategoriaDAO;
import model.DAO.EnderecoDAO;
import model.DAO.PedidoDAO;
import model.DAO.ProdutoDAO;
import model.DAO.ProdutoPedidoDAO;
import model.DAO.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class FormaDePagamentoController extends HttpServlet {

    float total = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        total = 0;
        System.out.println("Id Usuario: " + Usuario.getIdUsuario());
        String url = "/WEB-INF/jsp/formaDePagamento.jsp";

        CarrinhoDAO cd = new CarrinhoDAO();
        List<Carrinho> carrinho = cd.visualizarCarrinho();
        
        //serve para pegar as categorias no dropbutton do header
        CategoriaDAO cat = new CategoriaDAO();
        List<Categoria> categoria = cat.listarTodos();
        request.setAttribute("categorias", categoria);


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

        List<Endereco> end = ed.visualizarEnderecos();
        request.setAttribute("enderecos", end);

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

        if (url.equals("/fazerPedido")) {

            Pedido p = new Pedido();

            int idUsuario = Usuario.getIdUsuario();
            System.out.println("O id do usuario é: " + idUsuario);
            p.setUsuario(Usuario.getIdUsuario());

            System.out.println("o id do endereço é: " + Endereco.getIdEnderecoAtual());
            p.setEndereco_entrega(Endereco.getIdEnderecoAtual());

            p.setValorTotal(total);
            p.getData_registro();
            p.setFormaDePagamento(Pedido.getFormaDePagamentoStatic());
            int valorFrete = p.getValorFrete();
            valorFrete = 20;
            p.setValorFrete(valorFrete);
            p.setValorTotal(total + valorFrete);
            PedidoDAO pd = new PedidoDAO();
            ProdutoPedidoDAO pdd = new ProdutoPedidoDAO();

            int idProduto = pd.inserir(p);
            pdd.inserirProduto(idProduto);

            request.setAttribute("valorFrete", valorFrete);

            response.sendRedirect("./home");
        } else if (url.equals("/validarCartaoCredito")) {
            //Metodo escolhido cartao credito

            Pedido.setFormaDePagamentoStatic("Cartão de Crédito");
            response.sendRedirect("./formaDePagamento");

        } else if (url.equals("/validarCartaoDebito")) {
            //Metodo escolhido cartao Debito

            Pedido.setFormaDePagamentoStatic("Cartão de Débito");
            response.sendRedirect("./formaDePagamento");

        } else if (url.equals("/mudarEndereco")) {

            EnderecoDAO edao = new EnderecoDAO();

            Endereco.setIdEnderecoAtual(Integer.parseInt(request.getParameter("idEndereco")));
            edao.mudarEnderecoPadrao(Integer.parseInt(request.getParameter("idEndereco")));

            System.out.println("O id do endereco é: " + Endereco.getIdEnderecoAtual());
            response.sendRedirect("./formaDePagamento");

        } else {
            processRequest(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
