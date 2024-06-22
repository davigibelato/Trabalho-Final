package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BEAN.Categoria;
import model.BEAN.Endereco;
import model.BEAN.Usuario;
import model.DAO.CategoriaDAO;
import model.DAO.EnderecoDAO;
import model.DAO.UsuarioDAO;

public class CheckoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/WEB-INF/jsp/checkout.jsp";

        if (Usuario.getIdUsuario() != 0) {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> users = dao.getUsuarioById(Usuario.getIdUsuario());
            request.setAttribute("usuario", users);
        }

        request.setAttribute("idUsuario", Usuario.getIdUsuario());

        // Serve para pegar as categorias no dropbutton do header
        CategoriaDAO cat = new CategoriaDAO();
        List<Categoria> categoria = cat.listarTodos();
        request.setAttribute("categorias", categoria);

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

        if (url.equals("/inserirEndereco")) {

            int idUsuario = Usuario.getIdUsuario();

            String estado = request.getParameter("estado");
            String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
            String nomeRua = request.getParameter("nomeRua");
            String complemento = request.getParameter("complemento");
            int numeroCasa = Integer.parseInt(request.getParameter("numeroCasa"));
            

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

            response.sendRedirect("./formaDePagamento");
            
        } else {
            RequestDispatcher d = getServletContext().getRequestDispatcher(url);
            d.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
