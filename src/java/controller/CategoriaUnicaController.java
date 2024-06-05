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
import model.DAO.CategoriaDAO;
import model.DAO.ProdutoDAO;

@WebServlet(name = "CategoriaUnicaController", urlPatterns = {"/CategoriaUnica"})
public class CategoriaUnicaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/WEB-INF/jsp/categoriaUnica.jsp";
        String categoriaIdParam = request.getParameter("categoriaId");
        int categoriaId = 0;
        
        try {
            if (categoriaIdParam != null && !categoriaIdParam.isEmpty()) {
                categoriaId = Integer.parseInt(categoriaIdParam);
            } else {
                throw new NumberFormatException("ID da categoria não informado.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID da categoria inválido: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = categoriaDAO.readById(categoriaId);
        
        if (categoria != null) {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.listarPorCategoria(categoriaId);

            for (Produto produto : produtos) {
                if (produto.getImagemBytes() != null) {
                    String imagemBase64 = Base64.getEncoder().encodeToString(produto.getImagemBytes());
                    produto.setImagemBase64(imagemBase64);
                }
            }

            request.setAttribute("categoria", categoria);
            request.setAttribute("produtos", produtos);
        } else {
            request.setAttribute("error", "Categoria não encontrada.");
        }

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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
