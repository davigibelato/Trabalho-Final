/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BEAN.Categoria;
import model.BEAN.Produto;

/**
 *
 * @author Senai
 */
public class ProdutoDAO {

    public List<Produto> listarTodosDisponiveis() {
        List<Produto> produtos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM produto AS p INNER JOIN estoque AS e ON p.idProduto = e.produto WHERE e.quantidade > 0";
            //faz um select na tabela de produto de acordo com a quantidade de itens adicionados no estoque
            
            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }

    public List<Produto> listarTodos() {
        
        List<Produto> produtos = new ArrayList();

        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM produto";

            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }
    
    public List<Produto> listarPromo() {
        
        List<Produto> produtos = new ArrayList();

        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM produto where promocao > 0";

            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setPromocao(rs.getFloat("promocao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
              
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }
    
     public List<Produto> listarPromo8() {
        
        List<Produto> produtos = new ArrayList();

        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM produto where promocao > 0";

            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setPromocao(rs.getFloat("promocao"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                if(i < 9)produtos.add(p);
                i++;
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }
    
     public List<Produto> listarSemPromo() {
         
        List<Produto> produtos = new ArrayList();

        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM produto where promocao = 0";

            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setPromocao(rs.getFloat("promocao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
              
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }
     
      public List<Produto> listarSemPromo8() {
         
        List<Produto> produtos = new ArrayList();

        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM produto where promocao = 0";

            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setPromocao(rs.getFloat("promocao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                if(i < 9)produtos.add(p);
                i++;
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }
    
    public List<Produto> listarPorCategoria(int categoriaId) {
    List<Produto> produtos = new ArrayList<>();
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT * FROM produto WHERE categoria = 1";

        stmt = conexao.prepareStatement(query);
        stmt.setInt(1, categoriaId);

        rs = stmt.executeQuery();

        while (rs.next()) {
            Produto p = new Produto();
            p.setIdProduto(rs.getInt("idProduto"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getFloat("valor"));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setDescricao(rs.getString("descricao"));
            p.setCategoria(rs.getInt("categoria"));
            p.setSubCategoria(rs.getInt("subCategoria"));

            Blob imagemBlob = rs.getBlob("imagem");
            if (imagemBlob != null) {
                byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                p.setImagemBytes(imagemBytes);
            }
            produtos.add(p);
        }
        rs.close();
        stmt.close();
        conexao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return produtos;
}


    public List<Produto> listarPorPesquisa(String search) {
        
        List<Produto> produtos = new ArrayList();
        
        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE nome LIKE '%?%'");
            stmt.setString(1, search);

            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }

    public void delete(int id) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean inserirProduto(Produto produto) {
        
        try (Connection conexao = Conexao.conectar();
                PreparedStatement ps = conexao.prepareStatement("INSERT INTO produto (nome, valor, descricao, categoria, subCategoria, imagem,promocao, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?,?)")) {

            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getValor());
            ps.setString(3, produto.getDescricao());
            ps.setInt(4, produto.getCategoria());
            ps.setInt(5, produto.getSubCategoria());
            ps.setBytes(6, produto.getImagemBytes()); 
            ps.setFloat(7, produto.getPromocao()); 
            ps.setInt(8, produto.getQuantidade());

            int linhasAfetadas = ps.executeUpdate();
            
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Produto readById(int id) {
    Produto p = null;

    try (Connection conexao = Conexao.conectar();
         PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE idProduto = ?")) {

        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPromocao(rs.getFloat("promocao")); // Adicionar esta linha para pegar o valor da promoção
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return p;
}


    public List<Produto> buscarProdutos(String busca) {
        
        //Resultado final das buscas
        List<Produto> resultadoBusca = new ArrayList<>();
        
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //Busca o nome pesquisado na tabela produtos
            stmt = conexao.prepareStatement("SELECT p.*, c.nome as categoria, sc.nome as subCategoria "
                    + "FROM produto p "
                    + "INNER JOIN categoria c ON p.categoria = c.idCategoria "
                    + "INNER JOIN subCategoria sc ON p.subCategoria = sc.idSubCategoria "
                    + "WHERE p.nome LIKE ?");
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getInt("categoria"));
                p.setSubCategoria(rs.getInt("subCategoria"));
                
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }

                System.out.println("Categoria: " + rs.getInt("categoria"));
                System.out.println("Subcategoria: " + rs.getInt("subCategoria"));

                resultadoBusca.add(p);
            }            

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultadoBusca;
    }

}
