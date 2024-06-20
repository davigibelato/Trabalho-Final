package controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BEAN.Categoria;
import model.BEAN.Produto;
import model.BEAN.Usuario;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutoDAO;
import model.DAO.UsuarioDAO;

@WebServlet(name = "CategoriaUnicaController", urlPatterns = {"/CategoriaUnica"})
public class CategoriaUnicaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/WEB-INF/jsp/categoriaUnica.jsp";
        
        //serve para pegar as categorias no dropbutton do header
        CategoriaDAO cat = new CategoriaDAO();
        List<Categoria> categoria = cat.listarTodos();
        request.setAttribute("categorias", categoria);

        if(Usuario.getIdUsuario() != 0){
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> users = dao.getUsuarioById(Usuario.getIdUsuario());
            request.setAttribute("usuario", users);
        }
        
        ProdutoDAO pd = new ProdutoDAO();
        List<Produto> produto = pd.listarTodos();
        for (int i = 0; i < produto.size(); i++) {
            if (produto.get(i).getImagemBytes() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(produto.get(i).getImagemBytes());
                produto.get(i).setImagemBase64(imagemBase64);
            }
        }
        request.setAttribute("produtos", produto); 
        
        CategoriaDAO categoriaDao = new CategoriaDAO(); 
        request.setAttribute("categoriaNome", categoriaDao.readById(Categoria.getIdStaticoCategoria()));
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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
        
        if(url.equals("/irParaCategoria")){
            
            CategoriaDAO cd = new CategoriaDAO();
            
            Categoria c = new Categoria();
            Categoria.setIdStaticoCategoria(Integer.parseInt(request.getParameter("idCategoria")));
             response.sendRedirect("./CategoriaUnica");
          
            
            
        } else {
            processRequest(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
