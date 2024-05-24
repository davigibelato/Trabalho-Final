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
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO carrinho (produto, quantidade, usuario) values (?,?,?)");
            //FAZENDO INSERT NO CARRINHO          

            stmt.setInt(1, c.getProduto());
            System.out.println(c.getProduto());
            stmt.setInt(2, c.getQuantidade());
            stmt.setInt(3, Usuario.getIdUsuario());
            System.out.println(Usuario.getIdUsuario());
            //PEGANDO INFORMAÇÕES E INSERINDO NO BANCO

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
                    "SELECT p.imagem AS imagem_produto ,p.nome AS nome_produto, p.promocao AS promocao_produto, p.valor AS preco_produto, c.quantidade AS quantidade_pedido\n"
                    + "FROM carrinho c\n"
                    + "INNER JOIN produto p ON c.produto = p.idProduto\n"
                    + "WHERE c.usuario = ?;");
            
            //PEGA AS INFORMAÇÕES NESSESÁRIAS PARA SER MOSTRADAS NA PÁGINA DE CARRINHO
            
            stmt.setInt(1, Usuario.getIdUsuario());
            //PEGA AS INFOS COM BASE NO ID DO USUARIO, FAZENDO ASSIM QUE UM CARRINHO FIQUE SOMENTE PARA ELE

            ResultSet rs = stmt.executeQuery();
            //EXECUTA O SELECT

            while (rs.next()) {
                
                Carrinho carrinho = new Carrinho();   
                Blob imagemBlob = rs.getBlob("imagem_produto");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    carrinho.setImagemBytes(imagemBytes);
                }
                carrinho.setNomeProduto(rs.getString("nome_produto"));
                carrinho.setValorProduto(rs.getFloat("preco_produto")  - rs.getInt("promocao_produto"));
                carrinho.setQuantidade(rs.getInt("quantidade_pedido"));
                carrinho.setUsuario(Usuario.getIdUsuario());
                //PEGA IMAGEM, NOME DO PRODUTO, PREÇO DO PRODUTO, QUANTIDADE E O ID DO USUARIO             
                carrinhos.add(carrinho);
                //ADICIONA A LISTA AO CARRINHO
            }

            //FECHA OS TERMOS
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrinhos;
    }

}