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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.Endereco;
import model.BEAN.Usuario;

/**
 *
 * @author Davi
 */
public class EnderecoDAO {

    public boolean inserirEndereco(Endereco e) {
        String sql = "INSERT INTO endereco (estado, cidade, cep, rua, numero, complemento,usuario, enderecoPadrao) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, e.getEstado());
            stmt.setString(2, e.getCidade());
            stmt.setString(3, e.getCep());
            stmt.setString(4, e.getRua());
            stmt.setInt(5, e.getNumeroCasa());
            stmt.setString(6, e.getComplemento());
            stmt.setInt(7, e.getUsuario());
            if(validaEnderecoPadrao()){
                stmt.setBoolean(8, false);
            } else {
                stmt.setBoolean(8, true);
            }
            
            int aR = stmt.executeUpdate();

            //Verifica se tem algum insert no banco
            // Verifica se a instrução SQL de inserção afetou alguma linha.
            if (aR > 0) {
                // Bloco try-with-resources para garantir o fechamento automático do ResultSet.
                try (ResultSet pegarChave = stmt.getGeneratedKeys()) {

                    // Verifica se há uma chave gerada disponível.
                    if (pegarChave.next()) {
                        // Obtém o valor da chave gerada a partir do ResultSet.
                        int id = pegarChave.getInt(1);

                        // Define o ID atual do endereço usando o valor obtido.
                        Endereco.setIdEnderecoAtual(id);
                        System.out.println("Id do endereço: "+id);
                    }
                }
            }

            return true;

        } catch (SQLException ed) {
            ed.printStackTrace();
            return false;
        }
    }
    
    
    
    public boolean validaEnderecoPadrao(){
        
        boolean retorno = false;       
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * from  endereco WHERE usuario = ?");
            ResultSet rs = null;
            
            stmt.setInt(1, Usuario.getIdUsuario());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if(rs.getBoolean("enderecoPadrao"))retorno = true;
            }
            
            rs.close();
            stmt.close();
            conexao.close();           
            
            }catch(SQLException ed){
                ed.printStackTrace();
            
        }
        
        return retorno;
    }
    
    
     public boolean mudarEnderecoPadrao(int id){
        
        boolean retorno = false;       
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update endereco set enderecoPadrao = false WHERE usuario = ? AND enderecoPadrao = true");            

            stmt.setInt(1, Usuario.getIdUsuario());
            
            stmt.executeUpdate();
            stmt.close();
            
            stmt = conexao.prepareStatement("update endereco set enderecoPadrao = true WHERE idEndereco = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
         
            stmt.close();
            conexao.close();           
            
            }catch(SQLException ed){
                ed.printStackTrace();
            
        }
        
        return retorno;
    }
    
    
    public Endereco mostrarCheckout(){
        
        Endereco e = new Endereco();        
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT rua, cep, idEndereco FROM endereco WHERE usuario = ? AND enderecoPadrao = true");
            ResultSet rs = null;
            
            stmt.setInt(1, Usuario.getIdUsuario());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                e.setRua(rs.getString("rua"));
                e.setCep(rs.getString("cep"));
                Endereco.setIdEnderecoAtual(rs.getInt("idEndereco"));
            }
            
            rs.close();
            stmt.close();
            conexao.close();           
            
            }catch(SQLException ed){
                ed.printStackTrace();
            
        }
        
        return e;
    }
    
    
    
    
    public List<Endereco> visualizarEnderecos(){
        
        List<Endereco> e = new ArrayList();
        
        try{
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM endereco WHERE usuario = ?");
            ResultSet rs = null;
            
            stmt.setInt(1,Usuario.getIdUsuario());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Endereco endereco = new Endereco();
                
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCep(rs.getString("cep"));
                e.add(endereco);
                
            }
            rs.close();
            stmt.close();
            conexao.close();
            
        }catch(SQLException ed){
            ed.printStackTrace();
        }
        return e;
    }
}
