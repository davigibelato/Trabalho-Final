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

import model.BEAN.Endereco;

/**
 *
 * @author Davi
 */
public class EnderecoDAO {
    
    public boolean inserirEndereco(Endereco e){
        
        try{            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO endereco (estado, cidade, cep, rua, numero, complemento) VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1, e.getEstado());
            stmt.setString(2, e.getCidade());
            stmt.setInt(3, e.getCep());
            stmt.setString(4, e.getRua());
            stmt.setInt(5, e.getNumeroCasa());
            stmt.setString(6, e.getComplemento());
            
            stmt.executeUpdate();
                                    
            stmt.close();
            conexao.close();
            
            return true;
            
        }catch(SQLException ed){            
            ed.printStackTrace();
            return false;
        }
    }
}
