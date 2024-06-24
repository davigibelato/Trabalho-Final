package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BEAN.Categoria;
import model.BEAN.Produto;
import model.BEAN.SubCategoria;
import model.BEAN.Usuario;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutoDAO;
import model.DAO.SubCategoriaDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CadastroProdutoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categoria = dao.listarTodos();
        request.setAttribute("categorias", categoria);

        SubCategoriaDAO subId = new SubCategoriaDAO();
        List<SubCategoria> subCategoria = subId.listarTodos();
        request.setAttribute("subCategorias", subCategoria);

        ProdutoDAO daoId = new ProdutoDAO();
        List<Produto> produto = daoId.listarTodos();
        request.setAttribute("produtos", produto);

        String url = "/WEB-INF/jsp/cadastrarProduto.jsp";
        RequestDispatcher d = getServletContext().getRequestDispatcher(url);
        d.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        
        if (url.equals("/cadastrarProduto")) {
            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                Produto produto = new Produto();
                String errorMessage = null;

                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
                        switch (fieldName) {
                            case "nome":
                                if (fieldValue == null || fieldValue.isEmpty()) {
                                    errorMessage = "Nome do produto é obrigatório.";
                                } else {
                                    produto.setNome(fieldValue);
                                }
                                break;
                            case "valor":
                                try {
                                    produto.setValor(Float.parseFloat(fieldValue));
                                } catch (NumberFormatException e) {
                                    errorMessage = "Valor do produto é inválido.";
                                }
                                break;
                            case "promocao":
                                try {
                                    produto.setPromocao(Float.parseFloat(fieldValue));
                                } catch (NumberFormatException e) {
                                    errorMessage = "Valor de promoção é inválido.";
                                }
                                break;
                            case "descricao":
                                if (fieldValue == null || fieldValue.isEmpty()) {
                                    errorMessage = "Descrição do produto é obrigatória.";
                                } else {
                                    produto.setDescricao(fieldValue);
                                }
                                break;
                            case "categoria":
                                produto.setCategoria(Integer.parseInt(fieldValue));
                                break;
                            case "subCategoria":
                                produto.setSubCategoria(Integer.parseInt(fieldValue));
                                break;
                        }
                    } else {
                        InputStream inputStream = item.getInputStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        byte[] imagemBytes = outputStream.toByteArray();
                        produto.setImagemBytes(imagemBytes);
                        inputStream.close();
                        outputStream.close();
                    }
                }

                if (errorMessage != null) {
                    request.setAttribute("errorMessage", errorMessage);
                    processRequest(request, response);
                } else {
                    ProdutoDAO dao = new ProdutoDAO();
                    boolean sucesso = dao.inserirProduto(produto);
                    if (sucesso) {
                        redirectToSuccessPage(request, response);
                    } else {
                        request.setAttribute("errorMessage", "Erro ao cadastrar o produto.");
                        processRequest(request, response);
                    }
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request.", e);
            }
        } else if (url.equals("/deslogar")) {
            Usuario.setIdUsuario(0);
            response.sendRedirect("./login");
        } else {
            redirectToIndexPage(request, response);
        }
    }

    private void redirectToSuccessPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/listarProdutos");
    }

    private void redirectToIndexPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/cadastrarProduto.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
