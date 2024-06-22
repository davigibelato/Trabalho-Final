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
import model.DAO.ProdutoPedidoDAO;
import model.DAO.UsuarioDAO;

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

        if (Usuario.getIdUsuario() != 0) {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> users = dao.getUsuarioById(Usuario.getIdUsuario());
            request.setAttribute("usuario", users);
        }

        UsuarioDAO ud = new UsuarioDAO();
        Usuario u = ud.pushCheckout();
        request.setAttribute("usuarios", u);

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

        if (end.isEmpty()) {
            request.setAttribute("errorMessage", "Você precisa adicionar um endereço antes de fazer um pedido.");
        }

        RequestDispatcher d = getServletContext().getRequestDispatcher(url);
        d.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getServletPath();
        String errorMessage = "";

        if (url.equals("/fazerPedido")) {
            Pedido p = new Pedido();

            int idUsuario = Usuario.getIdUsuario();
            p.setUsuario(Usuario.getIdUsuario());

            if (Endereco.getIdEnderecoAtual() == 0) {
                errorMessage = "Você precisa adicionar um endereço antes de fazer um pedido.";
            } else {
                p.setEndereco_entrega(Endereco.getIdEnderecoAtual());

                int valorFrete = p.getValorFrete();

                p.setValorTotal(total);
                p.getData_registro();
                p.setFormaDePagamento(Pedido.getFormaDePagamentoStatic());

                valorFrete = 20;
                p.setValorFrete(valorFrete);
                p.setValorTotal(total + valorFrete);

                PedidoDAO pd = new PedidoDAO();
                ProdutoPedidoDAO pdd = new ProdutoPedidoDAO();

                int idProduto = pd.inserir(p);
                pdd.inserirProduto(idProduto);

                request.setAttribute("valorFrete", valorFrete);

                response.sendRedirect("./home");
                return;
            }           
        } else if (url.equals("/validarCartaoCredito")) {
            
            Pedido.setFormaDePagamentoStatic("Cartão de Crédito");
            response.sendRedirect("./formaDePagamento");
            
            return;
            
        } else if (url.equals("/validarCartaoDebito")) {        
            
            Pedido.setFormaDePagamentoStatic("Cartão de Débito");
            response.sendRedirect("./formaDePagamento");
            
            return;
            
        } else if (url.equals("/mudarEndereco")) {
            
            EnderecoDAO edao = new EnderecoDAO();
            
            Endereco.setIdEnderecoAtual(Integer.parseInt(request.getParameter("idEndereco")));
            edao.mudarEnderecoPadrao(Integer.parseInt(request.getParameter("idEndereco")));
            
            response.sendRedirect("./formaDePagamento");
            return;
        }

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/formaDePagamento.jsp");
            d.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
