/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BEAN.Carrinho;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {
    public boolean adicionar(Carrinho c){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO carrinho (produto, quantidade) values (?,?)");         
            
            
            stmt.setInt(1, c.getProduto());       
            stmt.setInt(2, c.getQuantidade());
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
