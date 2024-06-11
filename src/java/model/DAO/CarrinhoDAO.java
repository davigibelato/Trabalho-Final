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
import model.BEAN.Carrinho;
import model.BEAN.Usuario;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {

    public boolean adicionar(Carrinho c) {
        try {

            Connection conexao = Conexao.conectar();
            
            if(produtoJaAddCarrinho(c.getProduto(), Usuario.getIdUsuario())){
                return false;
            }
            
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO carrinho (produto, quantidade, usuario) values (?,?,?)");
            //FAZENDO INSERT NO CARRINHO          
            
            
            stmt.setInt(1, c.getProduto());
            stmt.setInt(2, c.getQuantidade());
            stmt.setInt(3, Usuario.getIdUsuario());

            stmt.executeUpdate();
            //EXECUTANDO A AÇÃO

            stmt.close();
            conexao.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Carrinho> visualizarCarrinho() {

        List<Carrinho> carrinhos = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(
                    "SELECT c.idCarrinho ,p.imagem AS imagem_produto, p.nome AS nome_produto, p.promocao AS promocao_produto, p.valor AS preco_produto, c.quantidade AS quantidade_pedido\n"
                    + "FROM carrinho c\n"
                    + "INNER JOIN produto p ON c.produto = p.idProduto\n"
                    + "WHERE c.usuario = ?;");

            stmt.setInt(1, Usuario.getIdUsuario());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Carrinho carrinho = new Carrinho();

                carrinho.setIdCarrinho(rs.getInt("idCarrinho"));

                Blob imagemBlob = rs.getBlob("imagem_produto");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    carrinho.setImagemBytes(imagemBytes);
                }
                carrinho.setNomeProduto(rs.getString("nome_produto"));
                float precoProduto = rs.getFloat("preco_produto");
                float promocaoProduto = rs.getFloat("promocao_produto");
                int quantidade = rs.getInt("quantidade_pedido");

                // Calculando o subtotal
                float subProduto = (precoProduto - promocaoProduto) * quantidade;

                // Definindo os valores no objeto Carrinho
                carrinho.setValorProduto(precoProduto - promocaoProduto);
                carrinho.setQuantidade(quantidade);
                carrinho.setSubProduto(subProduto);
                carrinho.setUsuario(Usuario.getIdUsuario());

                carrinhos.add(carrinho);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrinhos;
    }

    public void excluirProdutoUnico(int idCarrinho) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE idCarrinho = ?");

            stmt.setInt(1, idCarrinho);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluirTodos(int idUsuario) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE usuario = ?");

            stmt.setInt(1, idUsuario);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mudarQuantidade(int quantidade, int idCarrinho) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("UPDATE carrinho SET quantidade = ? WHERE idCarrinho = ?");
            
            stmt.setInt(1, quantidade);
            stmt.setInt(2, idCarrinho);
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    private boolean produtoJaAddCarrinho(int idProduto, int idUsuario){
        
        boolean produtoAdd = false;
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT COUNT(*) FROM carrinho WHERE produto = ? AND usuario = ?");
            
            stmt.setInt(1, idProduto);
            stmt.setInt(2, idUsuario);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next() && rs.getInt(1) > 0){
                produtoAdd = true;
            }
            
            rs.close();
            stmt.close();
            conexao.close();            
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return produtoAdd;
    }

}
